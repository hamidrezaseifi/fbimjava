package com.featurebim.core.bl;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;

public interface IUserHandler {

  public User addUser(final User user) throws StorageException;

  public User updateUser(final User user) throws StorageException;

  public boolean removeUser(final Long id) throws StorageException;

  public User getById(final Long id) throws StorageException;

  public User getByUsername(final String username) throws StorageException;

  public List<User> listUsers() throws StorageException;

  public List<User> listCompanyUsers(final Long companyId) throws StorageException;

  public User authenticateUser(final String username, final String password) throws StorageException;

}
