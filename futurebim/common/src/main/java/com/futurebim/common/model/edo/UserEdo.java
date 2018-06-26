package com.futurebim.common.model.edo;

import java.util.List;

/**
 * The persistent class for the users database table.
 *
 */
public class UserEdo extends UserReferenceEdo {

  private CompanyReferenceEdo company;

  private List<UserProjectAccessReferenceEdo> userProjectAccesses;

  public UserEdo() {
  }

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
