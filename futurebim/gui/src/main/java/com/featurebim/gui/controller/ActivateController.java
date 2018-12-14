package com.featurebim.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.featurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.featurebim.gui.bl.IUserHandler;
import com.featurebim.gui.bl.IValueHandler;
import com.featurebim.gui.configuration.UiConfiguration;
import com.featurebim.gui.controller.base.UiActivationControllerBase;
import com.featurebim.gui.model.futurebim.GuiCompany;
import com.featurebim.gui.model.futurebim.GuiUser;
import com.featurebim.gui.model.futurebim.GuiUserFull;
import com.featurebim.gui.model.futurebim.GuiUserPassword;
import com.featurebim.gui.model.ui.enums.EUiUserRole;

@Controller
@RequestMapping(path = "/activation")
public class ActivateController extends UiActivationControllerBase {

  @Autowired
  IUserHandler userHandler;
  
  @Autowired
  IValueHandler valueHandler;
  
  @Autowired
  UiConfiguration uiConfiguration;
  
  @RequestMapping(path = "/user")
  public String showActivateUser(final Model model) {

    model.addAttribute("acceptMediumPassword", uiConfiguration.isAcceptMediumPassword());
    model.addAttribute("acceptWeakPassword", uiConfiguration.isAcceptWeakPassword());

    return "activation/inituser";
  }
  
  @RequestMapping(path = "/company")
  public String showActivateCompany(final Model model) {

    model.addAttribute("users", userHandler.listCompanyUsers(this.getSessionUserInfo().getCompany().getId()));
    model.addAttribute("countries", valueHandler.listCountries());
    return "activation/initcompany";
  }

  @FbGuiRequestGetDataMapping(value = "/data/curuser")
  public GuiUser initUserData() {

    return this.getCurrentUser().toUser();
  }

  @FbGuiRequestGetDataMapping(value = "/data/curcompany")
  public GuiCompany initCompanyData() {

    return this.getSessionUserInfo().getCompany();
  }

  @FbGuiRequestPostDataMapping(value = "/data/saveuser")
  public GuiUserFull saveUserData(@RequestBody(required = true) final GuiUserPassword userPassword) {

    userPassword.getUser().setStatus(1);

    if (userPassword.getUser().getRoles().size() == 0) {
      userPassword.getUser().addRole(EUiUserRole.ADMIN);
    }
    final GuiUserFull user = userHandler.saveUserPassword(userPassword.getUser(), userPassword.getPassword());

    this.getSessionUserInfo().setUser(user);
    return user;
  }

}
