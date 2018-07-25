package com.futurebim.common.model.edo.ifc;

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

/**
 * The persistent class for the project_ifc database table.
 *
 */
@JacksonXmlRootElement(localName = "ifc", namespace = "http://www.w3.org/1999/xlink")
public class ProjectIfcEdo {

  @JacksonXmlProperty(localName = "header")
  private Map<String, Object> header;

  @JacksonXmlProperty(localName = "units")
  private IfcUnitWrapperEdo units;

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  @JsonProperty(value = "properties")
  private List<IfcPropertyEdo> properties = new ArrayList<>();

  @JacksonXmlProperty(localName = "types")
  private IfcTypeWrapperEdo types;

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JsonProperty(value = "layers")
  private List<IfcPresentationlayerEdo> layers = new ArrayList<>();

  @JacksonXmlElementWrapper(localName = "decomposition")
  private IfcDecompositionWrapperEdo decomposition;

  @JsonIgnore
  private Long id;

  public ProjectIfcEdo() {

    createHeader("");
    this.units = new IfcUnitWrapperEdo();
    this.types = new IfcTypeWrapperEdo();
    this.decomposition = new IfcDecompositionWrapperEdo();
    this.id = 0L;

  }

  public ProjectIfcEdo(final String name) {

    createHeader(name);
    this.units = new IfcUnitWrapperEdo();
    this.types = new IfcTypeWrapperEdo();
    this.decomposition = new IfcDecompositionWrapperEdo();
    this.id = 0L;
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

  public IfcUnitWrapperEdo getUnits() {
    return units;
  }

  public void setUnits(final IfcUnitWrapperEdo units) {
    this.units = units;
  }

  public List<IfcPropertyEdo> getProperties() {
    return properties;
  }

  public void setProperties(final List<IfcPropertyEdo> properties) {
    this.properties = properties;
  }

  public void addProperty(final IfcPropertyEdo property) {
    this.properties.add(property);
  }

  public IfcTypeWrapperEdo getTypes() {
    return types;
  }

  public void setTypes(final IfcTypeWrapperEdo types) {
    this.types = types;
  }

  public List<IfcPresentationlayerEdo> getLayers() {
    return layers;
  }

  public void setLayers(final List<IfcPresentationlayerEdo> layers) {
    this.layers = layers;
  }

  public void addLayer(final IfcPresentationlayerEdo layer) {
    this.layers.add(layer);
  }

  public IfcDecompositionWrapperEdo getDecomposition() {
    return decomposition;
  }

  public void setDecomposition(final IfcDecompositionWrapperEdo decomposition) {
    this.decomposition = decomposition;
  }

  public Map<String, Object> getHeader() {
    return header;
  }

  public void addConversionUnit(final IfcConversionBasedUnitEdo conversion) {
    this.units.addConversionUnit(conversion);
  }

  public void addUnit(final IfcUnitEdo unit) {
    this.units.addUnit(unit);
  }

  public void addFurnitureType(final IfcFurnituretypeEdo furnitureType) {
    this.types.addFurnitureType(furnitureType);
  }

  public void addDoorType(final IfcDoorstyleEdo doorType) {
    this.types.addDoorType(doorType);
  }

  public void addWindowType(final IfcWindowstyleEdo windowType) {
    this.types.addWindowType(windowType);
  }

  public void addProject(final IfcProjectEdo project) {
    this.decomposition.addProject(project);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

}
