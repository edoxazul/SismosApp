/*
 * Copyright [2020] [Eduardo Alvarez S]
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cl.ucn.disc.dsm.sismosapp.services.sismosapi;

import cl.ucn.disc.dsm.sismosapp.model.Sismo;
import cl.ucn.disc.dsm.sismosapp.services.SismosService;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.logging.HttpLoggingInterceptor;
import okhttp3.logging.HttpLoggingInterceptor.Level;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import retrofit2.Call;
import retrofit2.HttpException;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public final class SismosApiService implements SismosService {

  private static final Logger log = LoggerFactory.getLogger(SismosApiService.class);


  private final SismosApi sismosApi;

  public SismosApiService ( ) {

    // Logging with slf4j
    final HttpLoggingInterceptor loggingInterceptor =
        new HttpLoggingInterceptor(log :: debug).setLevel(Level.BODY);

    // Web Client
    final OkHttpClient httpClient = new Builder()
        .connectTimeout(5, TimeUnit.SECONDS)
        .writeTimeout(5, TimeUnit.SECONDS)
        .readTimeout(5, TimeUnit.SECONDS)
        .callTimeout(10, TimeUnit.SECONDS)
        .addNetworkInterceptor(loggingInterceptor)
        .build();

    // https://futurestud.io/tutorials/retrofit-getting-started-and-android-client
    this.sismosApi = new Retrofit.Builder()
        // The main URL
        .baseUrl(SismosApi.BASE_URL)
        // JSON to POJO
        .addConverterFactory(GsonConverterFactory.create())
        // Validate the interface
        .validateEagerly(true)
        // The client
        .client(httpClient)
        // Build the Retrofit ..
        .build()
        // .. get the ChileAlerta api.
        .create(SismosApi.class);
  }

  private List<Sismo> getSismosFromCall (Call<SismosApiResult> theCall) {

    try {

      // Get the result from the call
      final Response<SismosApiResult> response = theCall.execute();

      // UnSuccessful !
      if (!response.isSuccessful()) {

        // Error!
        throw new sismosApiException(
            "Can't get the SismosResult, code: " + response.code(),
            new HttpException(response)
        );

      }

      final SismosApiResult theResult = response.body();

      // No body
      if (theResult == null) {
        throw new sismosApiException("SismosResult was null");
      }

      return theResult.ultimosSismosChile;


    } catch (final IOException ex) {
      throw new sismosApiException("Can't get the SismosResult", ex);
    }


  }


  /**
   * The Exception.
   */
  public static final class sismosApiException extends RuntimeException {

    public sismosApiException (final String message) {
      super(message);
    }

    public sismosApiException (final String message, final Throwable cause) {
      super(message, cause);
    }

  }

  @Override
  public List<Sismo> getSismos() {

    String select = Select.ultimos_sismos.toString();
    String country = Country.chile.toString();

    final Call<SismosApiResult> theCall = this.sismosApi.getUltimosSismos(select, country);

    return getSismosFromCall(theCall);
  }

  public enum Country {
    chile
  }

  public enum Select {
    ultimos_sismos
  }


}
