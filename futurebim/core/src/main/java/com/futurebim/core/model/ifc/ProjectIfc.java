package com.futurebim.core.model.ifc;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.futurebim.common.model.edo.ifc.ProjectIfcEdo;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the project_ifc database table.
 *
 */
@Entity
@Table(name = "project_ifc")
public class ProjectIfc extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "filename")
  private String filename;

  private String comments;

  private LocalDateTime created; // = LocalDateTime.valueOf(LocalDateTime.now());

  @Column(name = "ifc_name", unique = true, nullable = false)
  private String ifcName;

  @Column(name = "project_id")
  private Long projectId;

  private short status = 1;

  private LocalDateTime updated;

  private int version = 1;

  // bi-directional many-to-one association to IfcDoorstyle
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcDoorstyle> ifcDoorstyles = new ArrayList<>();

  // bi-directional many-to-one association to IfcFurnituretype
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcFurnituretype> ifcFurnituretypes = new ArrayList<>();

  // bi-directional many-to-one association to IfcPresentationlayer
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcPresentationlayer> ifcPresentationlayers = new ArrayList<>();

  // bi-directional many-to-one association to IfcProject
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcProject> ifcProjects = new ArrayList<>();

  // bi-directional many-to-one association to IfcProperty
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcProperty> ifcProperties = new ArrayList<>();

  // bi-directional many-to-one association to IfcWindowstyle
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcWindowstyle> ifcWindowstyles = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcUnit> ifcUnits = new ArrayList<>();

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "projectIfc", cascade = CascadeType.ALL)
  private List<IfcConversionBasedUnit> ifcConversionBasedUnit = new ArrayList<>();

  @JsonIgnore
  @ManyToOne(fetch = FetchType.EAGER)
  @JoinColumn(name = "project_id", insertable = false, updatable = false)
  private Project project;

  public ProjectIfc() {
  }

  public String getFilename() {
    return filename;
  }

  public void setFilename(final String filename) {
    this.filename = filename;
  }

  public LocalDateTime getCreated() {
    return this.created;
  }

  public void setCreated(final LocalDateTime created) {
    this.created = created;
  }

  public String getIfcName() {
    return this.ifcName;
  }

  public void setIfcName(final String ifcName) {
    this.ifcName = ifcName;
  }

  public Long getProjectId() {
    return this.projectId;
  }

  public void setProjectId(final Long projectId) {
    this.projectId = projectId;
  }

  public short getStatus() {
    return this.status;
  }

  public void setStatus(final short status) {
    this.status = status;
  }

  public LocalDateTime getUpdated() {
    return this.updated;
  }

  public void setUpdated(final LocalDateTime updated) {
    this.updated = updated;
  }

  public int getVersion() {
    return this.version;
  }

  public void setVersion(final int version) {
    this.version = version;
  }

  public List<IfcDoorstyle> getIfcDoorstyles() {
    return this.ifcDoorstyles;
  }

  public void setIfcDoorstyles(final List<IfcDoorstyle> ifcDoorstyles) {
    this.ifcDoorstyles = ifcDoorstyles;
  }

  public IfcDoorstyle addIfcDoorstyle(final IfcDoorstyle ifcDoorstyle) {
    getIfcDoorstyles().add(ifcDoorstyle);
    ifcDoorstyle.setProjectIfc(this);

    return ifcDoorstyle;
  }

  public IfcDoorstyle removeIfcDoorstyle(final IfcDoorstyle ifcDoorstyle) {
    getIfcDoorstyles().remove(ifcDoorstyle);

    return ifcDoorstyle;
  }

  public List<IfcFurnituretype> getIfcFurnituretypes() {
    return this.ifcFurnituretypes;
  }

  public void setIfcFurnituretypes(final List<IfcFurnituretype> ifcFurnituretypes) {
    this.ifcFurnituretypes = ifcFurnituretypes;
  }

  public IfcFurnituretype addIfcFurnituretype(final IfcFurnituretype ifcFurnituretype) {
    getIfcFurnituretypes().add(ifcFurnituretype);
    ifcFurnituretype.setProjectIfc(this);
    ifcFurnituretype.setProjectIfc(this);

    return ifcFurnituretype;
  }

  public IfcFurnituretype removeIfcFurnituretype(final IfcFurnituretype ifcFurnituretype) {
    getIfcFurnituretypes().remove(ifcFurnituretype);
    ifcFurnituretype.setProjectIfc(null);

    return ifcFurnituretype;
  }

  public List<IfcPresentationlayer> getIfcPresentationlayers() {
    return this.ifcPresentationlayers;
  }

  public void setIfcPresentationlayers(final List<IfcPresentationlayer> ifcPresentationlayers) {
    this.ifcPresentationlayers = ifcPresentationlayers;
  }

  public IfcPresentationlayer addIfcPresentationlayer(final IfcPresentationlayer ifcPresentationlayer) {
    getIfcPresentationlayers().add(ifcPresentationlayer);
    ifcPresentationlayer.setProjectIfc(this);

    return ifcPresentationlayer;
  }

  public IfcPresentationlayer removeIfcPresentationlayer(final IfcPresentationlayer ifcPresentationlayer) {
    getIfcPresentationlayers().remove(ifcPresentationlayer);

    return ifcPresentationlayer;
  }

  public List<IfcProject> getIfcProjects() {
    return this.ifcProjects;
  }

  public void setIfcProjects(final List<IfcProject> ifcProjects) {
    this.ifcProjects = ifcProjects;
  }

  public IfcProject addIfcProject(final IfcProject ifcProject) {
    getIfcProjects().add(ifcProject);
    ifcProject.setProjectIfc(this);

    return ifcProject;
  }

  public IfcProject removeIfcProject(final IfcProject ifcProject) {
    getIfcProjects().remove(ifcProject);

    return ifcProject;
  }

  public List<IfcProperty> getIfcProperties() {
    return this.ifcProperties;
  }

  public void setIfcProperties(final List<IfcProperty> ifcProperties) {
    this.ifcProperties = ifcProperties;
  }

  public void addIfcProperty(final IfcProperty ifcProperty) {
    this.ifcProperties.add(ifcProperty);
    ifcProperty.setProjectIfc(this);

  }

  public List<IfcWindowstyle> getIfcWindowstyles() {
    return this.ifcWindowstyles;
  }

  public void setIfcWindowstyles(final List<IfcWindowstyle> ifcWindowstyles) {
    this.ifcWindowstyles = ifcWindowstyles;
  }

  public IfcWindowstyle addIfcWindowstyle(final IfcWindowstyle ifcWindowstyle) {
    getIfcWindowstyles().add(ifcWindowstyle);
    ifcWindowstyle.setProjectIfc(this);

    return ifcWindowstyle;
  }

  public IfcWindowstyle removeIfcWindowstyle(final IfcWindowstyle ifcWindowstyle) {
    getIfcWindowstyles().remove(ifcWindowstyle);

    return ifcWindowstyle;
  }

  public Project getProject() {
    return project;
  }

  public void setProject(final Project project) {
    this.project = project;
  }

  public List<IfcUnit> getIfcUnits() {
    return ifcUnits;
  }

  public void setIfcUnits(final List<IfcUnit> ifcUnits) {
    this.ifcUnits = ifcUnits;
  }

  public void addIfcUnits(final IfcUnit ifcUnit) {
    this.ifcUnits.add(ifcUnit);
    ifcUnit.setProjectIfc(this);
  }

  public List<IfcConversionBasedUnit> getIfcConversionBasedUnit() {
    return ifcConversionBasedUnit;
  }

  public void setIfcConversionBasedUnit(final List<IfcConversionBasedUnit> ifcConversionBasedUnit) {
    this.ifcConversionBasedUnit = ifcConversionBasedUnit;
  }

  public void addIfcConversionBasedUnit(final IfcConversionBasedUnit ifcConversionBasedUnit) {
    this.ifcConversionBasedUnit.add(ifcConversionBasedUnit);
    ifcConversionBasedUnit.setProjectIfc(this);
  }

  public Long getId() {
    return id;
  }

  public void setId(final Long id) {
    this.id = id;
  }

  public String getComments() {
    return comments;
  }

  public void setComments(final String comments) {
    this.comments = comments;
  }

  public ProjectIfcEdo toEdo() {

    final ProjectIfcEdo edo = new ProjectIfcEdo(getIfcName());

    for (final IfcPresentationlayer layer : ifcPresentationlayers) {
      edo.addLayer(layer.toEdo());
    }

    for (final IfcProperty property : ifcProperties) {
      edo.addProperty(property.toEdo());
    }

    for (final IfcUnit unit : ifcUnits) {
      edo.addUnit(unit.toEdo());
    }

    for (final IfcConversionBasedUnit unit : ifcConversionBasedUnit) {
      edo.addConversionUnit(unit.toEdo());
    }

    for (final IfcDoorstyle item : ifcDoorstyles) {
      edo.addDoorType(item.toEdo());
    }

    for (final IfcFurnituretype item : ifcFurnituretypes) {
      edo.addFurnitureType(item.toEdo());
    }

    for (final IfcWindowstyle item : ifcWindowstyles) {
      edo.addWindowType(item.toEdo());
    }

    for (final IfcProject item : ifcProjects) {
      edo.addProject(item.toEdo());
    }

    return edo;
  }
}
