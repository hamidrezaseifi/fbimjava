package com.futurebim.gui.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.futurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.futurebim.gui.bl.ICompanyHandler;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.bl.IValueHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.controller.base.UiActivationControllerBase;
import com.futurebim.gui.model.futurebim.GuiCompany;
import com.futurebim.gui.model.futurebim.GuiUser;
import com.futurebim.gui.model.futurebim.GuiUserFull;
import com.futurebim.gui.model.futurebim.GuiUserPassword;
import com.futurebim.gui.model.ui.enums.EUiUserRole;

@Controller
@RequestMapping(path = "/activation")
public class ActivateController extends UiActivationControllerBase {

  @Autowired
  IUserHandler userHandler;
  
  @Autowired
  ICompanyHandler companyHandler;
  
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

    model.addAttribute("users", userHandler.getCompanyUsers(this.getCurrentCompany().getId()));
    model.addAttribute("countries", valueHandler.listCountries());
    return "activation/initcompany";
  }

  @FbGuiRequestGetDataMapping(value = "/data/curuser")
  public GuiUser initUserData() {

    return this.getCurrentUser().toUser();
  }

  @FbGuiRequestGetDataMapping(value = "/data/curcompany")
  public GuiCompany initCompanyData() {

    return this.getCurrentCompany();
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

  @FbGuiRequestPostDataMapping(value = "/data/savecompany")
  public GuiCompany saveUserData(@RequestBody(required = true) final GuiCompany company) {

    company.setStatus(1);

    final GuiCompany res = companyHandler.save(company);

    this.getSessionUserInfo().setCompany(res);
    return res;
  }

}
