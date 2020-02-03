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

import cl.ucn.disc.dsm.sismosapp.model.Sismo;

public class SingletonSismos {

  private static Sismo ultimos_sismos;


  private SingletonSismos(){


  }

  /**
   * The Get Ultimos Sismos.
   * @param sismo , for sismos.
   * @return Sismo.
   */

  public static Sismo getUltimos_sismos(final Sismo sismo) {


    return new Sismo(
        sismo.state,
        sismo.utcTime,
        sismo.localTime,
        sismo.chilean_time,
        sismo.reference,
        sismo.magnitude,
        sismo.scale,
        sismo.latitude,
        sismo.longitude,
        sismo.depth,
        sismo.id,
        sismo.url,
        sismo.source);
  }








}
