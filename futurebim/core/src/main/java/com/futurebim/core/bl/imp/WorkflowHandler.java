package com.futurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.common.exceptions.EExceptionType;
import com.futurebim.common.exceptions.FBCustomizedException;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.core.bl.IWorkflowHandler;
import com.futurebim.core.dao.WorkflowDao;
import com.futurebim.core.dao.WorkflowTypeDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Workflow;
import com.futurebim.core.model.WorkflowType;

@Service
public class WorkflowHandler implements IWorkflowHandler {

  @Autowired
  WorkflowDao workflowkDao;
  
  @Autowired
  WorkflowTypeDao workflowTypekDao;
  
  public WorkflowHandler() {

  }

  @Override
  public Workflow getById(final Long id) throws StorageException {
    return workflowkDao.getById(id);
  }

  @Override
  public List<Workflow> list(final Long projectId) throws StorageException {
    return workflowkDao.list(projectId);
  }

  @Override
  public Workflow save(final Workflow workflow) throws StorageException {
    if (workflow.isNew()) {
      workflow.setVersion(1);
      return workflowkDao.addNew(workflow);
    }

    checkRecordVersion(workflow);
    workflow.setVersion(workflow.getVersion() + 1);
    return workflowkDao.update(workflow);
  }

  @Override
  public boolean delete(final Workflow workflow) throws StorageException {
    return workflowkDao.delete(workflow);
  }
  
  private boolean checkRecordVersion(final Workflow workflow) throws StorageException {
    final Workflow exists = getById(workflow.getId());
    if (exists.getVersion() > workflow.getVersion()) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }

    return true;
  }

  @Override
  public List<WorkflowType> listWorkflowTypes() throws StorageException {
    
    return workflowTypekDao.list();
  }
}
