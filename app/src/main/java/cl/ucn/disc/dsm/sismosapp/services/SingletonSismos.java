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

package cl.ucn.disc.dsm.sismosapp.services;

import cl.ucn.disc.dsm.sismosapp.services.sismosapi.SismosApi;
import com.squareup.okhttp.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SingletonSismos {

  private static SismosApi REST_CLIENT;


  private SingletonSismos(){
  }

  public static SismosApi get(){
    return REST_CLIENT;
  }








}
