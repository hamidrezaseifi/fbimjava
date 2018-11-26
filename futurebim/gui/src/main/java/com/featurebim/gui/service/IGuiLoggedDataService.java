package com.featurebim.gui.service;

import com.featurebim.gui.model.GuiLoggedData;

public interface IGuiLoggedDataService {
  
  public GuiLoggedData getLoggedData();
  
  public boolean isLoggedIn();
  
  public GuiLoggedData createLoggedData();
}
