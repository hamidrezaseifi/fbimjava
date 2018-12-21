package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.WorkflowEdo;
import com.futurebim.common.model.edo.WorkflowTypeEdo;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.IWorkflowHandler;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Workflow;
import com.futurebim.core.model.WorkflowType;

@RestController
@RequestMapping(path = "/workflow")
public class WorkflowController {
  
  private IWorkflowHandler workflowHandler;

  @Autowired(required = true)
  public void setPersonService(final IWorkflowHandler workflowHandler) {
    this.workflowHandler = workflowHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = "/project/readall/{projectId}")
  public FBCollectionEdo<WorkflowEdo> readAll(@PathVariable final Long projectId) throws StorageException {
    return new FBCollectionEdo<>(Workflow.toEdoList(workflowHandler.list(projectId)));
  }
  
  @FbCoreRequestPostDataMapping(value = "/save")
  public WorkflowEdo saveWorkflow(@RequestBody(required = true) final WorkflowEdo workflowEdo) throws StorageException {
    return workflowHandler.save(Workflow.fromEdo(workflowEdo)).toEdo();
  }
  
  @FbCoreRequestGetDataMapping(value = "/read/{workflowId}")
  public WorkflowEdo readWorkflow(@PathVariable final Long workflowId) throws StorageException {
    return workflowHandler.getById(workflowId).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = "/delete")
  public boolean deleteWorkflow(@RequestBody final WorkflowEdo workflowEdo) throws StorageException {
    return workflowHandler.delete(Workflow.fromEdo(workflowEdo));
  }
  
  @FbCoreRequestGetDataMapping(value = "/workflowtype/readall")
  public FBCollectionEdo<WorkflowTypeEdo> readWorkflowTypes() throws StorageException {
    return new FBCollectionEdo<>(WorkflowType.toEdoList(workflowHandler.listWorkflowTypes()));
  }

}
