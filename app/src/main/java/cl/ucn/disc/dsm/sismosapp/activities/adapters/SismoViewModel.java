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

package cl.ucn.disc.dsm.sismosapp.activities.adapters;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import cl.ucn.disc.dsm.sismosapp.model.Sismo;
import cl.ucn.disc.dsm.sismosapp.services.SismosService;
import cl.ucn.disc.dsm.sismosapp.services.sismosapi.SismosApiService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SismoViewModel extends ViewModel {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(SismoViewModel.class);


  /**
   * The {@link List} of {@link Sismo} to provide.
   */
  private final MutableLiveData<List<Sismo>> theSismos = new MutableLiveData<>();

  /**
   * The Exception in case of error.
   */
  private final MutableLiveData<Exception> theException = new MutableLiveData<>();


  /**
   * The provider of {@link Sismo}.
   */
  private SismosService sismosService = new SismosApiService();

  /**
   * LiveData of Noticias to use in the view.
   *
   * @return the List of Sismos inside a LiveData.
   */
  public LiveData<List<Sismo>> getSismos() {
    return this.theSismos;
  }

  /**
   * LiveData of Exception to use in the view.
   *
   * @return the Exception in case of error.
   */
  public LiveData<Exception> getException() {
    return this.theException;
  }


  /**
   * Update the internal list of Noticias.
   *
   * <p>NOTE: Need to run in background.</p>
   *
   * @return the number of noticias loaded.
   */
  public int refresh() {

    try {

      // 1. Get the list of Sismos from ChileAlertaApi
      final List<Sismo> sismos = this.sismosService.getSismos();

      // 2. Set the values (NEED to be in background)
      this.theSismos.postValue(sismos);

      // 3. All ok!
      return sismos.size();

    } catch (final Exception ex) {

      log.error("Error", ex);

      // 2. Set the exception
      this.theException.postValue(ex);

      // 3. All error!
      return -1;

    }

  }



}
