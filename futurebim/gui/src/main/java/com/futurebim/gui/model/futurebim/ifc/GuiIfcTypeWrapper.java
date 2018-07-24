package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
  @JsonIgnore
  private List<GuiIfcFurnituretype> furnitureTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcDoorStyle")
  @JsonIgnore
  private List<GuiIfcDoorstyle> doorTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcWindowStyle")
  @JsonIgnore
  private List<GuiIfcWindowstyle> windowTypes = new ArrayList<>();
  
  private final String type = "types";
  
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

  public String getType() {
    return type;
  }

  public List<Object> getChildren() {

    final List<Object> children = new ArrayList<>();

    children.addAll(furnitureTypes);
    children.addAll(doorTypes);
    children.addAll(windowTypes);

    return children;
  }

}
