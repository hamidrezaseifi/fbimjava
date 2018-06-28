package com.futurebim.core.model.ifc;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the ifc_properties database table.
 *
 */
@Entity
@Table(name = "ifc_properties")
@NamedQuery(name = "IfcProperty.findAll", query = "SELECT i FROM IfcProperty i")
public class IfcProperty extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  private String id;

  private Timestamp created;

  @Column(name = "property_name")
  private String propertyName;

  private short status;

  private Timestamp updated;

  private int version;

  // bi-directional many-to-one association to IfcBuildingProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingProperty> ifcBuildingProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyBeamProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyCoveringProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyDoorProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyProperty> ifcBuildingStoreyProperties;

  // bi-directional many-to-one association to IfcBuildingStoreySlabProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties;

  // bi-directional many-to-one association to IfcBuildingStoreySpaceProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyStairFlightProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyStairMemberProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyStairProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyStairRailingProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyStairRailingProperty> ifcBuildingStoreyStairRailingProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyWallProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties;

  // bi-directional many-to-one association to IfcBuildingStoreyWindowProperty
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties;

  // bi-directional many-to-one association to ProjectIfc
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "ifc_id")
  private ProjectIfc projectIfc;

  // bi-directional many-to-one association to IfcPropertiesValue
  @OneToMany(mappedBy = "ifcProperty")
  private List<IfcPropertiesValue> ifcPropertiesValues;

  public IfcProperty() {
  }

  public String getId() {
    return this.id;
  }

  public void setId(final String id) {
    this.id = id;
  }

  public Timestamp getCreated() {
    return this.created;
  }

  public void setCreated(final Timestamp created) {
    this.created = created;
  }

  public String getPropertyName() {
    return this.propertyName;
  }

  public void setPropertyName(final String propertyName) {
    this.propertyName = propertyName;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public Timestamp getUpdated() {
    return this.updated;
  }

  public void setUpdated(final Timestamp updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public List<IfcBuildingProperty> getIfcBuildingProperties() {
    return this.ifcBuildingProperties;
  }

  public void setIfcBuildingProperties(final List<IfcBuildingProperty> ifcBuildingProperties) {
    this.ifcBuildingProperties = ifcBuildingProperties;
  }

  public IfcBuildingProperty addIfcBuildingProperty(final IfcBuildingProperty ifcBuildingProperty) {
    getIfcBuildingProperties().add(ifcBuildingProperty);
    ifcBuildingProperty.setIfcProperty(this);

    return ifcBuildingProperty;
  }

  public IfcBuildingProperty removeIfcBuildingProperty(final IfcBuildingProperty ifcBuildingProperty) {
    getIfcBuildingProperties().remove(ifcBuildingProperty);
    ifcBuildingProperty.setIfcProperty(null);

    return ifcBuildingProperty;
  }

  public List<IfcBuildingStoreyBeamProperty> getIfcBuildingStoreyBeamProperties() {
    return this.ifcBuildingStoreyBeamProperties;
  }

  public void setIfcBuildingStoreyBeamProperties(final List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties) {
    this.ifcBuildingStoreyBeamProperties = ifcBuildingStoreyBeamProperties;
  }

  public IfcBuildingStoreyBeamProperty addIfcBuildingStoreyBeamProperty(final IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
    getIfcBuildingStoreyBeamProperties().add(ifcBuildingStoreyBeamProperty);
    ifcBuildingStoreyBeamProperty.setIfcProperty(this);

    return ifcBuildingStoreyBeamProperty;
  }

  public IfcBuildingStoreyBeamProperty
         removeIfcBuildingStoreyBeamProperty(final IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
    getIfcBuildingStoreyBeamProperties().remove(ifcBuildingStoreyBeamProperty);
    ifcBuildingStoreyBeamProperty.setIfcProperty(null);

    return ifcBuildingStoreyBeamProperty;
  }

  public List<IfcBuildingStoreyCoveringProperty> getIfcBuildingStoreyCoveringProperties() {
    return this.ifcBuildingStoreyCoveringProperties;
  }

  public void setIfcBuildingStoreyCoveringProperties(final List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties) {
    this.ifcBuildingStoreyCoveringProperties = ifcBuildingStoreyCoveringProperties;
  }

  public IfcBuildingStoreyCoveringProperty
         addIfcBuildingStoreyCoveringProperty(final IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
    getIfcBuildingStoreyCoveringProperties().add(ifcBuildingStoreyCoveringProperty);
    ifcBuildingStoreyCoveringProperty.setIfcProperty(this);

    return ifcBuildingStoreyCoveringProperty;
  }

  public IfcBuildingStoreyCoveringProperty
         removeIfcBuildingStoreyCoveringProperty(final IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
    getIfcBuildingStoreyCoveringProperties().remove(ifcBuildingStoreyCoveringProperty);
    ifcBuildingStoreyCoveringProperty.setIfcProperty(null);

    return ifcBuildingStoreyCoveringProperty;
  }

  public List<IfcBuildingStoreyDoorProperty> getIfcBuildingStoreyDoorProperties() {
    return this.ifcBuildingStoreyDoorProperties;
  }

  public void setIfcBuildingStoreyDoorProperties(final List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties) {
    this.ifcBuildingStoreyDoorProperties = ifcBuildingStoreyDoorProperties;
  }

  public IfcBuildingStoreyDoorProperty addIfcBuildingStoreyDoorProperty(final IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
    getIfcBuildingStoreyDoorProperties().add(ifcBuildingStoreyDoorProperty);
    ifcBuildingStoreyDoorProperty.setIfcProperty(this);

    return ifcBuildingStoreyDoorProperty;
  }

  public IfcBuildingStoreyDoorProperty
         removeIfcBuildingStoreyDoorProperty(final IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
    getIfcBuildingStoreyDoorProperties().remove(ifcBuildingStoreyDoorProperty);
    ifcBuildingStoreyDoorProperty.setIfcProperty(null);

    return ifcBuildingStoreyDoorProperty;
  }

  public List<IfcBuildingStoreyProperty> getIfcBuildingStoreyProperties() {
    return this.ifcBuildingStoreyProperties;
  }

  public void setIfcBuildingStoreyProperties(final List<IfcBuildingStoreyProperty> ifcBuildingStoreyProperties) {
    this.ifcBuildingStoreyProperties = ifcBuildingStoreyProperties;
  }

  public IfcBuildingStoreyProperty addIfcBuildingStoreyProperty(final IfcBuildingStoreyProperty ifcBuildingStoreyProperty) {
    getIfcBuildingStoreyProperties().add(ifcBuildingStoreyProperty);
    ifcBuildingStoreyProperty.setIfcProperty(this);

    return ifcBuildingStoreyProperty;
  }

  public IfcBuildingStoreyProperty removeIfcBuildingStoreyProperty(final IfcBuildingStoreyProperty ifcBuildingStoreyProperty) {
    getIfcBuildingStoreyProperties().remove(ifcBuildingStoreyProperty);
    ifcBuildingStoreyProperty.setIfcProperty(null);

    return ifcBuildingStoreyProperty;
  }

  public List<IfcBuildingStoreySlabProperty> getIfcBuildingStoreySlabProperties() {
    return this.ifcBuildingStoreySlabProperties;
  }

  public void setIfcBuildingStoreySlabProperties(final List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties) {
    this.ifcBuildingStoreySlabProperties = ifcBuildingStoreySlabProperties;
  }

  public IfcBuildingStoreySlabProperty addIfcBuildingStoreySlabProperty(final IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
    getIfcBuildingStoreySlabProperties().add(ifcBuildingStoreySlabProperty);
    ifcBuildingStoreySlabProperty.setIfcProperty(this);

    return ifcBuildingStoreySlabProperty;
  }

  public IfcBuildingStoreySlabProperty
         removeIfcBuildingStoreySlabProperty(final IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
    getIfcBuildingStoreySlabProperties().remove(ifcBuildingStoreySlabProperty);
    ifcBuildingStoreySlabProperty.setIfcProperty(null);

    return ifcBuildingStoreySlabProperty;
  }

  public List<IfcBuildingStoreySpaceFurnishingelementProperty> getIfcBuildingStoreySpaceFurnishingelementProperties() {
    return this.ifcBuildingStoreySpaceFurnishingelementProperties;
  }

  public void
         setIfcBuildingStoreySpaceFurnishingelementProperties(final List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties) {
    this.ifcBuildingStoreySpaceFurnishingelementProperties = ifcBuildingStoreySpaceFurnishingelementProperties;
  }

  public IfcBuildingStoreySpaceFurnishingelementProperty
         addIfcBuildingStoreySpaceFurnishingelementProperty(final IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
    getIfcBuildingStoreySpaceFurnishingelementProperties().add(ifcBuildingStoreySpaceFurnishingelementProperty);
    ifcBuildingStoreySpaceFurnishingelementProperty.setIfcProperty(this);

    return ifcBuildingStoreySpaceFurnishingelementProperty;
  }

  public IfcBuildingStoreySpaceFurnishingelementProperty
         removeIfcBuildingStoreySpaceFurnishingelementProperty(final IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
    getIfcBuildingStoreySpaceFurnishingelementProperties().remove(ifcBuildingStoreySpaceFurnishingelementProperty);
    ifcBuildingStoreySpaceFurnishingelementProperty.setIfcProperty(null);

    return ifcBuildingStoreySpaceFurnishingelementProperty;
  }

  public List<IfcBuildingStoreySpaceProperty> getIfcBuildingStoreySpaceProperties() {
    return this.ifcBuildingStoreySpaceProperties;
  }

  public void setIfcBuildingStoreySpaceProperties(final List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties) {
    this.ifcBuildingStoreySpaceProperties = ifcBuildingStoreySpaceProperties;
  }

  public IfcBuildingStoreySpaceProperty
         addIfcBuildingStoreySpaceProperty(final IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
    getIfcBuildingStoreySpaceProperties().add(ifcBuildingStoreySpaceProperty);
    ifcBuildingStoreySpaceProperty.setIfcProperty(this);

    return ifcBuildingStoreySpaceProperty;
  }

  public IfcBuildingStoreySpaceProperty
         removeIfcBuildingStoreySpaceProperty(final IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
    getIfcBuildingStoreySpaceProperties().remove(ifcBuildingStoreySpaceProperty);
    ifcBuildingStoreySpaceProperty.setIfcProperty(null);

    return ifcBuildingStoreySpaceProperty;
  }

  public List<IfcBuildingStoreyStairFlightProperty> getIfcBuildingStoreyStairFlightProperties() {
    return this.ifcBuildingStoreyStairFlightProperties;
  }

  public void
         setIfcBuildingStoreyStairFlightProperties(final List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties) {
    this.ifcBuildingStoreyStairFlightProperties = ifcBuildingStoreyStairFlightProperties;
  }

  public IfcBuildingStoreyStairFlightProperty
         addIfcBuildingStoreyStairFlightProperty(final IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
    getIfcBuildingStoreyStairFlightProperties().add(ifcBuildingStoreyStairFlightProperty);
    ifcBuildingStoreyStairFlightProperty.setIfcProperty(this);

    return ifcBuildingStoreyStairFlightProperty;
  }

  public IfcBuildingStoreyStairFlightProperty
         removeIfcBuildingStoreyStairFlightProperty(final IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
    getIfcBuildingStoreyStairFlightProperties().remove(ifcBuildingStoreyStairFlightProperty);
    ifcBuildingStoreyStairFlightProperty.setIfcProperty(null);

    return ifcBuildingStoreyStairFlightProperty;
  }

  public List<IfcBuildingStoreyStairMemberProperty> getIfcBuildingStoreyStairMemberProperties() {
    return this.ifcBuildingStoreyStairMemberProperties;
  }

  public void
         setIfcBuildingStoreyStairMemberProperties(final List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties) {
    this.ifcBuildingStoreyStairMemberProperties = ifcBuildingStoreyStairMemberProperties;
  }

  public IfcBuildingStoreyStairMemberProperty
         addIfcBuildingStoreyStairMemberProperty(final IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
    getIfcBuildingStoreyStairMemberProperties().add(ifcBuildingStoreyStairMemberProperty);
    ifcBuildingStoreyStairMemberProperty.setIfcProperty(this);

    return ifcBuildingStoreyStairMemberProperty;
  }

  public IfcBuildingStoreyStairMemberProperty
         removeIfcBuildingStoreyStairMemberProperty(final IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
    getIfcBuildingStoreyStairMemberProperties().remove(ifcBuildingStoreyStairMemberProperty);
    ifcBuildingStoreyStairMemberProperty.setIfcProperty(null);

    return ifcBuildingStoreyStairMemberProperty;
  }

  public List<IfcBuildingStoreyStairProperty> getIfcBuildingStoreyStairProperties() {
    return this.ifcBuildingStoreyStairProperties;
  }

  public void setIfcBuildingStoreyStairProperties(final List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties) {
    this.ifcBuildingStoreyStairProperties = ifcBuildingStoreyStairProperties;
  }

  public IfcBuildingStoreyStairProperty
         addIfcBuildingStoreyStairProperty(final IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
    getIfcBuildingStoreyStairProperties().add(ifcBuildingStoreyStairProperty);
    ifcBuildingStoreyStairProperty.setIfcProperty(this);

    return ifcBuildingStoreyStairProperty;
  }

  public IfcBuildingStoreyStairProperty
         removeIfcBuildingStoreyStairProperty(final IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
    getIfcBuildingStoreyStairProperties().remove(ifcBuildingStoreyStairProperty);
    ifcBuildingStoreyStairProperty.setIfcProperty(null);

    return ifcBuildingStoreyStairProperty;
  }

  public List<IfcBuildingStoreyStairRailingProperty> getIfcBuildingStoreyStairRailingProperties() {
    return this.ifcBuildingStoreyStairRailingProperties;
  }

  public void
         setIfcBuildingStoreyStairRailingProperties(final List<IfcBuildingStoreyStairRailingProperty> ifcBuildingStoreyStairRailingProperties) {
    this.ifcBuildingStoreyStairRailingProperties = ifcBuildingStoreyStairRailingProperties;
  }

  public IfcBuildingStoreyStairRailingProperty
         addIfcBuildingStoreyStairRailingProperty(final IfcBuildingStoreyStairRailingProperty ifcBuildingStoreyStairRailingProperty) {
    getIfcBuildingStoreyStairRailingProperties().add(ifcBuildingStoreyStairRailingProperty);
    ifcBuildingStoreyStairRailingProperty.setIfcProperty(this);

    return ifcBuildingStoreyStairRailingProperty;
  }

  public IfcBuildingStoreyStairRailingProperty
         removeIfcBuildingStoreyStairRailingProperty(final IfcBuildingStoreyStairRailingProperty ifcBuildingStoreyStairRailingProperty) {
    getIfcBuildingStoreyStairRailingProperties().remove(ifcBuildingStoreyStairRailingProperty);
    ifcBuildingStoreyStairRailingProperty.setIfcProperty(null);

    return ifcBuildingStoreyStairRailingProperty;
  }

  public List<IfcBuildingStoreyWallProperty> getIfcBuildingStoreyWallProperties() {
    return this.ifcBuildingStoreyWallProperties;
  }

  public void setIfcBuildingStoreyWallProperties(final List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties) {
    this.ifcBuildingStoreyWallProperties = ifcBuildingStoreyWallProperties;
  }

  public IfcBuildingStoreyWallProperty addIfcBuildingStoreyWallProperty(final IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
    getIfcBuildingStoreyWallProperties().add(ifcBuildingStoreyWallProperty);
    ifcBuildingStoreyWallProperty.setIfcProperty(this);

    return ifcBuildingStoreyWallProperty;
  }

  public IfcBuildingStoreyWallProperty
         removeIfcBuildingStoreyWallProperty(final IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
    getIfcBuildingStoreyWallProperties().remove(ifcBuildingStoreyWallProperty);
    ifcBuildingStoreyWallProperty.setIfcProperty(null);

    return ifcBuildingStoreyWallProperty;
  }

  public List<IfcBuildingStoreyWindowProperty> getIfcBuildingStoreyWindowProperties() {
    return this.ifcBuildingStoreyWindowProperties;
  }

  public void setIfcBuildingStoreyWindowProperties(final List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties) {
    this.ifcBuildingStoreyWindowProperties = ifcBuildingStoreyWindowProperties;
  }

  public IfcBuildingStoreyWindowProperty
         addIfcBuildingStoreyWindowProperty(final IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
    getIfcBuildingStoreyWindowProperties().add(ifcBuildingStoreyWindowProperty);
    ifcBuildingStoreyWindowProperty.setIfcProperty(this);

    return ifcBuildingStoreyWindowProperty;
  }

  public IfcBuildingStoreyWindowProperty
         removeIfcBuildingStoreyWindowProperty(final IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
    getIfcBuildingStoreyWindowProperties().remove(ifcBuildingStoreyWindowProperty);
    ifcBuildingStoreyWindowProperty.setIfcProperty(null);

    return ifcBuildingStoreyWindowProperty;
  }

  public ProjectIfc getProjectIfc() {
    return this.projectIfc;
  }

  public void setProjectIfc(final ProjectIfc projectIfc) {
    this.projectIfc = projectIfc;
  }

  public List<IfcPropertiesValue> getIfcPropertiesValues() {
    return this.ifcPropertiesValues;
  }

  public void setIfcPropertiesValues(final List<IfcPropertiesValue> ifcPropertiesValues) {
    this.ifcPropertiesValues = ifcPropertiesValues;
  }

  public IfcPropertiesValue addIfcPropertiesValue(final IfcPropertiesValue ifcPropertiesValue) {
    getIfcPropertiesValues().add(ifcPropertiesValue);
    ifcPropertiesValue.setIfcProperty(this);

    return ifcPropertiesValue;
  }

  public IfcPropertiesValue removeIfcPropertiesValue(final IfcPropertiesValue ifcPropertiesValue) {
    getIfcPropertiesValues().remove(ifcPropertiesValue);
    ifcPropertiesValue.setIfcProperty(null);

    return ifcPropertiesValue;
  }

}
