package com.futurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.core.dao.ProjectDao;
import com.futurebim.core.model.ProjectRich;

@Service
public class ProjectHandler {

  private ProjectDao projectDao;

  @Autowired(required = true)
  public void setCompanyService(final ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  public ProjectRich getById(final Long id) {
    return projectDao.getById(id);
  }

  public List<ProjectRich> listProjects(final Long companyId) {
    return projectDao.listProjects(companyId);
  }

}
