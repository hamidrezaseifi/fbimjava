package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.WorkflowType;

public interface WorkflowTypeDao {
  
  public WorkflowType getById(final Long id) throws StorageException;
  
  public List<WorkflowType> list() throws StorageException;
  
}
