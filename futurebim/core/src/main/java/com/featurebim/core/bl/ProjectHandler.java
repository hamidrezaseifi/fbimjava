package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.common.exceptions.EExceptionType;
import com.featurebim.common.exceptions.FBCustomizedException;
import com.featurebim.common.model.enums.EModule;
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
  public Project saveProject(final Project project) throws StorageException {
    
    if (project.isNew()) {
      project.setVersion(1);
      return projectDao.addProject(project);
    }
    
    checkRecordVersion(project.getId(), project.getVersion());
    project.setVersion(project.getVersion() + 1);
    return projectDao.updateProject(project);
  }
  
  @Override
  public boolean deleteProject(final Project project) throws StorageException {
    checkRecordVersion(project.getId(), project.getVersion());

    return projectDao.deleteProject(project.getId());
  }

  private boolean checkRecordVersion(final long id, final int version) throws StorageException {
    final Project exists = projectDao.getById(id);
    if (exists.getVersion() > version) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }
    
    return true;
  }
  
}
