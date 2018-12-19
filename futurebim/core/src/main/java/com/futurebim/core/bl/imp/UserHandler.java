package com.futurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.futurebim.common.exceptions.EExceptionType;
import com.futurebim.common.exceptions.FBCustomizedException;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.core.bl.IUserHandler;
import com.futurebim.core.dao.UserDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.User;
import com.futurebim.core.model.UserFull;

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
      user.setVersion(1);
      return userDao.addUser(user);
    }
    else {
      checkRecordVersion(user.getId(), user.getVersion());
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
  public UserFull getByUsername(final String companyIdent, final String username) throws StorageException {
    return userDao.getByUsername(companyIdent, username);
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
  public UserFull authenticateUser(final String companyIdent, final String username, final String password) throws StorageException {

    final UserFull fUser = getByUsername(companyIdent, username);
    
    if (fUser != null && passwordEncoder.matches(password, fUser.getHashPassword())) {
      return fUser;
    }
    return null;
  }

  @Override
  public boolean setUserPassword(final User user, final String password) throws StorageException {

    checkRecordVersion(user.getId(), user.getVersion());

    return userDao.setUserPassword(user.getId(), passwordEncoder.encode(password));
  }
  
  private boolean checkRecordVersion(final long userId, final int version) throws StorageException {
    final UserFull existsUser = userDao.getById(userId);
    if (existsUser.getVersion() > version) {
      throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
    }

    return true;
  }

}
