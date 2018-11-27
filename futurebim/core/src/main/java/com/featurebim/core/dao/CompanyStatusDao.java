package com.featurebim.core.dao;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.CompanyStatusItem;
import com.featurebim.core.model.CompanyStatusList;

public interface CompanyStatusDao {

  public CompanyStatusItem getById(int id) throws StorageException;

  public CompanyStatusList listStatus() throws StorageException;

}
