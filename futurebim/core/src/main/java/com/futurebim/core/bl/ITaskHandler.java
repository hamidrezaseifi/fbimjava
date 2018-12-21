package com.futurebim.core.bl;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Task;

public interface ITaskHandler {
  
  public Task getById(final Long id) throws StorageException;
  
  public List<Task> listTasksByPoject(final Long projectId) throws StorageException;
  
  public List<Task> listTasksByWorkflow(final Long projectId) throws StorageException;
  
  public Task saveTask(final Task task) throws StorageException;
  
  boolean deleteTask(final Task task) throws StorageException;
  
  public boolean addWorkflowTask(final Long workflowId, final Long taskId) throws StorageException;
  
  public boolean deleteWorkflowTask(final Long workflowId, final Long taskId) throws StorageException;
  
}
