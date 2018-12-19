package com.futurebim.core.model;

import java.time.LocalDateTime;

/**
 * The persistent class for the addresses database table.
 *
 */
public class Address {

  private Long id;

  private String addressName;

  private String city;

  private String comments;

  private String country;

  private LocalDateTime created;

  private String houseNumber;

  private String postcode;

  private String street;

  private String street2;

  private LocalDateTime updated;

  private int version;

  public Address() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getAddressName() {
    return this.addressName;
  }

  public void setAddressName(final String addressName) {
    this.addressName = addressName;
  }

  public String getCity() {
    return this.city;
  }

  public void setCity(final String city) {
    this.city = city;
  }

  public String getComments() {
    return this.comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public String getCountry() {
    return this.country;
  }

  public void setCountry(final String country) {
    this.country = country;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getHouseNumber() {
    return this.houseNumber;
  }

  public void setHouseNumber(final String houseNumber) {
    this.houseNumber = houseNumber;
  }

  public String getPostcode() {
    return this.postcode;
  }

  public void setPostcode(final String postcode) {
    this.postcode = postcode;
  }

  public String getStreet() {
    return this.street;
  }

  public void setStreet(final String street) {
    this.street = street;
  }

  public String getStreet2() {
    return this.street2;
  }

  public void setStreet2(final String street2) {
    this.street2 = street2;
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
