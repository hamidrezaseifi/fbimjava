package com.futurebim.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.UserFullEdo;

/**
 * The persistent class for the users database table.
 *
 */
public class UserFull {

  private Long id;

  private Long companyid;

  private String username;

  private String hashPassword;

  private short gender;

  private String lastname;

  private String firstname;

  private String nameTag;

  private LocalDate birthdate;

  private String email;

  private int status;

  private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  private final List<Integer> roles = new ArrayList<>();

  public UserFull() {
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

  public boolean isNew() {
    return id == null || id <= 0;
  }

  public UserFullEdo toEdo() {
    final UserFullEdo edo = new UserFullEdo();
    edo.setBirthdate(birthdate);
    edo.setCompanyid(companyid);
    edo.setEmail(email);
    edo.setFirstname(firstname);
    edo.setGender(gender);
    edo.setLastname(lastname);
    edo.setNameTag(nameTag);
    edo.setUsername(username);

    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status);
    edo.setUpdated(updated);
    edo.setVersion(version);
    edo.setRoles(getRoles());

    return edo;
  }

  public static UserFull fromEdo(final UserFullEdo edo) {
    final UserFull user = new UserFull();

    user.setBirthdate(edo.getBirthdate());
    user.setCompanyid(edo.getCompanyid());
    user.setEmail(edo.getEmail());
    user.setFirstname(edo.getFirstname());
    user.setGender(edo.getGender());
    user.setLastname(edo.getLastname());
    user.setNameTag(edo.getNameTag());
    user.setUsername(edo.getUsername());

    user.setCreated(edo.getCreated());
    user.setId(edo.getId());
    user.setStatus(edo.getStatus());
    user.setUpdated(edo.getUpdated());
    user.setVersion(edo.getVersion());
    user.setRoles(edo.getRoles());

    return user;
  }

  public static List<UserFullEdo> toEdoList(final List<UserFull> list) {

    final List<UserFullEdo> edoList = new ArrayList<>();
    for (final UserFull p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }

  public static List<UserFull> fromEdoList(final List<UserFullEdo> edoList) {

    final List<UserFull> list = new ArrayList<>();
    for (final UserFullEdo edo : edoList) {
      list.add(UserFull.fromEdo(edo));
    }
    return list;
  }
}
