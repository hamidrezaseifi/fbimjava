package com.featurebim.gui.bl;

import com.featurebim.gui.model.futurebim.GuiUser;

public interface IUserHandler {

  public GuiUser authenticateUser(final String username, final String password);

}
