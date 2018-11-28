package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;
import com.featurebim.core.model.UserFull;

public interface UserDao {

  public User addUser(User user) throws StorageException;

  public User updateUser(User user) throws StorageException;

  public boolean removeUser(Long id) throws StorageException;

  public User getById(Long id) throws StorageException;

  public UserFull getByUsername(final String username) throws StorageException;

  public List<User> listUsers() throws StorageException;

  public List<User> listCompanyUsers(final Long companyId) throws StorageException;

  public List<Integer> listUserRoles(final Long userId) throws StorageException;

}
