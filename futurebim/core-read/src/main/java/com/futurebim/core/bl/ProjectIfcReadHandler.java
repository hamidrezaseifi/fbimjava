package com.futurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.core.dao.ifc.ProjectIfcDao;
import com.futurebim.core.model.ifc.ProjectIfc;

@Service
public class ProjectIfcReadHandler {

  private ProjectIfcDao projectIcfDao;

  @Autowired(required = true)
  public void setCompanyService(final ProjectIfcDao projectIcfDao) {
    this.projectIcfDao = projectIcfDao;
  }

  public ProjectIfc getById(final Long id) {
    return projectIcfDao.getById(id);
  }

  public List<ProjectIfc> listProjectIfcs(final Long projectId) {
    return projectIcfDao.listProjectIfcs(projectId);
  }

}
