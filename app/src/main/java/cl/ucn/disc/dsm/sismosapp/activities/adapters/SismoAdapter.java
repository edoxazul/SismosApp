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

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import cl.ucn.disc.dsm.sismosapp.databinding.RowSismoBinding;
import cl.ucn.disc.dsm.sismosapp.model.Sismo;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SismoAdapter extends RecyclerView.Adapter<SismoViewHolder> {

  /**
   * The Logger.
   */
  private static final Logger log = LoggerFactory.getLogger(SismoAdapter.class);

  private List<Sismo> theSismos;

  /**
   * The Constructor.
   */
  public SismoAdapter() {

    // The Empty List
    this.theSismos = new ArrayList<>();

    // Each Sismo has unique id
    this.setHasStableIds(true);
  }

  /**
   * Change the current List of Sismos.
   *
   * @param sismos to use.
   */
  public void setSismos(final List<Sismo> sismos) {

    // Update the sismos
    this.theSismos = sismos;

    // Notify to re-layout
    this.notifyDataSetChanged();
  }


  /**
   * Called when RecyclerView needs a newViewHolder of the given type to represent an item.
   */
  @NotNull
  @Override
  public SismoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

    // The inflater
    final LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

    // The row of sismos
    final RowSismoBinding rowSismoBinding = RowSismoBinding.inflate(
        layoutInflater,parent,false);

    // The SismoViewHolder
    final SismoViewHolder sismoViewHolder = new SismoViewHolder(rowSismoBinding);


    return sismoViewHolder;

  }


  @Override
  public void onBindViewHolder(@NonNull SismoViewHolder holder, int position) {
    holder.bind(this.theSismos.get(position));
  }

  /**
   * Returns the total number of items in the data set held by the adapter.
   */
  @Override
  public int getItemCount() {
    return this.theSismos.size();
  }

  /**
   * Return the stable ID for the item at position.
   */
  @Override
  public long getItemId(int position) {

    //return Long.parseLong(this.theSismos.get(position).id);
    return this.theSismos.get(position).id;
  }




}
