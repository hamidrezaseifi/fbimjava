package com.futurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.common.exceptions.EExceptionType;
import com.futurebim.common.exceptions.FBCustomizedException;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.core.bl.IProjectHandler;
import com.futurebim.core.dao.ProjectDao;
import com.futurebim.core.dao.ProjectRoleDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.ProjectRole;

@Service
public class ProjectHandler implements IProjectHandler {

  private ProjectDao projectDao;

  private ProjectRoleDao projectRoleDao;

  @Autowired(required = true)
  public void setProjectService(final ProjectDao projectDao, final ProjectRoleDao projectRoleDao) {
    this.projectDao = projectDao;
    this.projectRoleDao = projectRoleDao;
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

  @Override
  public List<ProjectRole> listProjectRoles(final Long companyId) throws StorageException {

    final List<ProjectRole> list = projectRoleDao.listCompanyProjectRoles(0L);
    list.addAll(projectRoleDao.listCompanyProjectRoles(companyId));

    return list;
    
  }

  @Override
  public ProjectRole saveProjectRole(final ProjectRole role) throws StorageException {
    if (role.isNew()) {
      role.setVersion(1);
      return projectRoleDao.addProjectRole(role);
    }
    checkRecordRoleVersion(role);
    role.setVersion(role.getVersion() + 1);
    return projectRoleDao.updateProjectRole(role);
  }
  
  private boolean checkRecordRoleVersion(final ProjectRole role) throws StorageException {
    final ProjectRole exists = projectRoleDao.getById(role.getId());
    if (exists.getVersion() > role.getVersion()) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }
    
    return true;
  }
}
