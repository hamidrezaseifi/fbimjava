package com.futurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.common.exceptions.EExceptionType;
import com.futurebim.common.exceptions.FBCustomizedException;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.core.bl.ITaskHandler;
import com.futurebim.core.dao.TaskDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Task;

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
  public List<Task> listTasksByPoject(final Long projectId) throws StorageException {
    return taskDao.listByProject(projectId);
  }
  
  @Override
  public List<Task> listTasksByWorkflow(final Long projectId) throws StorageException {
    return taskDao.listByWorkflow(projectId);
  }
  
  @Override
  public Task saveTask(final Task task) throws StorageException {
    if (task.isNew()) {
      task.setVersion(1);
      return taskDao.addNew(task);
    }
    
    checkRecordVersion(task);

    return taskDao.update(task);
  }
  
  @Override
  public boolean deleteTask(final Task task) throws StorageException {
    return taskDao.delete(task);
  }

  private boolean checkRecordVersion(final Task task) throws StorageException {
    final Task exists = getById(task.getId());
    if (exists.getVersion() > task.getVersion()) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }
    
    return true;
  }
}
