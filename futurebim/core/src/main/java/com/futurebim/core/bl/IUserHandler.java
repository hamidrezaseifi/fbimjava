package com.futurebim.core.bl;

import java.util.List;

import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.User;
import com.futurebim.core.model.UserFull;

public interface IUserHandler {

  public UserFull saveUser(final UserFull user) throws StorageException;
  
  public boolean removeUser(final UserFull user) throws StorageException;
  
  public UserFull getById(final Long id) throws StorageException;
  
  public UserFull getByUsername(final String companyIdent, final String username) throws StorageException;
  
  public List<UserFull> listUsers() throws StorageException;
  
  public List<UserFull> listCompanyUsers(final Long companyId) throws StorageException;
  
  public UserFull authenticateUser(final String companyIdent, final String username, final String password) throws StorageException;
  
  public boolean setUserPassword(final User user, String password) throws StorageException;
  
}
