package com.featurebim.gui.bl.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.featurebim.gui.bl.IValueHandler;
import com.featurebim.gui.helper.MessagesHelper;
import com.featurebim.gui.model.futurebim.GuiCountry;
import com.featurebim.gui.model.futurebim.GuiProjectStatus;
import com.featurebim.gui.model.futurebim.GuiProjectType;

@Service
public class ValueHandler implements IValueHandler {

  @Autowired
  MessagesHelper messages;
  
  public ValueHandler() {

  }

  @Override
  public List<GuiCountry> listCountries() {

    return Arrays.asList(new GuiCountry("DE", "Deutschland"));
  }

  @Override
  public List<GuiProjectType> listProjectTypes() {

    return Arrays.asList(new GuiProjectType(1, "Test Type 1"), new GuiProjectType(2, "Test Type 2"), new GuiProjectType(3, "Test Type 3"));
  }

  @Override
  public String getProjectTypeName(final int type) {
    
    final List<GuiProjectType> list = listProjectTypes();
    
    for (final GuiProjectType projectType : list) {
      if (projectType.getType() == type) {
        return projectType.getName();
      }
    }
    
    return "";
  }
  
  @Override
  public List<GuiProjectStatus> listProjectStatusList() {
    
    return Arrays.asList(new GuiProjectStatus(1, messages.get("common.active")), new GuiProjectStatus(4, messages.get("common.deactive")));
  }

  @Override
  public String getProjectStatusName(final int status) {
    final List<GuiProjectStatus> list = listProjectStatusList();
    
    for (final GuiProjectStatus projectStatus : list) {
      if (projectStatus.getStatus() == status) {
        return projectStatus.getName();
      }
    }
    
    return "";
  }

}
