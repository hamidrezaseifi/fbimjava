package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.featurebim.core.dao.UserDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;
import com.featurebim.core.model.UserFull;

@Service
public class UserHandler implements IUserHandler {

  private UserDao userDao;

  private PasswordEncoder passwordEncoder;

  @Autowired(required = true)
  public void setUserService(final UserDao userDao, final PasswordEncoder passwordEncoder) {
    this.userDao = userDao;
    this.passwordEncoder = passwordEncoder;
  }

  @Override
  public User addUser(final User user) throws StorageException {
    user.setHashPassword(passwordEncoder.encode(user.getHashPassword()));
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
  public UserFull getByUsername(final String username) throws StorageException {
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
  public UserFull authenticateUser(final String username, final String password) throws StorageException {

    final UserFull fUser = getByUsername(username);

    if (fUser != null && passwordEncoder.matches(password, fUser.getHashPassword())) {
      return fUser;
    }
    return null;
  }

  @Override
  public boolean setUserPassword(final Long id, final String password) throws StorageException {
    final String encrypedPassword = passwordEncoder.encode(password);

    return userDao.setUserPassword(id, encrypedPassword);
  }

}
