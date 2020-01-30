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

package cl.ucn.disc.dsm.sismosapp.model;

import java.util.List;

public class Data {

  public String request;
  public String submitted;
  public List<String> database = null;
  public String version;
  public String user;
  public String err;
  public List<String> select = null;
  public String country;
  public Integer limit;
  public Integer minmagnitude;
  public String status;

  public Data (String request, String submitted, List<String> database, String version,
      String user, String err, List<String> select, String country, Integer limit,
      Integer minmagnitude, String status) {
    this.request = request;
    this.submitted = submitted;
    this.database = database;
    this.version = version;
    this.user = user;
    this.err = err;
    this.select = select;
    this.country = country;
    this.limit = limit;
    this.minmagnitude = minmagnitude;
    this.status = status;
  }


  public String getRequest ( ) {
    return request;
  }

  public String getSubmitted ( ) {
    return submitted;
  }

  public List<String> getDatabase ( ) {
    return database;
  }

  public String getVersion ( ) {
    return version;
  }

  public String getUser ( ) {
    return user;
  }

  public String getErr ( ) {
    return err;
  }

  public List<String> getSelect ( ) {
    return select;
  }

  public String getCountry ( ) {
    return country;
  }

  public Integer getLimit ( ) {
    return limit;
  }

  public Integer getMinmagnitude ( ) {
    return minmagnitude;
  }

  public String getStatus ( ) {
    return status;
  }
}
