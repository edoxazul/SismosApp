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

import androidx.recyclerview.widget.RecyclerView;
import cl.ucn.disc.dsm.sismosapp.databinding.RowSismoBinding;
import cl.ucn.disc.dsm.sismosapp.model.Sismo;

public class SismoViewHolder extends RecyclerView.ViewHolder {

  /**
   * The Bindings.
   */
  private final RowSismoBinding binding;

  /**
   * The Constructor.
   *
   * @param rowSismoBinding  to use.
   */
  public SismoViewHolder(RowSismoBinding rowSismoBinding) {
    super(rowSismoBinding.getRoot());
    this.binding = rowSismoBinding;
  }

  /**
   * Bind the Noticia to the ViewHolder.
   *
   * @param sismo to bind.
   */
  public void bind(final Sismo sismo) {

    final String latitude = String.valueOf(sismo.getLatitude());
    final String longitude = String.valueOf(sismo.getLongitude());
    final String scale = String.valueOf(sismo.getScale());
    final String source = String.valueOf(sismo.getSource());
    final String timeutc = String.valueOf(sismo.getUtcTime());





    this.binding.tvMagnitude.setText(String.valueOf(sismo.getMagnitude()));
    this.binding.tvReference.setText(sismo.getReference());
    this.binding.tvLatitude.setText(
        new StringBuilder().append("Latitude : ").append(latitude).toString());
    this.binding.tvLongitude.setText(new StringBuilder().append("Longitude : ")
        .append(longitude).toString());
    this.binding.tvScale.setText(new StringBuilder().append("Scale : ")
        .append(scale).toString());
    this.binding.tvSource.setText(new StringBuilder().append("Source : ")
        .append(source).toString());
    this.binding.tvChileanDate.setText(new StringBuilder().append("Time UTC : ")
        .append(timeutc).toString());

  }


}
