package com.futurebim.gui.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.controller.base.UiControllerBase;

@Controller
@RequestMapping(path = "/user")
public class UserController extends UiControllerBase {

	@RequestMapping(value = { "", "/", "/index" })
	public String index(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "User Index Page");

		return "index";
	}

}
