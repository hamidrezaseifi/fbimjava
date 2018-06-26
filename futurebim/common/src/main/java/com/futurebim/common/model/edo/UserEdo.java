package com.futurebim.common.model.edo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.common.model.enums.EStatus;

/**
 * The persistent class for the users database table.
 *
 */
public class UserEdo {

  private Long id;

  private Long companyid;

  private LocalDate birthday;

  private LocalDateTime created;

  private String email;

  private String firstname;

  private short gender;

  private String hashPassword;

  private String lastname;

  private String nameTag;

  private EStatus status;

  private LocalDateTime updated;

  private String username;

  private int version;

  private CompanyReferenceEdo company;

  private List<UserProjectAccessReferenceEdo> userProjectAccesses;

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

  @JsonIgnore
  public CompanyReferenceEdo getCompany() {
    return this.company;
  }

  public void setCompany(final CompanyReferenceEdo company) {
    this.company = company;
  }

  public List<UserProjectAccessReferenceEdo> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccessReferenceEdo> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccessReferenceEdo addUserProjectAccess(final UserProjectAccessReferenceEdo userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);
    userProjectAccess.setUserid(this.id);

    return userProjectAccess;
  }

  public UserProjectAccessReferenceEdo removeUserProjectAccess(final UserProjectAccessReferenceEdo userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);
    userProjectAccess.setUserid(0L);

    return userProjectAccess;
  }

}
