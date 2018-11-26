package com.featurebim.core.model.helper;

import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.CompanyEdo;
import com.featurebim.common.model.edo.ProjectEdo;
import com.featurebim.common.model.edo.UserEdo;
import com.featurebim.core.model.Company;
import com.featurebim.core.model.Project;
import com.featurebim.core.model.User;

public class ModelEdoMapper {

  public static Company getCompanyRichFromEdo(final CompanyEdo edo) {

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

  public static List<Company> getCompanyRichListFromEdo(final List<CompanyEdo> edoList) {

    final List<Company> list = new ArrayList<>();

    for (final CompanyEdo edo : edoList) {
      list.add(getCompanyRichFromEdo(edo));
    }

    return list;
  }

  public static Company getCompanyFromEdo(final CompanyEdo edo) {

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

  public static List<Company> getCompanyListFromEdo(final List<CompanyEdo> edoList) {

    final List<Company> list = new ArrayList<>();

    for (final CompanyEdo edo : edoList) {
      list.add(getCompanyFromEdo(edo));
    }

    return list;
  }

  public static CompanyEdo getEdoFromCompany(final Company c) {

    final CompanyEdo edo = new CompanyEdo();

    edo.setId(c.getId());
    edo.setCompanyName(c.getCompanyName());
    edo.setComments(c.getComments());
    edo.setCreated(c.getCreated());
    edo.setStatus(c.getStatus().getDbId());
    edo.setUpdated(c.getUpdated());
    edo.setVersion(c.getVersion());

    return edo;
  }

  public static List<CompanyEdo> getEdoListFromCompany(final List<Company> list) {

    final List<CompanyEdo> edoList = new ArrayList<>();

    for (final Company c : list) {
      edoList.add(getEdoFromCompany(c));
    }

    return edoList;
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

  public static Project getProjectFromEdo(final ProjectEdo edo) {

    final Project p = new Project();

    p.setCompanyid(edo.getCompanyid());
    p.setCreated(edo.getCreated());
    p.setDeadline(edo.getDeadline());
    p.setId(edo.getId());
    p.setProjectName(edo.getProjectName());
    p.setStartDate(edo.getStartDate());
    p.setStatus(edo.getStatus().getDbId());
    p.setUpdated(edo.getUpdated());
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

  public static Project getProjectReferenceFromEdo(final ProjectEdo edo) {

    final Project p = new Project();

    p.setCompanyid(edo.getCompanyid());
    p.setCreated(edo.getCreated());
    p.setDeadline(edo.getDeadline());
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

}
