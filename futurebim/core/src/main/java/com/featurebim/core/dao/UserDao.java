package com.featurebim.core.dao;

import java.util.List;

import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.UserFull;

public interface UserDao {

  public UserFull addUser(UserFull user) throws StorageException;

  public UserFull updateUser(UserFull user) throws StorageException;

  public boolean updateUserRoles(UserFull user) throws StorageException;

  public boolean removeUser(Long id) throws StorageException;

  public UserFull getById(Long id) throws StorageException;

  public UserFull getByUsername(final String username) throws StorageException;

  public List<UserFull> listUsers() throws StorageException;

  public List<UserFull> listCompanyUsers(final Long companyId) throws StorageException;

  public List<Integer> listUserRoles(final Long userId) throws StorageException;

  public boolean setUserPassword(final Long id, final String password) throws StorageException;

}
