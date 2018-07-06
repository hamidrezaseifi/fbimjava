package com.futurebim.core.model.ifc.render;

import java.time.LocalDateTime;
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

  private Map<String, Object> header = new HashMap<>();

  private IfcUnitWrapperRender units;

  private List<IfcPropertyRender> properties;

  private IfcTypeWrapperRender types;

  private List<IfcPresentationlayerRender> layers;

  private DecompositionWrapperRender decomposition;

  public ProjectIfcRender() {

  }

  public ProjectIfcRender(final ProjectIfc model) {
    createHeader(model);

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

  public ProjectIfc toModel() {
    final ProjectIfc model = new ProjectIfc();

    model.setIfcName(getName());
    model.setFilename("Duplex_A_20110907_optimized");

    model.setIfcUnits(units.toUnitModel(model));
    model.setIfcConversionBasedUnit(units.toConversionBasedUnitModel(model.getId()));

    for (final IfcPropertyRender prop : properties) {
      model.addIfcProperty(prop.toModel(model));
    }

    model.setIfcDoorstyles(types.toDoorTypeModel(model.getId()));
    model.setIfcFurnituretypes(types.toFurnitureTypeModel(model.getId()));
    model.setIfcWindowstyles(types.toWindowTypeModel(model));

    for (final IfcPresentationlayerRender layer : layers) {
      model.addIfcPresentationlayer(layer.toModel(model.getId()));
    }

    model.setIfcProjects(decomposition.toModel(model));

    return model;
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

  @JacksonXmlProperty(localName = "header")
  public Map<String, Object> getHeader() {
    return header;
  }

  public void setHeader(final Map<String, Object> header) {
    this.header = header;
  }

  @JacksonXmlProperty(localName = "units")
  public IfcUnitWrapperRender getUnits() {
    return units;
  }

  @JacksonXmlProperty(localName = "IfcPropertySet")
  @JacksonXmlElementWrapper(localName = "properties")
  public List<IfcPropertyRender> getProperties() {
    return properties;
  }

  public void setUnits(final IfcUnitWrapperRender units) {
    this.units = units;
  }

  public void setProperties(final List<IfcPropertyRender> properties) {
    this.properties = properties;
  }

  @JacksonXmlProperty(localName = "types")
  public IfcTypeWrapperRender getTypes() {
    return types;
  }

  public void setTypes(final IfcTypeWrapperRender types) {
    this.types = types;
  }

  @JacksonXmlProperty(localName = "IfcPresentationLayerAssignment")
  @JacksonXmlElementWrapper(localName = "layers")
  public List<IfcPresentationlayerRender> getLayers() {
    return layers;
  }

  public void setLayers(final List<IfcPresentationlayerRender> layers) {
    this.layers = layers;
  }

  @JacksonXmlElementWrapper(localName = "decomposition")
  public DecompositionWrapperRender getDecomposition() {
    return decomposition;
  }

  public void setDecomposition(final DecompositionWrapperRender decomposition) {
    this.decomposition = decomposition;
  }

}
