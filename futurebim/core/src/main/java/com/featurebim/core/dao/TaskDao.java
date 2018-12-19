package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Task;

public interface TaskDao {

  public Task addTask(final Task task) throws StorageException;

  public Task getById(final Long id) throws StorageException;

  public List<Task> listTasks(final Long projectId) throws StorageException;

  public Task updateTask(final Task task) throws StorageException;

  boolean deleteTask(final Task task) throws StorageException;
}
