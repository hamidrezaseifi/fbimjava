package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Task;

public interface ITaskHandler {

  public Task getById(final Long id) throws StorageException;

  public List<Task> listTasks(final Long projectId) throws StorageException;

  public Task saveTask(final Task task) throws StorageException;

  boolean deleteTask(final Task task) throws StorageException;

}
