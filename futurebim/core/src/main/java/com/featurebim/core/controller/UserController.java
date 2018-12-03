package com.featurebim.core.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.featurebim.common.model.edo.EncryptedContentEdo;
import com.featurebim.common.model.edo.UserFullEdo;
import com.featurebim.common.model.edo.UserLoginEdo;
import com.featurebim.core.annotations.FbCoreRequestGetDataMapping;
import com.featurebim.core.annotations.FbCoreRequestPostDataMapping;
import com.featurebim.core.bl.IUserHandler;
import com.featurebim.core.model.User;
import com.featurebim.core.model.UserFull;

@RestController
@RequestMapping(path = "/user")
public class UserController {

  private IUserHandler userHandler;
  
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  
  @Autowired(required = true)
  public void setPersonService(final IUserHandler userHandler,
      final MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter) {
    this.userHandler = userHandler;
    this.mappingJackson2HttpMessageConverter = mappingJackson2HttpMessageConverter;
  }
  
  @FbCoreRequestGetDataMapping(value = "/read/{companyid}")
  public EncryptedContentEdo getCompanyUsers(@PathVariable final Long companyid) throws Exception {

    final List<User> users = userHandler.listCompanyUsers(companyid);

    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    encrypedEdo.setContentObject(User.toEdoList(users), mappingJackson2HttpMessageConverter.getObjectMapper());
    
    return encrypedEdo;
  }

  @FbCoreRequestPostDataMapping(value = "/authenticate")
  public EncryptedContentEdo authenticateUser(@RequestBody(required = true) final EncryptedContentEdo encrypedEdo) throws Exception {

    final UserLoginEdo userLoginEdo = encrypedEdo.getObjectContent(UserLoginEdo.class,
        mappingJackson2HttpMessageConverter.getObjectMapper());
    final UserFull authUser = userHandler.authenticateUser(userLoginEdo.getUsername(), userLoginEdo.getPassword());
    final UserFullEdo authUserEdo = authUser != null ? authUser.toEdo() : null;

    final EncryptedContentEdo resEncrypedEdo = new EncryptedContentEdo();
    resEncrypedEdo.setContentObject(authUserEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
    return resEncrypedEdo;
  }
}
