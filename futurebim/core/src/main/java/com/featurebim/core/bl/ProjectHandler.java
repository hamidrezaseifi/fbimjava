package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.core.dao.ProjectDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

@Service
public class ProjectHandler implements IProjectHandler {

  private ProjectDao projectDao;

  @Autowired(required = true)
  public void setProjectService(final ProjectDao projectDao) {
    this.projectDao = projectDao;
  }

  @Override
  public Project getById(final Long id) throws StorageException {
    return projectDao.getById(id);
  }

  @Override
  public List<Project> listProjects(final Long companyId) throws StorageException {
    return projectDao.listProjects(companyId);
  }

  @Override
  public Project addProject(final Project project) throws StorageException {
    return projectDao.addProject(project);
  }

  @Override
  public Project updateProject(final Project project) throws StorageException {
    return projectDao.updateProject(project);
  }

}
