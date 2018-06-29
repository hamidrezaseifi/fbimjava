package com.futurebim.core.model.ifc.render;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.ProjectIfc;

/**
 * The persistent class for the project_ifc database table.
 *
 */
@JacksonXmlRootElement(localName = "ifc", namespace = "http://www.w3.org/1999/xlink")
public class ProjectIfcRender {

  @JsonIgnore
  @JacksonXmlProperty(localName = "header")
  private Map<String, Object> header = new HashMap<>();

  @JsonIgnore
  @JacksonXmlProperty(localName = "units")
  private IfcUnitWrapperRender units;

  @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  private List<IfcPropertyRender> properties;

  @JsonIgnore
  // @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "types")
  private IfcTypeWrapperRender types;

  @JsonIgnore
  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(localName = "layers")
  private List<IfcPresentationlayerRender> layers;

  // @JsonIgnore
  // @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "decomposition")
  private DecompositionWrapperRender decomposition;

  /*
   * private String id; private String ifcName; private List<IfcDoorstyle> ifcDoorstyles; private List<IfcFurnituretype> ifcFurnituretypes;
   * private List<IfcPresentationlayer> ifcPresentationlayers; private List<IfcProject> ifcProjects; private List<IfcWindowstyle>
   * ifcWindowstyles; private List<IfcConversionBasedUnit> ifcConversionBasedUnit;
   */

  public ProjectIfcRender() {

  }

  public ProjectIfcRender(final ProjectIfc model) {
    createHeader(model);

    units = new IfcUnitWrapperRender(model);

    properties = new ArrayList<>();
    properties.addAll(IfcPropertyRender.fromModelList(model.getIfcProperties()));
  }

  private void createHeader(final ProjectIfc model) {
    // com.fasterxml.jackson.dataformat.xml.ser.ToXmlGenerator.Feature.WRITE_XML_DECLARATION
    Map<String, Object> map = new HashMap<>();
    map.put("description", "ViewDefinition [CoordinationView]");
    map.put("implementation_level", "2;1");

    header.put("file_description", map);

    map = new HashMap<>();
    map.put("author", "Future Bim");
    map.put("organization", "Future Bim");
    map.put("name", model.getIfcName());
    map.put("time_stamp", LocalDateTime.now());
    map.put("preprocessor_version", "Autodesk Revit Architecture 2011 - 1.0");
    map.put("originating_system", "");
    map.put("authorization", "Future Bim Auth!");

    header.put("file_name", map);

    map = new HashMap<>();
    map.put("schema_identifiers", "IFC2X3");

    header.put("file_schema", map);
  }

  public Map<String, Object> getHeader() {
    return header;
  }

  public void setHeader(final Map<String, Object> header) {
    this.header = header;
  }

  public IfcUnitWrapperRender getUnits() {
    return units;
  }

  public List<IfcPropertyRender> getProperties() {
    return properties;
  }

  public void setUnits(final IfcUnitWrapperRender units) {
    this.units = units;
  }

  public void setProperties(final List<IfcPropertyRender> properties) {
    this.properties = properties;
  }

  public IfcTypeWrapperRender getTypes() {
    return types;
  }

  public void setTypes(final IfcTypeWrapperRender types) {
    this.types = types;
  }

  public List<IfcPresentationlayerRender> getLayers() {
    return layers;
  }

  public void setLayers(final List<IfcPresentationlayerRender> layers) {
    this.layers = layers;
  }

  public DecompositionWrapperRender getDecomposition() {
    return decomposition;
  }

  public void setDecomposition(final DecompositionWrapperRender decomposition) {
    this.decomposition = decomposition;
  }

}
