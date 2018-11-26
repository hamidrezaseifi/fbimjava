package com.futurebim.gui.service;

import com.futurebim.gui.model.GuiLoggedData;

public interface IGuiLoggedDataService {
  
  public GuiLoggedData getLoggedData();
  
  public boolean isLoggedIn();
  
  public GuiLoggedData createLoggedData();
}
