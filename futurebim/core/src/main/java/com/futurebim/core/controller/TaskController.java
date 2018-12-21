package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.TaskEdo;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.ITaskHandler;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Task;

@RestController
@RequestMapping(path = FbRestPaths.Core.TASK_BASE)
public class TaskController {
  
  private ITaskHandler taskHandler;

  @Autowired(required = true)
  public void setPersonService(final ITaskHandler taskHandler) {
    this.taskHandler = taskHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.TASK_PROJECT_READALL_BASE)
  public FBCollectionEdo<TaskEdo> readAllByProject(@PathVariable final Long projectid) throws StorageException {
    return new FBCollectionEdo<>(Task.toEdoList(taskHandler.listTasksByPoject(projectid)));
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.TASK_SAVE_BASE)
  public TaskEdo createProject(@RequestBody(required = true) final TaskEdo taskEdo) throws StorageException {
    return taskHandler.saveTask(Task.fromEdo(taskEdo)).toEdo();
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.TASK_READ_BASE)
  public TaskEdo getProject(@PathVariable final Long taskid) throws StorageException {
    return taskHandler.getById(taskid).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.TASK_DELETE_BASE)
  public boolean deleteProject(@RequestBody final TaskEdo taskEdo) throws StorageException {
    return taskHandler.deleteTask(Task.fromEdo(taskEdo));
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.TASK_WORKFLOW_READALL_BASE)
  public FBCollectionEdo<TaskEdo> readAllByWorkflow(@PathVariable final Long workflowid) throws StorageException {
    return new FBCollectionEdo<>(Task.toEdoList(taskHandler.listTasksByWorkflow(workflowid)));
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.TASK_WORKFLOW_ADD_BASE)
  public boolean addWorkflowTask(@PathVariable final Long workflowid, @PathVariable final Long taskid) throws StorageException {
    return taskHandler.addWorkflowTask(workflowid, taskid);
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.TASK_WORKFLOW_DELETE_BASE)
  public boolean deleteWorkflowTask(@PathVariable final Long workflowid, @PathVariable final Long taskid) throws StorageException {
    return taskHandler.deleteWorkflowTask(workflowid, taskid);
  }
  
}
