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

package cl.ucn.disc.dsm.sismosapp.activities;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import cl.ucn.disc.dsm.sismosapp.activities.adapters.SismoAdapter;
import cl.ucn.disc.dsm.sismosapp.activities.adapters.SismoViewModel;
import cl.ucn.disc.dsm.sismosapp.databinding.ActivityMainBinding;
import es.dmoral.toasty.Toasty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MainActivity extends AppCompatActivity {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(MainActivity.class);

  /**
   * The bindings.
   */
  private ActivityMainBinding binding;

  /**
   * The Adapter.
   */
  private SismoAdapter sismoAdapter;


  /**
   * The ViewModel of Sismo.
   */
  private SismoViewModel sismoViewModel;

  /**
   * The onCreate.
   *
   * @param savedInstanceState to use.
   */
  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //setContentView(R.layout.activity_main);

    // Inflate the layout
    this.binding = ActivityMainBinding.inflate(getLayoutInflater());

    // Assign to the main view.
    setContentView(binding.getRoot());

    // Set the toolbar
    {
      this.setSupportActionBar(binding.toolbar);
    }

    // The Adapter + RecyclerView
    {
      // The Adapter
      this.sismoAdapter = new SismoAdapter();

      // The Adapter
      this.binding.rvSismos.setAdapter(this.sismoAdapter);

      // The layout (ListView)
      this.binding.rvSismos.setLayoutManager(new LinearLayoutManager(this));

      // The separator (line)
      this.binding.rvSismos
          .addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
    }

    // The ViewModel
    {
      // Build the SismoViewModel.
      this.sismoViewModel = new ViewModelProvider(this).get(SismoViewModel.class);

      // Observe the list of sismo
      this.sismoViewModel.getSismos().observe(this,
          sismos -> this.sismoAdapter.setSismos(sismos));

      // Observe the exception
      this.sismoViewModel.getException().observe(this, this:: showException);

    }

    // The refresh
    {
      this.binding.swlRefresh.setOnRefreshListener(() -> {
        log.debug("Refreshing ..");

        //Run in background
        AsyncTask.execute(() -> {

          // All ok
          final int size = this.sismoViewModel.refresh();
          if (size != -1) {

            // In the UI
            runOnUiThread(() -> {

              // Hide the loading
              this.binding.swlRefresh.setRefreshing(false);

              // Show a message.
              Toasty.success(this, "Sismos fetched: "
                  + size, Toast.LENGTH_SHORT, true).show();

            });
          }

        });

      });
    }


  }

  /**
   * Show the exception.
   *
   * @param exception to use.
   */
  private void showException(final Exception exception) {

    // Hide the loading
    this.binding.swlRefresh.setRefreshing(false);

    // Build the message
    final StringBuilder sb = new StringBuilder("Error: ");
    sb.append(exception.getMessage());
    if (exception.getCause() != null) {
      sb.append(", ");
      sb.append(exception.getCause().getMessage());
    }

    Toasty.error(this, sb.toString(), Toast.LENGTH_LONG, true).show();

  }


}