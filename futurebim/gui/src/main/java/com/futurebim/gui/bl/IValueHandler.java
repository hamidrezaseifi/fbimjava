package com.futurebim.gui.bl;

import java.util.List;

import com.futurebim.gui.model.futurebim.GuiCountry;
import com.futurebim.gui.model.futurebim.GuiProjectStatus;
import com.futurebim.gui.model.futurebim.GuiProjectType;

public interface IValueHandler {

  List<GuiCountry> listCountries();

  List<GuiProjectType> listProjectTypes();

  List<GuiProjectStatus> listProjectStatusList();

  String getProjectTypeName(int type);

  String getProjectStatusName(int type);
}
