package com.featurebim.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.featurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.featurebim.gui.bl.IUserHandler;
import com.featurebim.gui.controller.base.UiActivationControllerBase;
import com.featurebim.gui.model.futurebim.GuiUser;
import com.featurebim.gui.model.futurebim.GuiUserPassword;
import com.featurebim.gui.model.ui.enums.EUiUserRole;

@Controller
@RequestMapping(path = "/activation")
public class ActivateController extends UiActivationControllerBase {

  @Autowired
  IUserHandler userHandler;
  
  @RequestMapping(path = "/user")
  public String showActivateUser(final Model model) {

    return "activation/inituser";
  }

  @FbGuiRequestGetDataMapping(value = "/data/curuser")
  public GuiUser initUserData() {

    return this.getCurrentUser().toUser();
  }

  @FbGuiRequestPostDataMapping(value = "/data/saveuser")
  public String saveUserData(@RequestBody(required = true) final GuiUserPassword userPassword) {

    userPassword.getUser().setStatus(1);

    if (userPassword.getUser().getRoles().size() == 0) {
      userPassword.getUser().addRole(EUiUserRole.ADMIN);
    }
    userHandler.saveUserPassword(userPassword.getUser(), userPassword.getPassword());

    return "ok";
  }

}
