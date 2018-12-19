package com.featurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.FBCollectionEdo;
import com.featurebim.common.model.edo.TaskEdo;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.ITaskHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.Task;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

  private ITaskHandler taskHandler;
  
  @Autowired(required = true)
  public void setPersonService(final ITaskHandler taskHandler) {
    this.taskHandler = taskHandler;
  }

  @FbCoreRequestGetDataMapping(value = "/project/readall/{projectId}")
  public FBCollectionEdo<TaskEdo> readAll(@PathVariable final Long projectId) throws StorageException {
    return new FBCollectionEdo<>(Task.toEdoList(taskHandler.listTasks(projectId)));
  }

  @FbCoreRequestPostDataMapping(value = "/save")
  public TaskEdo createProject(@RequestBody(required = true) final TaskEdo taskEdo) throws StorageException {
    return taskHandler.saveTask(Task.fromEdo(taskEdo)).toEdo();
  }

  @FbCoreRequestGetDataMapping(value = "/read/{taskId}")
  public TaskEdo getProject(@PathVariable final Long taskId) throws StorageException {
    return taskHandler.getById(taskId).toEdo();
  }

  @FbCoreRequestPostDataMapping(value = "/delete")
  public boolean deleteProject(@RequestBody final TaskEdo taskEdo) throws StorageException {
    return taskHandler.deleteTask(Task.fromEdo(taskEdo));
  }
  
}
