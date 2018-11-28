package com.featurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.UserEdo;
import com.featurebim.common.model.edo.UserLoginEdo;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.IUserHandler;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private IUserHandler userHandler;

  @Autowired(required = true)
  public void setPersonService(final IUserHandler userHandler) {
    this.userHandler = userHandler;
  }

  @FbCoreRequestGetDataMapping(value = "/all")
  public List<UserEdo> readAll() throws StorageException {
    final List<User> users = userHandler.listUsers();
    return User.toEdoList(users);
  }

  @FbCoreRequestGetDataMapping(value = "/read/{companyid}")
  public List<UserEdo> getCompanyUsers(@PathVariable final Long companyid) throws StorageException {

    final List<User> users = userHandler.listCompanyUsers(companyid);
    return User.toEdoList(users);
  }

  @FbCoreRequestPostDataMapping(value = "/authenticate")
  public UserEdo authenticateUser(@RequestBody(required = true) final UserLoginEdo userLoginEdo) throws StorageException {

    final User authUser = userHandler.authenticateUser(userLoginEdo.getUsername(), userLoginEdo.getPassword());
    final UserEdo authUserEdo = authUser != null ? authUser.toEdo() : null;
    return authUserEdo;
  }
}
