package com.futurebim.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.futurebim.common.model.enums.EStatus;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the users database table.
 *
 */
@Entity
@Table(name = "users")
public class UserRich extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @Column(name = "id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private Long companyid;

  private LocalDate birthday;

  private LocalDateTime created;

  private String email;

  private String firstname;

  private short gender;

  @Column(name = "hash_password")
  private String hashPassword;

  private String lastname;

  @Column(name = "name_tag")
  private String nameTag;

  private EStatus status;

  private LocalDateTime updated;

  private String username;

  private int version;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyid", insertable = false, updatable = false)
  private Company company;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.userid", targetEntity = UserProjectAccess.class)
  private List<UserProjectAccess> userProjectAccesses;

  public UserRich() {
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

  public Company getCompany() {
    return this.company;
  }

  public void setCompany(final Company company) {
    this.company = company;
  }

  public List<UserProjectAccess> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccess> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccess addUserProjectAccess(final UserProjectAccess userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);

    return userProjectAccess;
  }

  public UserProjectAccess removeUserProjectAccess(final UserProjectAccess userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);

    return userProjectAccess;
  }

}
