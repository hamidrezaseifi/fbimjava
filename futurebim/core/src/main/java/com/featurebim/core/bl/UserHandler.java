package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.core.dao.UserDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;

@Service
public class UserHandler implements IUserHandler {

  private UserDao userDao;

  @Autowired(required = true)
  public void setUserService(final UserDao userDao) {
    this.userDao = userDao;
  }

  @Override
  public User addUser(final User user) throws StorageException {
    return userDao.addUser(user);
  }

  @Override
  public User updateUser(final User user) throws StorageException {
    return userDao.updateUser(user);
  }

  @Override
  public boolean removeUser(final Long id) throws StorageException {
    return userDao.removeUser(id);
  }

  @Override
  public User getById(final Long id) throws StorageException {
    return userDao.getById(id);
  }

  @Override
  public User getByUsername(final String username) throws StorageException {
    return userDao.getByUsername(username);
  }

  @Override
  public List<User> listUsers() throws StorageException {
    return userDao.listUsers();
  }

  @Override
  public List<User> listCompanyUsers(final Long companyId) throws StorageException {
    return userDao.listCompanyUsers(companyId);
  }

  @Override
  public User authenticateUser(final String username, final String password) throws StorageException {
    final User fUser = getByUsername(username);

    if (fUser != null && fUser.getHashPassword().equals(password)) {
      return fUser;
    }
    return null;
  }

}
