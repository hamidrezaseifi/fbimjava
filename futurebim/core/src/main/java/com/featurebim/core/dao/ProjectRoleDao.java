package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.ProjectRole;

public interface ProjectRoleDao {
  
  public ProjectRole addProjectRole(ProjectRole role) throws StorageException;
  
  public ProjectRole updateProjectRole(ProjectRole role) throws StorageException;
  
  public boolean removeProjectRole(Long id) throws StorageException;
  
  public ProjectRole getById(Long id) throws StorageException;
  
  public List<ProjectRole> listProjectRoles() throws StorageException;
  
  public List<ProjectRole> listCompanyProjectRoles(final Long companyId) throws StorageException;
  
}
