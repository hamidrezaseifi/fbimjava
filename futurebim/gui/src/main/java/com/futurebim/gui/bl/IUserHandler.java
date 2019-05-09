package com.futurebim.gui.bl;

import java.util.List;
import java.util.Map;

import com.futurebim.gui.model.futurebim.GuiUserFull;

public interface IUserHandler {

	public GuiUserFull authenticateUser(final String username, final String password, final String companyIdent);

	public GuiUserFull getById(final Long userId);

	public GuiUserFull saveUser(final GuiUserFull user);

	public boolean deleteUser(final GuiUserFull user);

	public GuiUserFull saveUserPassword(final GuiUserFull user, final String password);

	public List<GuiUserFull> getCompanyUsers(final Long companyId);

	public GuiUserFull prepareUser(final GuiUserFull user);

	public List<GuiUserFull> prepareUserList(final List<GuiUserFull> list);

	public String getStatusName(final int status);

	public Map<Integer, String> getStatusMap();

	public String getGenderName(final int gender);

	public Map<Integer, String> getGenderMap();

	public boolean isUserDeletable();

}
