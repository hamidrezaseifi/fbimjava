package com.futurebim.core.model.ifc.render;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import com.futurebim.core.model.ifc.IfcDoorstyle;
import com.futurebim.core.model.ifc.IfcFurnituretype;
import com.futurebim.core.model.ifc.IfcWindowstyle;

/**
 * The persistent class for the ifc_units database table.
 *
 */
@JacksonXmlRootElement(localName = "units")
public class IfcTypeWrapperRender {

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcFurnitureType")
  private final List<IfcFurnituretypeRender> furnitureTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcDoorStyle")
  private final List<IfcDoorstyleRender> doorTypes = new ArrayList<>();

  @JacksonXmlElementWrapper(useWrapping = false)
  @JacksonXmlProperty(localName = "IfcWindowStyle")// IfcWindowStyle
  private final List<IfcWindowstyleRender> windowTypes = new ArrayList<>();

  public List<IfcFurnituretype> toFurnitureTypeModel(final String modelId) {

    final List<IfcFurnituretype> list = new ArrayList<>();
    for (final IfcFurnituretypeRender type : furnitureTypes) {

      list.add(type.toModel(modelId));
    }
    return list;
  }

  public List<IfcDoorstyle> toDoorTypeModel(final String modelId) {

    final List<IfcDoorstyle> list = new ArrayList<>();
    for (final IfcDoorstyleRender type : doorTypes) {

      list.add(type.toModel(modelId));
    }
    return list;
  }

  public List<IfcWindowstyle> toWindowTypeModel(final String modelId) {

    final List<IfcWindowstyle> list = new ArrayList<>();
    for (final IfcWindowstyleRender type : windowTypes) {

      list.add(type.toModel(modelId));
    }
    return list;
  }

}
