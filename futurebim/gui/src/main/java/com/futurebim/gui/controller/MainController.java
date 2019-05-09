package com.futurebim.gui.controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.futurebim.gui.controller.base.UiControllerBase;

@Controller
@RequestMapping(path = "/")
public class MainController extends UiControllerBase {

	@RequestMapping(value = { "", "/", "/index" })
	public String index(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Index Page ");

		return "index";
	}

	@RequestMapping(path = "/site/balance")
	public String balance(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Balance Page");
		return "index";
	}

	@RequestMapping(path = "/site/alarm")
	public String alarm(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Alarm Page");

		return "index";
	}

	@RequestMapping(path = "/site/settings")
	public String settings(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Konfiguration Page ");

		return "index";
	}

	@RequestMapping(path = "/site/code")
	public String code(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Entwicklung Page");

		return "index";
	}

	@RequestMapping(path = "/site/questions")
	public String questions(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Fragen Page");

		return "index";
	}

	@RequestMapping(path = "/noaccess")
	public String moves(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Bewegungen Page");

		return "noaccess";
	}

}
