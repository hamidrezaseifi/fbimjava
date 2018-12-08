package com.featurebim.gui.model.futurebim;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.CompanyPostalAddressEdo;

/**
 * The persistent class for the companies database table.
 *
 */
public class GuiCompanyPostalAddress {

  private Long id;

  private Long companyid;

  private String address_name;

  private String country;

  private String city;

  private String postcode;

  private String street;

  private String house_number;

  private String additional_address;

  private String comments;

  private int status;

  private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  /**
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public void setId(final Long id) {
    this.id = id;
  }

  /**
   * @return the companyid
   */
  public Long getCompanyid() {
    return companyid;
  }

  /**
   * @param companyid the companyid to set
   */
  public void setCompanyid(final Long companyid) {
    this.companyid = companyid;
  }

  /**
   * @return the comments
   */
  public String getComments() {
    return comments;
  }

  /**
   * @param comments the comments to set
   */
  public void setComments(final String comments) {
    this.comments = comments;
  }

  /**
   * @return the status
   */
  public int getStatus() {
    return status;
  }

  /**
   * @param status the status to set
   */
  public void setStatus(final int status) {
    this.status = status;
  }

  /**
   * @return the version
   */
  public int getVersion() {
    return version;
  }

  /**
   * @param version the version to set
   */
  public void setVersion(final int version) {
    this.version = version;
  }

  /**
   * @return the created
   */
  public LocalDateTime getCreated() {
    return created;
  }

  /**
   * @param created the created to set
   */
  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  /**
   * @return the updated
   */
  public LocalDateTime getUpdated() {
    return updated;
  }

  /**
   * @param updated the updated to set
   */
  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  /**
   * @return the address_name
   */
  public String getAddressName() {
    return address_name;
  }

  /**
   * @param address_name the address_name to set
   */
  public void setAddressName(final String address_name) {
    this.address_name = address_name;
  }

  /**
   * @return the country
   */
  public String getCountry() {
    return country;
  }

  /**
   * @param country the country to set
   */
  public void setCountry(final String country) {
    this.country = country;
  }

  /**
   * @return the city
   */
  public String getCity() {
    return city;
  }

  /**
   * @param city the city to set
   */
  public void setCity(final String city) {
    this.city = city;
  }

  /**
   * @return the postcode
   */
  public String getPostcode() {
    return postcode;
  }

  /**
   * @param postcode the postcode to set
   */
  public void setPostcode(final String postcode) {
    this.postcode = postcode;
  }

  /**
   * @return the street
   */
  public String getStreet() {
    return street;
  }

  /**
   * @param street the street to set
   */
  public void setStreet(final String street) {
    this.street = street;
  }

  /**
   * @return the house_number
   */
  public String getHouseNumber() {
    return house_number;
  }

  /**
   * @param house_number the house_number to set
   */
  public void setHouseNumber(final String house_number) {
    this.house_number = house_number;
  }

  /**
   * @return the additional_address
   */
  public String getAdditionalAddress() {
    return additional_address;
  }

  /**
   * @param additional_address the additional_address to set
   */
  public void setAdditionalAddress(final String additional_address) {
    this.additional_address = additional_address;
  }

  public CompanyPostalAddressEdo toEdo() {
    final CompanyPostalAddressEdo edo = new CompanyPostalAddressEdo();
    edo.setComments(comments);
    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);
    edo.setCompanyid(companyid);
    edo.setAdditionalAddress(additional_address);
    edo.setAddressName(address_name);
    edo.setCity(city);
    edo.setCountry(country);
    edo.setHouseNumber(house_number);
    edo.setPostcode(postcode);
    edo.setStreet(street);
    
    return edo;
  }
  
  public static GuiCompanyPostalAddress fromEdo(final CompanyPostalAddressEdo edo) {
    final GuiCompanyPostalAddress model = new GuiCompanyPostalAddress();
    
    model.setComments(edo.getComments());
    model.setCreated(edo.getCreated());
    model.setId(edo.getId());
    model.setStatus(edo.getStatus());
    model.setUpdated(edo.getUpdated());
    model.setVersion(edo.getVersion());
    model.setCompanyid(edo.getCompanyid());
    model.setAdditionalAddress(edo.getAdditionalAddress());
    model.setAddressName(edo.getAddressName());
    model.setCity(edo.getCity());
    model.setCountry(edo.getCountry());
    model.setHouseNumber(edo.getHouseNumber());
    model.setPostcode(edo.getPostcode());
    model.setStreet(edo.getStreet());

    return model;
  }
  
  public static List<CompanyPostalAddressEdo> toEdoList(final List<GuiCompanyPostalAddress> list) {
    
    final List<CompanyPostalAddressEdo> edoList = new ArrayList<>();
    for (final GuiCompanyPostalAddress p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiCompanyPostalAddress> fromEdoList(final List<CompanyPostalAddressEdo> edoList) {

    final List<GuiCompanyPostalAddress> list = new ArrayList<>();
    for (final CompanyPostalAddressEdo edo : edoList) {
      list.add(GuiCompanyPostalAddress.fromEdo(edo));
    }
    return list;
  }
}
