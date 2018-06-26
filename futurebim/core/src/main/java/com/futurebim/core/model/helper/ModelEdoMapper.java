package com.futurebim.core.model.helper;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.CompanyRichEdo;
import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.common.model.edo.ProjectRichEdo;
import com.futurebim.common.model.edo.ProjectEdo;
import com.futurebim.common.model.edo.UserRichEdo;
import com.futurebim.common.model.edo.UserEdo;
import com.futurebim.core.model.CompanyRich;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.ProjectRich;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.UserRich;
import com.futurebim.core.model.User;

public class ModelEdoMapper {

  public static CompanyRich getCompanyFromEdo(final CompanyRichEdo edo) {

    final CompanyRich c = new CompanyRich();

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

  public static List<CompanyRich> getCompanyListFromEdo(final List<CompanyRichEdo> edoList) {

    final List<CompanyRich> list = new ArrayList<>();

    for (final CompanyRichEdo edo : edoList) {
      list.add(getCompanyFromEdo(edo));
    }

    return list;
  }

  public static Company getCompanyReferenceFromEdo(final CompanyEdo edo) {

    final Company c = new Company();

    c.setId(edo.getId());
    c.setCompanyName(edo.getCompanyName());
    c.setComments(edo.getComments());
    c.setCreated(edo.getCreated());
    c.setStatus(edo.getStatus().getDbId());
    c.setUpdated(edo.getUpdated());
    c.setVersion(edo.getVersion());

    return c;
  }

  public static ProjectRich getProjectFromEdo(final ProjectRichEdo edo) {

    final ProjectRich p = new ProjectRich();

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

  public static List<ProjectRich> getProjectListFromEdo(final List<ProjectRichEdo> edoList) {

    final List<ProjectRich> list = new ArrayList<>();

    for (final ProjectRichEdo edo : edoList) {
      list.add(getProjectFromEdo(edo));
    }

    return list;
  }

  public static Project getProjectReferenceFromEdo(final ProjectEdo edo) {

    final Project p = new Project();

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

  public static List<Project> getProjectReferenceListFromEdo(final List<ProjectEdo> edoList) {

    final List<Project> list = new ArrayList<>();

    for (final ProjectEdo edo : edoList) {
      list.add(getProjectReferenceFromEdo(edo));
    }

    return list;
  }

  public static User getUserReferenceFromEdo(final UserEdo edo) {

    final User u = new User();

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

  public static List<User> getUserReferenceListFromEdo(final List<UserEdo> edoList) {

    final List<User> list = new ArrayList<>();

    for (final UserEdo edo : edoList) {
      list.add(getUserReferenceFromEdo(edo));
    }

    return list;
  }

  public static UserRich getUserFromEdo(final UserRichEdo edo) {

    final User u = getUserReferenceFromEdo(edo);

    final UserRich u1 = (UserRich) u;
    u1.setCompany(getCompanyReferenceFromEdo(edo.getCompany()));
    u1.setUserProjectAccesses(edo.getUserProjectAccesses());

    return u1;
  }

  public static List<UserRich> getUserListFromEdo(final List<UserRichEdo> edoList) {

    final List<UserRich> list = new ArrayList<>();

    for (final UserRichEdo edo : edoList) {
      list.add(getUserFromEdo(edo));
    }

    return list;
  }

}
