package com.futurebim.core.dao;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.CompanyStatusItem;
import com.futurebim.core.model.CompanyStatusList;

public interface CompanyStatusDao {

  public CompanyStatusItem getById(int id) throws StorageException;

  public CompanyStatusList listStatus() throws StorageException;

}
