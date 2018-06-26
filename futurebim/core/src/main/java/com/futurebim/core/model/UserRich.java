package com.futurebim.core.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the users database table.
 *
 */
@Entity
@Table(name = "users")
public class UserRich extends User {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyid", insertable = false, updatable = false)
  private Company company;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.userid", targetEntity = UserProjectAccess.class)
  private List<UserProjectAccess> userProjectAccesses;

  public UserRich() {
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
