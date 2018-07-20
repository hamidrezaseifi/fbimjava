package com.futurebim.gui.model.futurebim.ifc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;

/**
 * The persistent class for the project_ifc database table.
 *
 */
@JacksonXmlRootElement(localName = "ifc", namespace = "http://www.w3.org/1999/xlink")
public class GuiProjectIfc {
  
  @JacksonXmlProperty(localName = "header")
  private final Map<String, Object> header;
  
  @JacksonXmlProperty(localName = "units")
  private GuiIfcUnitWrapper units;
  
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  private List<GuiIfcProperty> properties = new ArrayList<>();
  
  @JacksonXmlProperty(localName = "types")
  private GuiIfcTypeWrapper types;
  
  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  private List<GuiIfcPresentationlayer> layers = new ArrayList<>();
  
  @JacksonXmlElementWrapper(localName = "decomposition")
  private GuiIfcDecompositionWrapper decomposition;
  
  public GuiProjectIfc() {
    
    this.header = new HashMap<>();
    this.units = new GuiIfcUnitWrapper();
    this.types = new GuiIfcTypeWrapper();
    this.decomposition = new GuiIfcDecompositionWrapper();
    
  }
  
  public GuiProjectIfc(final ProjectIfcEdo edo) {
    
    this.header = new HashMap<>();
    this.header.putAll(edo.getHeader());
    this.units = new GuiIfcUnitWrapper();
    this.types = new GuiIfcTypeWrapper();
    this.decomposition = new GuiIfcDecompositionWrapper();
    
  }
  
  public GuiIfcUnitWrapper getUnits() {
    return units;
  }
  
  public void setUnits(final GuiIfcUnitWrapper units) {
    this.units = units;
  }
  
  public List<GuiIfcProperty> getProperties() {
    return properties;
  }
  
  public void setProperties(final List<GuiIfcProperty> properties) {
    this.properties = properties;
  }
  
  public void addProperty(final GuiIfcProperty property) {
    this.properties.add(property);
  }
  
  public GuiIfcTypeWrapper getTypes() {
    return types;
  }
  
  public void setTypes(final GuiIfcTypeWrapper types) {
    this.types = types;
  }
  
  public List<GuiIfcPresentationlayer> getLayers() {
    return layers;
  }
  
  public void setLayers(final List<GuiIfcPresentationlayer> layers) {
    this.layers = layers;
  }
  
  public void addLayer(final GuiIfcPresentationlayer layer) {
    this.layers.add(layer);
  }
  
  public GuiIfcDecompositionWrapper getDecomposition() {
    return decomposition;
  }
  
  public void setDecomposition(final GuiIfcDecompositionWrapper decomposition) {
    this.decomposition = decomposition;
  }
  
  public Map<String, Object> getHeader() {
    return header;
  }
  
  public void addConversionUnit(final GuiIfcConversionBasedUnit conversion) {
    this.units.addConversionUnit(conversion);
  }
  
  public void addUnit(final GuiIfcUnit unit) {
    this.units.addUnit(unit);
  }
  
  public void addFurnitureType(final GuiIfcFurnituretype furnitureType) {
    this.types.addFurnitureType(furnitureType);
  }
  
  public void addDoorType(final GuiIfcDoorstyle doorType) {
    this.types.addDoorType(doorType);
  }
  
  public void addWindowType(final GuiIfcWindowstyle windowType) {
    this.types.addWindowType(windowType);
  }
  
  public void addProject(final GuiIfcProject project) {
    this.decomposition.addProject(project);
  }
  
}
