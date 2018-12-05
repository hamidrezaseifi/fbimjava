package com.featurebim.gui.model.futurebim;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.UserEdo;

/**
 * The persistent class for the users database table.
 *
 */
public class GuiUser {
  
  private Long id;
  
  private Long companyid;
  
  private String username;
  
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
  
  public GuiUser() {
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
  
  public UserEdo toEdo() {
    final UserEdo edo = new UserEdo();
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
    
    return edo;
  }
  
  public GuiUserFull toUserFull() {
    final GuiUserFull userFull = new GuiUserFull();
    userFull.setBirthdate(birthdate);
    userFull.setCompanyid(companyid);
    userFull.setEmail(email);
    userFull.setFirstname(firstname);
    userFull.setGender(gender);
    userFull.setLastname(lastname);
    userFull.setNameTag(nameTag);
    userFull.setUsername(username);
    userFull.setCreated(created);
    userFull.setId(id);
    userFull.setStatus(status);
    userFull.setUpdated(updated);
    userFull.setVersion(version);
    
    userFull.setRoles(new ArrayList<>());
    return userFull;
  }
  
  public static GuiUser fromEdo(final UserEdo edo) {
    if (edo == null) {
      return null;
    }
    
    final GuiUser user = new GuiUser();
    
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
    
    return user;
  }
  
  public static List<UserEdo> toEdoList(final List<GuiUser> list) {
    
    final List<UserEdo> edoList = new ArrayList<>();
    for (final GuiUser p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
  
  public static List<GuiUser> fromEdoList(final List<UserEdo> edoList) {
    
    final List<GuiUser> list = new ArrayList<>();
    for (final UserEdo edo : edoList) {
      list.add(GuiUser.fromEdo(edo));
    }
    return list;
  }
}
