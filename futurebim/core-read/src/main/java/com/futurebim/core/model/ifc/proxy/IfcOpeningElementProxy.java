package com.futurebim.core.model.ifc.proxy;

import java.util.ArrayList;
import java.util.List;

public class IfcOpeningElementProxy {

  private String id;

  private String name;

  private String objectType;

  private String objectPlacement;

  private String tag;

  private List<IfcPropertySetProxy> propertySetList = new ArrayList<>();

  private List<IfcPresentationLayerAssignmentSetProxy> presentationLayerAssignmentList = new ArrayList<>();

  public String getId() {
    return id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public String getName() {
    return name != null ? name : "";
  }

  public void setName(final String name) {
    this.name = name;
  }

  public String getObjectType() {
    return objectType;
  }

  public void setObjectType(final String objectType) {
    this.objectType = objectType;
  }

  public String getObjectPlacement() {
    return objectPlacement;
  }

  public void setObjectPlacement(final String objectPlacement) {
    this.objectPlacement = objectPlacement;
  }

  public String getTag() {
    return tag;
  }

  public void setTag(final String tag) {
    this.tag = tag;
  }

  public List<IfcPropertySetProxy> getPropertySetList() {
    return propertySetList;
  }

  public void setPropertySetList(final List<IfcPropertySetProxy> propertySetList) {
    this.propertySetList = propertySetList;
  }

  public void addPropertySetList(final IfcPropertySetProxy propertySet) {
    this.propertySetList.add(propertySet);
  }

  public List<IfcPresentationLayerAssignmentSetProxy> getPresentationLayerAssignmentList() {
    return presentationLayerAssignmentList;
  }

  public void setPresentationLayerAssignmentList(final List<IfcPresentationLayerAssignmentSetProxy> presentationLayerAssignmentList) {
    this.presentationLayerAssignmentList = presentationLayerAssignmentList;
  }

  public void addPresentationLayerAssignmentList(final IfcPresentationLayerAssignmentSetProxy presentationLayerAssignment) {
    this.presentationLayerAssignmentList.add(presentationLayerAssignment);
  }

}
