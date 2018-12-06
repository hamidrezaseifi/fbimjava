package com.featurebim.gui.bl;

import com.featurebim.gui.model.futurebim.GuiCompany;

public interface ICompanyHandler {

  public GuiCompany getById(final Long id);
  
  public GuiCompany update(final GuiCompany company);

}
