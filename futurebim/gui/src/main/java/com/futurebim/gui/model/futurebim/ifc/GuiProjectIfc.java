package com.futurebim.gui.model.futurebim.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
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
  private Map<String, Object> header;

  @JacksonXmlProperty(localName = "units")
  private GuiIfcUnitWrapper units;

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  @JsonProperty(value = "properties")
  private List<GuiIfcProperty> properties = new ArrayList<>();

  @JacksonXmlProperty(localName = "types")
  private GuiIfcTypeWrapper types;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JsonProperty(value = "layers")
  private List<GuiIfcPresentationlayer> layers = new ArrayList<>();

  @JacksonXmlElementWrapper(localName = "decomposition")
  private GuiIfcDecompositionWrapper decomposition;

  public GuiProjectIfc() {

    createHeader("");
    this.units = new GuiIfcUnitWrapper(null);
    this.types = new GuiIfcTypeWrapper(null);
    this.decomposition = new GuiIfcDecompositionWrapper(null);

  }

  public GuiProjectIfc(final ProjectIfcEdo edo) {

    createHeader(edo.getName());
    this.units = new GuiIfcUnitWrapper(edo);
    this.types = new GuiIfcTypeWrapper(edo);
    this.decomposition = new GuiIfcDecompositionWrapper(edo);

  }

  private void createHeader(final String name) {
    // com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION

    header = new HashMap<>();

    Map<String, Object> map = new HashMap<>();
    map.put("description", "ViewDefinition [CoordinationView]");
    map.put("implementation_level", "2;1");

    header.put("file_description", map);

    map = new HashMap<>();
    map.put("author", "Future Bim");
    map.put("organization", "Future Bim");
    map.put("name", name);
    map.put("time_stamp", LocalDateTime.now());
    map.put("preprocessor_version", "Autodesk Revit Architecture 2011 - 1.0");
    map.put("originating_system", "");
    map.put("authorization", "Future Bim Auth!");

    header.put("file_name", map);

    map = new HashMap<>();
    map.put("schema_identifiers", "IFC2X3");

    header.put("file_schema", map);
  }

  @JsonIgnore
  public String getName() {
    if (header.keySet().contains("file_name")) {
      final Map<String, Object> file_name = (Map<String, Object>) header.get("file_name");
      if (file_name.keySet().contains("name")) {
        return file_name.get("name").toString();

      }
    }

    return "";
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

  public Map<String, Object> toIfcMap(){
    final Map<String, Object> root = new HashMap<>();
    root.put("type", "#document");

    final Map<String, Object> map = new HashMap<>();
    List<Object> children = new ArrayList<>();

    map.put("type", "ifc");
    
    final Map<String, Object> map1 = new HashMap<>();
    map1.put("type", "header");
    map1.put("children", this.headerToIfcMap(this.header));
    
    children.add(map1);

    children.add(this.units.toIfcMap());
    /*children.add(this.layers.toIfcMap());
    children.add(this.properties.toIfcMap());
    children.add(this.types.toIfcMap());
    children.add(this.decomposition.toIfcMap());*/

    map.put("children", children);

    children = new ArrayList<>();
    children.add(map);
    root.put("children", children);
    
    return root;
  }
  
  private List<Object> headerToIfcMap(final Object oRoot){

    final List<Object> list = new ArrayList<>();
    if(oRoot instanceof  String ){

      list.add(oRoot.toString());
      return list;
    }

    if(oRoot instanceof  Map ){
      final Map<String, Object> root = (Map<String, Object>)oRoot;
      
      for(final String key: root.keySet()){
        final Object o = root.get(key);
        
        final Map<String, Object> map = new HashMap<>();
        map.put("type", key);
        map.put("children", headerToIfcMap(o));

        list.add(map);
      }

      return list;
    }

    return null;
  }
}
