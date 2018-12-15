package com.featurebim.gui.bl;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.featurebim.gui.model.futurebim.GuiCountry;
import com.featurebim.gui.model.futurebim.GuiProjectType;

@Service
public class ValueHandler implements IValueHandler {
  
  public ValueHandler() {
    
  }
  
  @Override
  public List<GuiCountry> listCountries() {
    
    return Arrays.asList(new GuiCountry("DE", "Deutschland"));
  }
  
  @Override
  public List<GuiProjectType> listProjectTypes() {
    
    return Arrays.asList(new GuiProjectType(1, "Test Type"));
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
  
}
