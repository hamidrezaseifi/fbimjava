package com.featurebim.core.model;

import java.time.LocalDateTime;

/**
 * The persistent class for the telephonesnumbers database table.
 *
 */
public class Telephonesnumber {

  private Long id;

  private String cityCode;

  private String comments;

  private String countryCode;

  private LocalDateTime created;

  private String subscriber;

  private String telephoneName;

  private LocalDateTime updated;

  private int version;

  public Telephonesnumber() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getCityCode() {
    return this.cityCode;
  }

  public void setCityCode(final String cityCode) {
    this.cityCode = cityCode;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public String getCountryCode() {
    return this.countryCode;
  }

  public void setCountryCode(final String countryCode) {
    this.countryCode = countryCode;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getSubscriber() {
    return this.subscriber;
  }

  public void setSubscriber(final String subscriber) {
    this.subscriber = subscriber;
  }

  public String getTelephoneName() {
    return this.telephoneName;
  }

  public void setTelephoneName(final String telephoneName) {
    this.telephoneName = telephoneName;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

}
