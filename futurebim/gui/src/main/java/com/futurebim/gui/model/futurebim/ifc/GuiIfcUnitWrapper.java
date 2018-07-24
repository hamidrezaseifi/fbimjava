package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.common.model.edo.ifc.IfcConversionBasedUnitEdo;
import com.futurebim.common.model.edo.ifc.IfcUnitEdo;
import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "units")
public class GuiIfcUnitWrapper {
  
  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcSIUnit")
  @JsonProperty(value = "IfcSIUnit")
  private List<GuiIfcUnit> units = new ArrayList<>();
  
  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcConversionBasedUnit")
  @JsonProperty(value = "IfcConversionBasedUnit")
  private List<GuiIfcConversionBasedUnit> conversionUnits = new ArrayList<>();
  
  public GuiIfcUnitWrapper(final ProjectIfcEdo edo){
    if(edo != null){
      for(final IfcUnitEdo edou : edo.getUnits().getUnits()){
        addUnit(new GuiIfcUnit(edou));
      }
      for(final IfcConversionBasedUnitEdo edou : edo.getUnits().getConversionUnits()){
        addConversionUnit(new GuiIfcConversionBasedUnit(edou));
      }
    }
  }

  public void setUnits(final List<GuiIfcUnit> units) {
    this.units = units;
  }
  
  public void addUnit(final GuiIfcUnit unit) {
    this.units.add(unit);
  }
  
  public List<GuiIfcConversionBasedUnit> getConversionUnits() {
    return conversionUnits;
  }
  
  public void setConversionUnits(final List<GuiIfcConversionBasedUnit> conversionUnits) {
    this.conversionUnits = conversionUnits;
  }
  
  public void addConversionUnit(final GuiIfcConversionBasedUnit conversion) {
    this.conversionUnits.add(conversion);
  }
  
  public List<GuiIfcUnit> getUnits() {
    return units;
  }
  
  public Map<String, Object> toIfcMap(){
    final Map<String, Object> root = new HashMap<>();
    root.put("type", "units");
    
    final List<Object> children = new ArrayList<>();
    for(final GuiIfcUnit unit: units){
      children.add(unit);
    }
    for(final GuiIfcConversionBasedUnit unit: conversionUnits){
      children.add(unit);
    }
    root.put("children", children);

    return root;
  }
}
