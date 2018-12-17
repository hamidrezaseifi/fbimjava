package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Project;

public interface ProjectDao {

  public Project addProject(Project c) throws StorageException;

  public Project updateProject(Project c) throws StorageException;

  public boolean deleteProject(Long id) throws StorageException;

  public Project getById(Long id) throws StorageException;

  public List<Project> listProjects(final Long companyId) throws StorageException;

}
