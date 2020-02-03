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
  public Integer state;
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
  public String chilean_time;
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
  public Long id;
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
   *
   * @param state       ,the state.
   * @param utcTime     ,the utc time of the quake.
   * @param localTime   ,the localTime of the quake.
   * @param chilean_time ,the chilean Time of the quake.
   * @param reference   ,the reference.
   * @param magnitude   ,the magnitude of the quake.
   * @param scale       ,the scale of the quake.
   * @param latitude    ,the latitude of the quake.
   * @param longitude   ,the longitude of the quake.
   * @param depth       ,the depth of the quake.
   * @param id          ,the id of the quake.
   * @param url         ,the url of the quake.
   * @param source      ,the source of the quake.
   */
  public Sismo(Integer state, String utcTime, String localTime, String chilean_time,
      String reference, Float magnitude, String scale, Float latitude, Float longitude,
      Float depth, Long id, String url, String source) {
    this.state = state;
    this.utcTime = utcTime;
    this.localTime = localTime;
    this.chilean_time = chilean_time;
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


  /**
   * Get the State.
   * @return The State.
   */
  public Integer getState() {
    return state;
  }

  /**
   *Get the UTC time.
   * @return UTC time.
   */
  public String getUtcTime() {
    return utcTime;
  }

  /**
   * Get the local Time.
   * @return local time.
   */
  public String getLocalTime () {
    return localTime;
  }

  /**
   * Get the Chilean time.
   * @return Chilean time.
   */
  public String getChilean_time () {
    return chilean_time;
  }

  /**
   * Get the reference.
   * @return the reference.
   */
  public String getReference() {
    return reference;
  }

  /**
   * Get the magnitude.
   * @return the magnitude.
   */
  public Float getMagnitude() {
    return magnitude;
  }

  /**
   * Get the Scale.
   * @return the scale.
   */
  public String getScale() {
    return scale;
  }

  /**
   * Get the latitude.
   * @return the latitude.
   */
  public Float getLatitude() {
    return latitude;
  }

  /**
   * Get the longitude.
   * @return the longitude.
   */
  public Float getLongitude() {
    return longitude;
  }

  /**
   * Get the Depth.
   * @return the depth.
   */
  public Float getDepth() {
    return depth;
  }

  /**
   * Get the id.
   * @return the id.
   */
  public Long getId() {
    return id;
  }

  /**
   * Get the url.
   * @return the url.
   */
  public String getUrl() {
    return url;
  }

  /**
   * Get the Source.
   * @return the source.
   */
  public String getSource() {
    return source;
  }
}
