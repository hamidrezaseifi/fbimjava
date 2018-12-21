package com.futurebim.core.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.WorkflowEdo;
import com.futurebim.common.model.edo.WorkflowTypeEdo;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.IWorkflowHandler;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Workflow;
import com.futurebim.core.model.WorkflowType;

@RestController
@RequestMapping(path = FbRestPaths.Core.WORKFLOW_BASE)
public class WorkflowController {
  
  private IWorkflowHandler workflowHandler;

  @Autowired(required = true)
  public void setPersonService(final IWorkflowHandler workflowHandler) {
    this.workflowHandler = workflowHandler;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.WORKFLOW_READALL_BASE)
  public FBCollectionEdo<WorkflowEdo> readAll(@PathVariable final Long projectid) throws StorageException {
    return new FBCollectionEdo<>(Workflow.toEdoList(workflowHandler.list(projectid)));
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.WORKFLOW_SAVE_BASE)
  public WorkflowEdo saveWorkflow(@RequestBody(required = true) final WorkflowEdo workflowEdo) throws StorageException {
    return workflowHandler.save(Workflow.fromEdo(workflowEdo)).toEdo();
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.WORKFLOW_READ_BASE)
  public WorkflowEdo readWorkflow(@PathVariable final Long workflowid) throws StorageException {
    return workflowHandler.getById(workflowid).toEdo();
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.WORKFLOW_DELETE_BASE)
  public boolean deleteWorkflow(@RequestBody final WorkflowEdo workflowEdo) throws StorageException {
    return workflowHandler.delete(Workflow.fromEdo(workflowEdo));
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.WORKFLOW_WORKFLOWTYPE_READALL_BASE)
  public FBCollectionEdo<WorkflowTypeEdo> readWorkflowTypes() throws StorageException {
    return new FBCollectionEdo<>(WorkflowType.toEdoList(workflowHandler.listWorkflowTypes()));
  }

}
