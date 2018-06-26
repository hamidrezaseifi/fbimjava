package com.futurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the users database table.
 *
 */
public class UserEdo {

  protected Long id;

  protected Long companyid;

  protected LocalDate birthday;

  protected LocalDateTime created;

  protected String email;

  protected String firstname;

  protected short gender;

  protected String hashPassword;

  protected String lastname;

  protected String nameTag;

  protected EStatus status;

  protected LocalDateTime updated;

  protected String username;

  protected int version;

  public UserEdo() {
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

  public LocalDate getBirthday() {
    return this.birthday;
  }

  public void setBirthday(final LocalDate birthday) {
    this.birthday = birthday;
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

  public EStatus getStatus() {
    return this.status;
  }

  public void setStatus(final Long status) {
    this.status = EStatus.ofId(status);
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

}
