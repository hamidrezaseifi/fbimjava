package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;
import com.featurebim.core.model.UserFull;

public interface IUserHandler {

  public User addUser(final User user) throws StorageException;

  public User updateUser(final User user) throws StorageException;

  public boolean removeUser(final Long id) throws StorageException;

  public User getById(final Long id) throws StorageException;

  public UserFull getByUsername(final String username) throws StorageException;

  public List<User> listUsers() throws StorageException;

  public List<User> listCompanyUsers(final Long companyId) throws StorageException;

  public UserFull authenticateUser(final String username, final String password) throws StorageException;

  public boolean setUserPassword(final Long id, final String password) throws StorageException;

}
