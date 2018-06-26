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
public class User extends UserReference {

  private static final long serialVersionUID = 1L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "companyid", insertable = false, updatable = false)
  private CompanyReference company;

  @OneToMany(fetch = FetchType.EAGER, mappedBy = "id.userid", targetEntity = UserProjectAccessReference.class)
  private List<UserProjectAccessReference> userProjectAccesses;

  public User() {
  }

  public CompanyReference getCompany() {
    return this.company;
  }

  public void setCompany(final CompanyReference company) {
    this.company = company;
  }

  public List<UserProjectAccessReference> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccessReference> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccessReference addUserProjectAccess(final UserProjectAccessReference userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);
    userProjectAccess.setUser(this.id);

    return userProjectAccess;
  }

  public UserProjectAccessReference removeUserProjectAccess(final UserProjectAccessReference userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);
    userProjectAccess.setUser(null);

    return userProjectAccess;
  }

}
