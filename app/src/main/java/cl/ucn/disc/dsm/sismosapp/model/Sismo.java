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

public class Sismo {

  /**
   * The State.
   */
  private Integer state;
  /**
   * The UTC Time.
   */
  public String utcTime;
  /**
   * The Local Time.
   */
  public String localTime;
  /**
   * Chilean Time.
   */
  public String chileanTime;
  /**
   * The Reference.
   */
  public String reference;
  /**
   * The Magnitude.
   */
  public Float magnitude;
  /**
   * The Scale.
   */
  public String scale;
  /**
   * The Latitude.
   */
  public Float latitude;
  /**
   * The longitude.
   */
  public Float longitude;
  /**
   * The Depth.
   */
  public Float depth;
  /**
   * The id.
   */
  public String id;
  /**
   * The url.
   */
  public String url;
  /**
   * The source.
   */
  public String source;


  /**
   * The constructor.
   * @param state
   * @param utcTime
   * @param localTime
   * @param chileanTime
   * @param reference
   * @param magnitude
   * @param scale
   * @param latitude
   * @param longitude
   * @param depth
   * @param id
   * @param url
   * @param source
   */
  public Sismo (Integer state, String utcTime, String localTime, String chileanTime,
      String reference, Float magnitude, String scale, Float latitude, Float longitude,
      Float depth, String id, String url, String source) {
    this.state = state;
    this.utcTime = utcTime;
    this.localTime = localTime;
    this.chileanTime = chileanTime;
    this.reference = reference;
    this.magnitude = magnitude;
    this.scale = scale;
    this.latitude = latitude;
    this.longitude = longitude;
    this.depth = depth;
    this.id = id;
    this.url = url;
    this.source = source;
  }

  public Integer getState ( ) {
    return state;
  }

  public String getUtcTime ( ) {
    return utcTime;
  }

  public String getLocalTime ( ) {
    return localTime;
  }

  public String getChileanTime ( ) {
    return chileanTime;
  }

  public String getReference ( ) {
    return reference;
  }

  public Float getMagnitude ( ) {
    return magnitude;
  }

  public String getScale ( ) {
    return scale;
  }

  public Float getLatitude ( ) {
    return latitude;
  }

  public Float getLongitude ( ) {
    return longitude;
  }

  public Float getDepth ( ) {
    return depth;
  }

  public String getId ( ) {
    return id;
  }

  public String getUrl ( ) {
    return url;
  }

  public String getSource ( ) {
    return source;
  }
}
