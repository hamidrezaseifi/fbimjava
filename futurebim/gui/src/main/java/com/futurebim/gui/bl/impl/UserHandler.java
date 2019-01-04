package com.futurebim.gui.bl.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.futurebim.common.model.edo.EncryptedContentEdo;
import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.UserFullEdo;
import com.futurebim.common.model.edo.UserLoginEdo;
import com.futurebim.common.model.edo.UserPasswordEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.helper.IUiRestTemplateCall;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.futurebim.GuiUserFull;

@Service
public class UserHandler implements IUserHandler {

  private final Logger logger = LoggerFactory.getLogger(UserHandler.class);

  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;

  @Autowired
  private IUiRestTemplateCall restTemplateCall;
  
  @Autowired
  private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;
  
  @Override
  public GuiUserFull authenticateUser(final String username, final String password, final String companyIdent) {
    
    logger.debug("get projects list from core");
    
    final UserLoginEdo        loginEdo    = new UserLoginEdo(username, password, companyIdent);
    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    try {
      encrypedEdo.setContentObject(loginEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
    }
    catch (final Exception e) {
      return null;
    }
    
    final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserAuthenticate(), EModule.CORE, encrypedEdo, EncryptedContentEdo.class, true);
    
    try {
      final UserFullEdo userEdo = encrypedResEdo.getObjectContent(UserFullEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());
      return GuiUserFull.fromEdo(userEdo);
    }
    catch (final Exception e) {
      return null;
    }
  }

  @Override
  public GuiUserFull saveUser(final GuiUserFull user) {
    final UserFullEdo         edo         = user.toEdo();
    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    try {
      encrypedEdo.setContentObject(edo, mappingJackson2HttpMessageConverter.getObjectMapper());
      
      final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserSave(), EModule.CORE, encrypedEdo, EncryptedContentEdo.class, true);
      final UserFullEdo         userEdo        = encrypedResEdo.getObjectContent(UserFullEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());
      return GuiUserFull.fromEdo(userEdo);
      
    }
    catch (final Exception e) {
      return null;
    }

  }

  @Override
  public GuiUserFull saveUserPassword(final GuiUserFull user, final String password) {
    UserFullEdo userEdo = user.toEdo();

    final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();
    
    try {
      encrypedEdo.setContentObject(userEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
      
      final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserSave(), EModule.CORE, encrypedEdo, EncryptedContentEdo.class, true);

      userEdo = encrypedResEdo.getObjectContent(UserFullEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());

      final UserPasswordEdo edoPassword = new UserPasswordEdo();
      edoPassword.setPassword(password);
      edoPassword.setUser(GuiUserFull.fromEdo(userEdo).toUser().toEdo());
      encrypedEdo.setContentObject(edoPassword, mappingJackson2HttpMessageConverter.getObjectMapper());
      
      restTemplateCall.callRestPost(coreAccessConfig.getUserSetPassword(), EModule.CORE, encrypedEdo, Void.class, true);

      return GuiUserFull.fromEdo(userEdo);
      
    }
    catch (final Exception e) {
      return null;
    }

  }

  @Override
  public List<GuiUserFull> listCompanyUsers(final Long companyId) {
    logger.debug("get user list for company from core");
    
    final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestGet(coreAccessConfig.getUserCompanyUserList(), EModule.CORE, EncryptedContentEdo.class, true, companyId);
    try {
      
      final TypeReference<FBCollectionEdo<UserFullEdo>> typeRef = new TypeReference<FBCollectionEdo<UserFullEdo>>() {
      };
      
      final FBCollectionEdo<UserFullEdo> edoCollection = encrypedResEdo.getObjectContent(typeRef, mappingJackson2HttpMessageConverter.getObjectMapper());
      return GuiUserFull.fromEdoList(edoCollection.getItems());
    }
    catch (final Exception e) {
      return null;
    }
  }

  @Override
  public GuiUserFull getById(final Long userId) {
    
    try {
      
      final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestGet(coreAccessConfig.getUserReadUrl(), EModule.CORE, EncryptedContentEdo.class, true, userId);
      final UserFullEdo         userEdo        = encrypedResEdo.getObjectContent(UserFullEdo.class, mappingJackson2HttpMessageConverter.getObjectMapper());
      return GuiUserFull.fromEdo(userEdo);
      
    }
    catch (final Exception e) {
      return null;
    }
  }

}
