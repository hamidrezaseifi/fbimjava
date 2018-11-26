package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.core.dao.ProjectDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

@Service
public class ProjectHandler {

  private ProjectDao projectDao;

  @Autowired(required = true)
  public void setCompanyService(final ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  public Project getById(final Long id) throws StorageException {
    return projectDao.getById(id);
  }

  public List<Project> listProjects(final Long companyId) throws StorageException {
    return projectDao.listProjects(companyId);
  }

}
