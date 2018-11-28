package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

public interface IProjectHandler {

  public Project getById(final Long id) throws StorageException;

  public List<Project> listProjects(final Long companyId) throws StorageException;

  public Project addProject(final Project project) throws StorageException;

  public Project updateProject(final Project project) throws StorageException;

}
