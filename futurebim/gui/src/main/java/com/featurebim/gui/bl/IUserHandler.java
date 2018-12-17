package com.featurebim.gui.bl;

import java.util.List;

import com.featurebim.gui.model.futurebim.GuiUserFull;

public interface IUserHandler {

  public GuiUserFull authenticateUser(final String username, final String password, final String companyIdent);

  public GuiUserFull getById(final Long userId);

  public GuiUserFull saveUser(final GuiUserFull user);

  public GuiUserFull saveUserPassword(final GuiUserFull user, final String password);
  
  public List<GuiUserFull> listCompanyUsers(final Long companyId);

}
