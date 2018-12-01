package com.featurebim.gui.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.featurebim.gui.controller.base.UiActivationControllerBase;

@Controller
@RequestMapping(path = "/activation")
public class ActivateController extends UiActivationControllerBase {

  @RequestMapping(path = "/inituser")
  public String initAll(final Model model) {

    return "activation/inituser";
  }

}
