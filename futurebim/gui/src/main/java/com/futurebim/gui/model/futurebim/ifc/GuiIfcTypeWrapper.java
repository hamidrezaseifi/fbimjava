package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.common.model.edo.ifc.IfcDoorstyleEdo;
import com.futurebim.common.model.edo.ifc.IfcFurnituretypeEdo;
import com.futurebim.common.model.edo.ifc.IfcWindowstyleEdo;
import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "units")
public class GuiIfcTypeWrapper {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  @JsonProperty(value = "IfcFurnitureType")
  private List<GuiIfcFurnituretype> furnitureTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcDoorStyle")
  @JsonProperty(value = "IfcDoorStyle")
  private List<GuiIfcDoorstyle> doorTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcWindowStyle")
  @JsonProperty(value = "IfcWindowStyle")
  private List<GuiIfcWindowstyle> windowTypes = new ArrayList<>();

  public GuiIfcTypeWrapper(final ProjectIfcEdo edo){
    for(final IfcDoorstyleEdo edoType : edo.getTypes().getDoorTypes()){
      addDoorType(new GuiIfcDoorstyle(edoType));
    }
    for(final IfcFurnituretypeEdo edoType : edo.getTypes().getFurnitureTypes()){
      addFurnitureType(new GuiIfcFurnituretype(edoType));
    }
    for(final IfcWindowstyleEdo edoType : edo.getTypes().getWindowTypes()){
      addWindowType(new GuiIfcWindowstyle(edoType));
    }
    

  }

  public List<GuiIfcFurnituretype> getFurnitureTypes() {
    return furnitureTypes;
  }

  public void setFurnitureTypes(final List<GuiIfcFurnituretype> furnitureTypes) {
    this.furnitureTypes = furnitureTypes;
  }

  public void addFurnitureType(final GuiIfcFurnituretype furnitureType) {
    this.furnitureTypes.add(furnitureType);
  }

  public List<GuiIfcDoorstyle> getDoorTypes() {
    return doorTypes;
  }

  public void setDoorTypes(final List<GuiIfcDoorstyle> doorTypes) {
    this.doorTypes = doorTypes;
  }

  public void addDoorType(final GuiIfcDoorstyle doorType) {
    this.doorTypes.add(doorType);
  }

  public List<GuiIfcWindowstyle> getWindowTypes() {
    return windowTypes;
  }

  public void setWindowTypes(final List<GuiIfcWindowstyle> windowTypes) {
    this.windowTypes = windowTypes;
  }

  public void addWindowType(final GuiIfcWindowstyle windowType) {
    this.windowTypes.add(windowType);
  }

  public Map<String, Object> toIfcMap(){
    final Map<String, Object> root = new HashMap<>();
    root.put("type", "types");
    
    final List<Object> children = new ArrayList<>();
    for(final GuiIfcFurnituretype item: furnitureTypes){
      children.add(item);
    }
    for(final GuiIfcDoorstyle item: doorTypes){
      children.add(item);
    }
    for(final GuiIfcWindowstyle item: windowTypes){
      children.add(item);
    }
    root.put("children", children);

    return root;
  }
}
