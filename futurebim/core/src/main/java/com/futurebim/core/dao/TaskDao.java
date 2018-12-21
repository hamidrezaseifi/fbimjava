package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Task;

public interface TaskDao {
  
  public Task addNew(final Task task) throws StorageException;
  
  public Task getById(final Long id) throws StorageException;
  
  public List<Task> listByProject(final Long projectId) throws StorageException;
  
  public List<Task> listByWorkflow(final Long projectId) throws StorageException;
  
  public Task update(final Task task) throws StorageException;
  
  boolean delete(final Task task) throws StorageException;
}
