package com.futurebim.gui.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import com.futurebim.gui.anotations.FbGuiRequestGetDataMapping;
import com.futurebim.gui.anotations.FbGuiRequestPostDataMapping;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.bl.IValueHandler;
import com.futurebim.gui.controller.base.UiControllerBase;
import com.futurebim.gui.model.futurebim.GuiUserFull;
import com.futurebim.gui.model.ui.GuiSystemMenuItem;

@Controller
@RequestMapping(path = "/admin")
public class AdminController extends UiControllerBase {

	@Autowired
	private IUserHandler userHandler;

	@Autowired
	private IValueHandler valueHandler;

	private final String topMenuId = "menu.top.administration";

	@RequestMapping(value = { "", "/", "/index" })
	public String showIndex(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		model.addAttribute("msg", "Admin Index Page");

		return "admin/index";
	}

	@RequestMapping(path = "/users/list")
	public String showUserList(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());

		return "admin/user/userlist";
	}

	@RequestMapping(path = "/users/create")
	public String showUserCreate(final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());
		model.addAttribute("userId", 0);
		model.addAttribute("statusList", userHandler.getStatusMap());
		model.addAttribute("genderList", userHandler.getGenderMap());

		return "admin/user/create";
	}

	@RequestMapping(path = "/users/view/{userid}")
	public String showUserView(@PathVariable(name = "userid") final long userid, final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());
		model.addAttribute("userId", userid);
		model.addAttribute("statusList", userHandler.getStatusMap());
		model.addAttribute("genderList", userHandler.getGenderMap());

		return "admin/user/view";
	}

	@RequestMapping(path = "/users/delete/{userid}")
	public String showUserDelete(@PathVariable(name = "userid") final long userid, final Model model) {
		model.addAttribute("breadCrumb", new ArrayList<>());
		model.addAttribute("userId", userid);
		model.addAttribute("user", userHandler.getById(userid));
		model.addAttribute("isDeletable", userid);

		return "admin/user/delete";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/users/data/delete")
	public RedirectView deleteUser(final Model model, final HttpServletResponse response,
			final HttpServletRequest request) throws IOException {

		final String delUserIdString = request.getParameter("deluserid");
		final String delUserVerString = request.getParameter("deluserver");

		final long userId = Long.parseLong(delUserIdString);
		final int userVersion = Integer.parseInt(delUserVerString);

		final GuiUserFull user = userHandler.getById(userId);
		user.setVersion(userVersion);

		userHandler.deleteUser(user);

		return new RedirectView("/admin/users/list");

	}

	@FbGuiRequestGetDataMapping(value = "/data/userlist")
	public Map<String, Object> getUserListData() {
		final Map<String, Object> list = new HashMap<>();

		list.put("users", userHandler.getCompanyUsers(this.getCurrentCompany().getId()));
		list.put("company", this.getCurrentCompany());

		return list;
	}

	@Override
	protected List<GuiSystemMenuItem> getLeftToolbar() {

		return pageMenuLoader.getLeftMenusById(topMenuId, getCurrentRelatedUrl());
	}

	@FbGuiRequestGetDataMapping(value = "/data/user/read/{userid}")
	public GuiUserFull getUserData(@PathVariable(name = "userid") final long userid) {

		if (userid == 0L) {
			return userHandler.prepareUser(GuiUserFull.createNew(this.getCurrentCompany().getId(), ""));
		}

		return userHandler.getById(userid);
	}

	@FbGuiRequestPostDataMapping(value = "/data/user/save")
	public GuiUserFull saveUserData(@RequestBody final GuiUserFull saveUser) {
		saveUser.setCompanyid(this.getCurrentCompany().getId());
		return userHandler.saveUser(saveUser);
	}

}
