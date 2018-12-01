package com.featurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.featurebim.common.rest.json.JsonConstants;

/**
 * The persistent class for the users database table.
 *
 */
public class UserFullEdo {

  private Long id;

  private Long companyid;

  private String username;

  private String hashPassword;

  private short gender;

  private String lastname;

  private String firstname;

  private String nameTag;

  @JsonFormat(pattern = JsonConstants.DATE_FORMAT_ISO)
  private LocalDate birthdate;

  private String email;

  private int status;

  private int version;

  private final List<Integer> roles = new ArrayList<>();

  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime created;

  @JsonFormat(pattern = JsonConstants.DATETIME_FORMAT_ISO)
  private LocalDateTime updated;

  public UserFullEdo() {
  }

  public Long getId() {
    return this.id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public Long getCompanyid() {
    return this.companyid;
  }

  public void setCompanyid(final Long company) {
    this.companyid = company;
  }

  public LocalDate getBirthdate() {
    return this.birthdate;
  }

  public void setBirthdate(final LocalDate birthdate) {
    this.birthdate = birthdate;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(final String email) {
    this.email = email;
  }

  public String getFirstname() {
    return this.firstname;
  }

  public void setFirstname(final String firstname) {
    this.firstname = firstname;
  }

  public short getGender() {
    return this.gender;
  }

  public void setGender(final short gender) {
    this.gender = gender;
  }

  public String getHashPassword() {
    return this.hashPassword;
  }

  public void setHashPassword(final String hashPassword) {
    this.hashPassword = hashPassword;
  }

  public String getLastname() {
    return this.lastname;
  }

  public void setLastname(final String lastname) {
    this.lastname = lastname;
  }

  public String getNameTag() {
    return this.nameTag;
  }

  public void setNameTag(final String nameTag) {
    this.nameTag = nameTag;
  }

  public int getStatus() {
    return this.status;
  }

  public void setStatus(final int status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public String getUsername() {
    return this.username;
  }

  public void setUsername(final String username) {
    this.username = username;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public List<Integer> getRoles() {
    return roles;
  }

  public void setRoles(final List<Integer> roles) {
    if (roles != null) {
      this.roles.addAll(roles);
    }
  }

  public void addRole(final Integer role) {
    this.roles.add(role);
  }

}
