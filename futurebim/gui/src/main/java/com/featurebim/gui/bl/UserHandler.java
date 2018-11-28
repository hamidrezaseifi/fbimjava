package com.featurebim.gui.bl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.common.model.edo.UserEdo;
import com.featurebim.common.model.edo.UserLoginEdo;
import com.featurebim.common.model.enums.EModule;
import com.featurebim.gui.configuration.UiConfiguration;
import com.featurebim.gui.helper.IUiRestTemplateCall;
import com.featurebim.gui.helper.MessagesHelper;
import com.featurebim.gui.model.futurebim.GuiUser;

@Service
public class UserHandler implements IUserHandler {

  private final Logger logger = LoggerFactory.getLogger(UserHandler.class);

  @Autowired
  MessagesHelper messages;

  @Autowired
  UiConfiguration.CoreAccessConfig coreAccessConfig;

  @Autowired
  private IUiRestTemplateCall restTemplateCall;

  @Override
  public GuiUser authenticateUser(final String username, final String password) {

    logger.debug("get projects list from core");

    final UserLoginEdo loginEdo = new UserLoginEdo(username, password);

    final UserEdo userEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserAuthenticate(),
                                                          EModule.CORE,
                                                          loginEdo,
                                                          UserEdo.class,
                                                          false);

    return GuiUser.fromEdo(userEdo);
  }

}
