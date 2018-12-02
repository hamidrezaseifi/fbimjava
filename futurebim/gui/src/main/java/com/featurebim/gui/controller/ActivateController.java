package com.featurebim.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.featurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.featurebim.gui.controller.base.UiActivationControllerBase;
import com.featurebim.gui.model.futurebim.GuiUser;
import com.featurebim.gui.model.futurebim.GuiUserFull;

@Controller
@RequestMapping(path = "/activation")
public class ActivateController extends UiActivationControllerBase {

  @RequestMapping(path = "/user")
  public String showActivateUser(final Model model) {

    return "activation/inituser";
  }

  @FbGuiRequestGetDataMapping(value = "/data/curuser")
  public GuiUserFull initUserData() {

    return this.getCurrentUser();
  }

  @FbGuiRequestPostDataMapping(value = "/data/saveuser")
  public GuiUser saveUserData(@RequestBody(required = true) final GuiUser user) {

    return user;
  }

}
