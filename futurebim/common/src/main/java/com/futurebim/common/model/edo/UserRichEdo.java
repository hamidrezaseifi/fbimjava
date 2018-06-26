package com.futurebim.common.model.edo;

import java.util.List;

/**
 * The persistent class for the users database table.
 *
 */
public class UserRichEdo extends UserEdo {

  private CompanyEdo company;

  private List<UserProjectAccessEdo> userProjectAccesses;

  public UserRichEdo() {
  }

  public CompanyEdo getCompany() {
    return this.company;
  }

  public void setCompany(final CompanyEdo company) {
    this.company = company;
  }

  public List<UserProjectAccessEdo> getUserProjectAccesses() {
    return this.userProjectAccesses;
  }

  public void setUserProjectAccesses(final List<UserProjectAccessEdo> userProjectAccesses) {
    this.userProjectAccesses = userProjectAccesses;
  }

  public UserProjectAccessEdo addUserProjectAccess(final UserProjectAccessEdo userProjectAccess) {
    getUserProjectAccesses().add(userProjectAccess);
    userProjectAccess.setUserid(this.id);

    return userProjectAccess;
  }

  public UserProjectAccessEdo removeUserProjectAccess(final UserProjectAccessEdo userProjectAccess) {
    getUserProjectAccesses().remove(userProjectAccess);
    userProjectAccess.setUserid(0L);

    return userProjectAccess;
  }

}
