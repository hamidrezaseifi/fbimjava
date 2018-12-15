package com.featurebim.gui.bl;

import java.util.List;

import com.featurebim.gui.model.futurebim.GuiCountry;
import com.featurebim.gui.model.futurebim.GuiProjectType;

public interface IValueHandler {
  
  List<GuiCountry> listCountries();
  
  List<GuiProjectType> listProjectTypes();
  
  String getProjectTypeName(int type);
}
