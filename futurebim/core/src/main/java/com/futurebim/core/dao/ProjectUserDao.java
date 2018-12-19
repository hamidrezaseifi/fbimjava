package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.ProjectUser;

public interface ProjectUserDao {
  
  public ProjectUser add(final ProjectUser projectUser) throws StorageException;
  
  public boolean remove(final ProjectUser projectUser) throws StorageException;
  
  public List<ProjectUser> listByProject(final Long projectId) throws StorageException;
  
  public List<ProjectUser> listByUser(final Long userId) throws StorageException;
  
}
