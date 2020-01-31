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

    this.binding.tvMagnitude.setText(String.valueOf(sismo.getMagnitude()));
    this.binding.tvReference.setText(sismo.getReference());
    this.binding.tvLatitude.setText(String.valueOf(sismo.getLatitude()));
    this.binding.tvLongitude.setText(String.valueOf(sismo.getLongitude()));
    this.binding.tvScale.setText(sismo.getScale());
    this.binding.tvSource.setText(sismo.getSource());
    this.binding.tvUrl.setText(sismo.getUrl());
    this.binding.tvChileanDate.setText(sismo.getChileanTime());

  }


}
