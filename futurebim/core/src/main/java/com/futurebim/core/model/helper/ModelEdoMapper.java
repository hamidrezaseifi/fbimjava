package com.futurebim.core.model.helper;

import java.util.ArrayList;
import java.util.List;

import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.common.model.edo.ProjectEdo;
import com.futurebim.common.model.enums.base.UnknownEnumValueException;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.Project;

public class ModelEdoMapper {

  public static Company getCompanyFromEdo(final CompanyEdo edo){
    
    Company c = new Company();
    
    c.setId(edo.getId());
    c.setCompanyName(edo.getCompanyName());
    c.setComments(edo.getComments());
    c.setCreated(edo.getCreated());
    c.setProjects(edo.getProjects());
    c.setStatus(edo.getStatus().getDbId());
    c.setUpdated(edo.getUpdated());
    c.setUsers(edo.getUsers());
    c.setVersion(edo.getVersion());
    
    return c;
  }
  
  public static List<Company> getCompanyListFromEdo(final List<CompanyEdo> edoList){
    
    List<Company> list = new ArrayList<>();
    
    for(CompanyEdo edo:edoList){
      list.add(getCompanyFromEdo(edo));
    }
    
    return list;
  }
  
  public static Project getProjectFromEdo(final ProjectEdo edo) throws UnknownEnumValueException{
    
    Project p = new Project();
    
    p.setCompanyid(edo.getCompanyid());
    p.setCompanyBean(null);
    p.setCreated(edo.getCreated());
    p.setDeatline(edo.getDeatline());
    p.setId(edo.getId());
    p.setProjectName(edo.getProjectName());
    p.setStartDate(edo.getStartDate());
    p.setStatus(edo.getStatus().getDbId());
    p.setUpdated(edo.getUpdated());
    p.setUserProjectAccesses(null);
    p.setVersion(edo.getVersion());
    
    return p;
  }
  
  public static List<Project> getProjectListFromEdo(final List<ProjectEdo> edoList) throws UnknownEnumValueException{
    
    List<Project> list = new ArrayList<>();
    
    for(ProjectEdo edo:edoList){
      list.add(getProjectFromEdo(edo));
    }
    
    return list;
  }
  

}
