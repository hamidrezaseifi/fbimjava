package com.futurebim.core.bl;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Workflow;

public interface IWorkflowHandler {

  public Workflow getById(final Long id) throws StorageException;

  public List<Workflow> list(final Long projectId) throws StorageException;

  public Workflow save(final Workflow workflow) throws StorageException;

  boolean delete(final Workflow workflow) throws StorageException;

}
