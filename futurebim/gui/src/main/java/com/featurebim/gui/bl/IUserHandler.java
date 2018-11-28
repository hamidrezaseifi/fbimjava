package com.featurebim.gui.bl;

import com.featurebim.gui.model.futurebim.GuiUserFull;

public interface IUserHandler {

  public GuiUserFull authenticateUser(final String username, final String password);

}
