package com.futurebim.gui.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.futurebim.gui.bl.ProjectsHandler;
import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.helper.PageMenuLoader;
import com.futurebim.gui.model.MenuItem;

@Controller
@RequestMapping(path = "/ifc")
public class IfcViewerController extends UiControllerBase {

	@Autowired
	private PageMenuLoader pageMenuLoader;


	@Autowired
	ProjectsHandler projectsHandler;

	@Autowired
	private ObjectMapper                           objectMapper;

	@Autowired
	private MappingJackson2XmlHttpMessageConverter xmlConverter;


	@RequestMapping(path = "/")
	public String index(final Model model){
		model.addAttribute("breadCrumb" , new ArrayList<>());

		model.addAttribute("msg" , "IFC Viewer Index Page");

		return "ifcviewer/index";
	}

	@RequestMapping(path = "/balance")
	public String balance(final Model model){
		model.addAttribute("breadCrumb" , new ArrayList<>());

		model.addAttribute("msg" , "IFC Viewer Balance Page");

		return "ifcviewer/index";
	}








	@Override
	protected List<MenuItem> getTopToolbar() {

		return pageMenuLoader.getTopMenus("menu.ifc");
	}

	@Override
	protected List<MenuItem> getLeftToolbar() {

		return new ArrayList<>(); //pageMenuLoader.getLeftMenus("/ifc", getActiveLeftToolbarId());
	}

	@Override
	protected String getActiveLeftToolbarId() {
		// TODO Auto-generated method stub
		return "";
	}

}
