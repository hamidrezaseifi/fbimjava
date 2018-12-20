package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Workflow;

public interface WorkflowDao {

  public Workflow addNew(final Workflow workflow) throws StorageException;

  public Workflow getById(final Long id) throws StorageException;

  public List<Workflow> list(final Long projectId) throws StorageException;

  public Workflow update(final Workflow workflow) throws StorageException;

  boolean delete(final Workflow workflow) throws StorageException;
}
