package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;
import com.featurebim.core.model.ProjectRole;

public interface IProjectHandler {
  
  public Project getById(final Long id) throws StorageException;
  
  public List<Project> listProjects(final Long companyId) throws StorageException;
  
  public Project saveProject(final Project project) throws StorageException;
  
  boolean deleteProject(final Project project) throws StorageException;
  
  public List<ProjectRole> listProjectRoles(final Long companyId) throws StorageException;
  
  public ProjectRole saveProjectRole(final ProjectRole role) throws StorageException;
  
}
