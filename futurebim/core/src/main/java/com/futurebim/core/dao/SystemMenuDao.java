package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.SystemMenuItem;

public interface SystemMenuDao {

  public SystemMenuItem getById(final Long id) throws StorageException;

  public SystemMenuItem add(final SystemMenuItem item) throws StorageException;

  public SystemMenuItem update(final SystemMenuItem item) throws StorageException;

  public boolean delete(final Long id) throws StorageException;

  public List<SystemMenuItem> listMenus() throws StorageException;

}
