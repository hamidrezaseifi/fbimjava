package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.ProjectUser;

public interface IProjectUserHandler {
  
  public ProjectUser save(final ProjectUser projectUser) throws StorageException;

  public boolean remove(final ProjectUser projectUser) throws StorageException;

  public List<ProjectUser> listByProject(final Long projectId) throws StorageException;

  public List<ProjectUser> listByUser(final Long userId) throws StorageException;

}
