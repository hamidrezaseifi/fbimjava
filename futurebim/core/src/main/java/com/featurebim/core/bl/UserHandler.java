package com.featurebim.core.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.featurebim.common.exceptions.EExceptionType;
import com.featurebim.common.exceptions.FBCustomizedException;
import com.featurebim.common.model.enums.EModule;
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
  public UserFull saveUser(final UserFull user) throws StorageException {
    if (user.isNew()) {
      return userDao.addUser(user);
    }
    else {
      checkUserVersion(user.getId(), user.getVersion());
      user.setVersion(user.getVersion() + 1);
      return userDao.updateUser(user);
    }
    
  }

  @Override
  public boolean removeUser(final UserFull user) throws StorageException {
    return userDao.removeUser(user.getId());
  }

  @Override
  public UserFull getById(final Long id) throws StorageException {
    return userDao.getById(id);
  }

  @Override
  public UserFull getByUsername(final String username) throws StorageException {
    return userDao.getByUsername(username);
  }

  @Override
  public List<UserFull> listUsers() throws StorageException {
    return userDao.listUsers();
  }

  @Override
  public List<UserFull> listCompanyUsers(final Long companyId) throws StorageException {
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
  public boolean setUserPassword(final User user, final String password) throws StorageException {

    checkUserVersion(user.getId(), user.getVersion());

    return userDao.setUserPassword(user.getId(), passwordEncoder.encode(password));
  }
  
  private boolean checkUserVersion(final long userId, final int version) throws StorageException {
    final UserFull existsUser = userDao.getById(userId);
    if (existsUser.getVersion() > version) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }

    return true;
  }

}
