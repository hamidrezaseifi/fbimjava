package com.featurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.common.exceptions.EExceptionType;
import com.featurebim.common.exceptions.FBCustomizedException;
import com.featurebim.common.model.enums.EModule;
import com.featurebim.core.bl.ITaskHandler;
import com.featurebim.core.dao.TaskDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Task;

@Service
public class TaskHandler implements ITaskHandler {
  
  @Autowired
  TaskDao taskDao;

  public TaskHandler() {
    
  }
  
  @Override
  public Task getById(final Long id) throws StorageException {
    return taskDao.getById(id);
  }
  
  @Override
  public List<Task> listTasks(final Long projectId) throws StorageException {
    return taskDao.listTasks(projectId);
  }
  
  @Override
  public Task saveTask(final Task task) throws StorageException {
    if (task.isNew()) {
      task.setVersion(1);
      return taskDao.addTask(task);
    }
    
    checkRecordVersion(task);

    return taskDao.updateTask(task);
  }
  
  @Override
  public boolean deleteTask(final Task task) throws StorageException {
    return taskDao.deleteTask(task);
  }

  private boolean checkRecordVersion(final Task task) throws StorageException {
    final Task exists = getById(task.getId());
    if (exists.getVersion() > task.getVersion()) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }
    
    return true;
  }
}
