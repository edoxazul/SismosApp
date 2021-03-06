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
import cl.ucn.disc.dsm.sismosapp.services.SingletonSismos;
import cl.ucn.disc.dsm.sismosapp.services.SismosService;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
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

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(SismosApiService.class);


  /**
   * The SismosApi.
   */
  private final SismosApi sismosApi;

  /**
   * The Constructor.
   */
  public SismosApiService() {

    // Logging with slf4j
    final HttpLoggingInterceptor loggingInterceptor =
        new HttpLoggingInterceptor(log:: debug).setLevel(Level.BODY);

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


  /**
   *  Get the Sismos from the Call.
   *
   * @param theCall to use.
   * @return the {@link List} of {@link Sismo}.
   */
  private List<Sismo> getSismosFromCall(Call<SismosApiResult> theCall) {

    try {

      // Get the result from the call
      final Response<SismosApiResult> response = theCall.execute();

      // UnSuccessful !
      if (!response.isSuccessful()) {

        // Error!
        throw new SismosApiException(
            "Can't get the SismosResult, code: " + response.code(),
            new HttpException(response)
        );

      }

      final SismosApiResult theResult = response.body();

      // No body
      if (theResult == null) {
        throw new SismosApiException("SismosResult was null");
      }

      return theResult.ultimos_sismos;


    } catch (final IOException ex) {
      throw new SismosApiException("Can't get the SismosResult", ex);
    }


  }


  /**
   * The Exception.
   */
  public static final class SismosApiException extends RuntimeException {

    public SismosApiException(final String message) {
      super(message);
    }

    public SismosApiException(final String message, final Throwable cause) {
      super(message, cause);
    }

  }

  /**
   * The getSismos.
   * @return the {@link List} of {@link Sismo}.
   */
  @Override
  public List<Sismo> getSismos(final int limit) {

    //String select = Select.ultimos_sismos.toString();
    //String country = Country.Chile.toString();

    final Call<SismosApiResult> theCall = this.sismosApi.getUltimosSismos("ultimos_sismos");

    return getSismosFromCall(theCall);
  }
  //  /**
  //   * The Country.
  //   */
  //  public enum Country {
  //    Chile
  //  }
  //
  //  /**
  //   * The Select.
  //   */
  //
  //  public enum Select {
  //    ultimos_sismos
  //  }


}
