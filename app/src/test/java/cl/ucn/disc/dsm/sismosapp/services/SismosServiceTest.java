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
import cl.ucn.disc.dsm.sismosapp.services.sismosapi.SismosApiService;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The test of the SismosService.
 *
 * @author Eduardo Alvarez S.
 */
public class SismosServiceTest {

  private static final Logger log = LoggerFactory.getLogger(SismosService.class);

@Test
public void testGetSismosApi(){


    log.debug("Testing the SismosApiService, requesting Sismos.");

  // The Sismos service.
  final SismosService sismosService = new SismosApiService();

  // The List of Sismos.
  final List<Sismo> sismos = sismosService.getSismos();

    Assertions.assertNotNull(sismos);
    //Assertions.assertEquals(sismos.size(), size, "Error de tamanio");

    for (final Sismo sismo : sismos) {
    log.debug("Sismo: {}.", sismo);
  }

    log.debug("Done.");

}


}
