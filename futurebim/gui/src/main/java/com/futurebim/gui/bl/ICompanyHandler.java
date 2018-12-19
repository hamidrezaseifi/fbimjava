package com.futurebim.gui.bl;

import com.futurebim.gui.model.futurebim.GuiCompany;

public interface ICompanyHandler {
  
  public GuiCompany getById(final Long id);

  public GuiCompany save(final GuiCompany company);
  
}
