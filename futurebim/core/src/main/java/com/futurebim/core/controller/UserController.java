package com.futurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.futurebim.common.exception.FbCustomeException;
import com.futurebim.common.exceptions.EExceptionType;
import com.futurebim.common.exceptions.FBCustomizedException;
import com.futurebim.common.model.edo.EncryptedContentEdo;
import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.UserFullEdo;
import com.futurebim.common.model.edo.UserLoginEdo;
import com.futurebim.common.model.edo.UserPasswordEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.common.rest.FbRestPaths;
import com.futurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.futurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.futurebim.core.bl.IUserHandler;
import com.futurebim.core.model.User;
import com.futurebim.core.model.UserFull;

@RestController
@RequestMapping(path = FbRestPaths.Core.USER_BASE)
public class UserController {

  private IUserHandler userHandler;
  
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  
  @Autowired(required = true)
  public void setPersonService(final IUserHandler userHandler, final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
    this.userHandler = userHandler;
    this.mappingJackson2HttpMessageConverter = mappingJackson2HttpMessageConverter;
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.USER_COMPANYUSERS_BASE)
  public EncryptedContentEdo getCompanyUsers(@PathVariable final Long companyid) throws Exception {

    final List<UserFull> users = userHandler.listCompanyUsers(companyid);

    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    encrypedEdo.setContentObject(new FBCollectionEdo<>(UserFull.toEdoList(users)), mappingJackson2HttpMessageConverter.getObjectMapper());
    
    return encrypedEdo;
  }

  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.USER_AUTHENTICATE_BASE)
  public EncryptedContentEdo authenticateUser(@RequestBody(required = true) final EncryptedContentEdo encrypedEdo) throws Exception {
    UserLoginEdo userLoginEdo = null;
    try {
      userLoginEdo = encrypedEdo.getObjectContent(UserLoginEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());
    }
    catch (final Exception ex) {
      throw new FbCustomeException("Invalid Authentication Data", ex);
    }

    final UserFull    authUser    = userHandler.authenticateUser(userLoginEdo.getCompanyIdent(), userLoginEdo.getUsername(), userLoginEdo.getPassword());
    final UserFullEdo authUserEdo = authUser != null ? authUser.toEdo() : null;

    final EncryptedContentEdo resEncrypedEdo = new EncryptedContentEdo();
    resEncrypedEdo.setContentObject(authUserEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
    return resEncrypedEdo;
  }
  
  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.USER_SAVE_BASE)
  public EncryptedContentEdo saveUser(@RequestBody(required = true) final EncryptedContentEdo encrypedEdo) throws Exception {

    final UserFullEdo userEdo = encrypedEdo.getObjectContent(UserFullEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());
    final UserFull    resUser = userHandler.saveUser(UserFull.fromEdo(userEdo));

    final UserFullEdo resUserEdo = resUser != null ? resUser.toEdo() : null;

    final EncryptedContentEdo resEncrypedEdo = new EncryptedContentEdo();
    resEncrypedEdo.setContentObject(resUserEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
    return resEncrypedEdo;
  }

  @FbCoreRequestPostDataMapping(value = FbRestPaths.Core.USER_SETPASSWORD_BASE)
  public void setUserPassword(@RequestBody(required = true) final EncryptedContentEdo encrypedEdo) throws Exception {

    final UserPasswordEdo edo = encrypedEdo.getObjectContent(UserPasswordEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());

    final User user = User.fromEdo(edo.getUser());
    
    if (!userHandler.setUserPassword(user, edo.getPassword())) {

      throw new FBCustomizedException(EExceptionType.SaveError.name(), "Error in save customer!", EModule.CORE.getModuleName());
    }
  }
  
  @FbCoreRequestGetDataMapping(value = FbRestPaths.Core.USER_READ_BASE)
  public EncryptedContentEdo readUser(@RequestBody(required = true) @PathVariable final Long userid) throws Exception {

    final UserFull    authUser    = userHandler.getById(userid);
    final UserFullEdo authUserEdo = authUser != null ? authUser.toEdo() : null;

    final EncryptedContentEdo resEncrypedEdo = new EncryptedContentEdo();
    resEncrypedEdo.setContentObject(authUserEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
    return resEncrypedEdo;
  }
  
}
