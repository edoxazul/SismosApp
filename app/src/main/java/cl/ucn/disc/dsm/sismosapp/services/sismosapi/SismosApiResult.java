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
import java.util.ArrayList;
import java.util.List;

/**
 * The SismosApiResult class.
 * @author Eduardo Alvarez S.
 */
public class SismosApiResult {

  public Metadata metadata;
  public List<Sismo> ultimosSismosChile = new ArrayList<>();

}
