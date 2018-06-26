package com.futurebim.core.model.helper;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.common.model.edo.CompanyReferenceEdo;
import com.futurebim.common.model.edo.ProjectEdo;
import com.futurebim.common.model.edo.ProjectReferenceEdo;
import com.futurebim.common.model.edo.UserEdo;
import com.futurebim.common.model.edo.UserReferenceEdo;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.CompanyReference;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.ProjectReference;
import com.futurebim.core.model.User;
import com.futurebim.core.model.UserReference;

public class ModelEdoMapper {

  public static Company getCompanyFromEdo(final CompanyEdo edo) {

    final Company c = new Company();

    c.setId(edo.getId());
    c.setCompanyName(edo.getCompanyName());
    c.setComments(edo.getComments());
    c.setCreated(edo.getCreated());
    c.setProjects(getProjectReferenceListFromEdo(edo.getProjects()));
    c.setStatus(edo.getStatus().getDbId());
    c.setUpdated(edo.getUpdated());
    c.setUsers(getUserReferenceListFromEdo(edo.getUsers()));
    c.setVersion(edo.getVersion());

    return c;
  }

  public static List<Company> getCompanyListFromEdo(final List<CompanyEdo> edoList) {

    final List<Company> list = new ArrayList<>();

    for (final CompanyEdo edo : edoList) {
      list.add(getCompanyFromEdo(edo));
    }

    return list;
  }

  public static CompanyReference getCompanyReferenceFromEdo(final CompanyReferenceEdo edo) {

    final CompanyReference c = new CompanyReference();

    c.setId(edo.getId());
    c.setCompanyName(edo.getCompanyName());
    c.setComments(edo.getComments());
    c.setCreated(edo.getCreated());
    c.setStatus(edo.getStatus().getDbId());
    c.setUpdated(edo.getUpdated());
    c.setVersion(edo.getVersion());

    return c;
  }

  public static Project getProjectFromEdo(final ProjectEdo edo) {

    final Project p = new Project();

    p.setCompanyid(edo.getCompanyid());
    p.setCompanyBean(null);
    p.setCreated(edo.getCreated());
    p.setDeatline(edo.getDeatline());
    p.setId(edo.getId());
    p.setProjectName(edo.getProjectName());
    p.setStartDate(edo.getStartDate());
    p.setStatus(edo.getStatus().getDbId());
    p.setUpdated(edo.getUpdated());
    p.setUserProjectAccesses(new ArrayList<>());
    p.setVersion(edo.getVersion());

    return p;
  }

  public static List<Project> getProjectListFromEdo(final List<ProjectEdo> edoList) {

    final List<Project> list = new ArrayList<>();

    for (final ProjectEdo edo : edoList) {
      list.add(getProjectFromEdo(edo));
    }

    return list;
  }

  public static ProjectReference getProjectReferenceFromEdo(final ProjectReferenceEdo edo) {

    final ProjectReference p = new ProjectReference();

    p.setCompanyid(edo.getCompanyid());
    p.setCreated(edo.getCreated());
    p.setDeatline(edo.getDeatline());
    p.setId(edo.getId());
    p.setProjectName(edo.getProjectName());
    p.setStartDate(edo.getStartDate());
    p.setStatus(edo.getStatus().getDbId());
    p.setUpdated(edo.getUpdated());
    p.setVersion(edo.getVersion());

    return p;
  }

  public static List<ProjectReference> getProjectReferenceListFromEdo(final List<ProjectReferenceEdo> edoList) {

    final List<ProjectReference> list = new ArrayList<>();

    for (final ProjectReferenceEdo edo : edoList) {
      list.add(getProjectReferenceFromEdo(edo));
    }

    return list;
  }

  public static UserReference getUserReferenceFromEdo(final UserReferenceEdo edo) {

    final UserReference u = new UserReference();

    u.setCompanyid(edo.getCompanyid());
    u.setCreated(edo.getCreated());
    u.setEmail(edo.getEmail());
    u.setFirstname(edo.getFirstname());
    u.setGender(edo.getGender());
    u.setHashPassword(edo.getHashPassword());
    u.setId(edo.getId());
    u.setLastname(edo.getLastname());
    u.setNameTag(edo.getNameTag());
    u.setStatus(edo.getStatus().getDbId());
    u.setUsername(edo.getUsername());
    u.setUpdated(edo.getUpdated());
    u.setVersion(edo.getVersion());

    return u;
  }

  public static List<UserReference> getUserReferenceListFromEdo(final List<UserReferenceEdo> edoList) {

    final List<UserReference> list = new ArrayList<>();

    for (final UserReferenceEdo edo : edoList) {
      list.add(getUserReferenceFromEdo(edo));
    }

    return list;
  }

  public static User getUserFromEdo(final UserEdo edo) {

    final UserReference u = getUserReferenceFromEdo(edo);

    final User u1 = (User) u;
    u1.setCompany(getCompanyReferenceFromEdo(edo.getCompany()));
    u1.setUserProjectAccesses(edo.getUserProjectAccesses());

    return u1;
  }

  public static List<User> getUserListFromEdo(final List<UserEdo> edoList) {

    final List<User> list = new ArrayList<>();

    for (final UserEdo edo : edoList) {
      list.add(getUserFromEdo(edo));
    }

    return list;
  }

}
