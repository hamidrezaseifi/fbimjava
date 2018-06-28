package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_properties database table.
 * 
 */
@Entity
@Table(name="ifc_properties")
@NamedQuery(name="IfcProperty.findAll", query="SELECT i FROM IfcProperty i")
public class IfcProperty implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="property_name")
	private String propertyName;

	private short status;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingProperty> ifcBuildingProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyBeamProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyCoveringProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyDoorProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyProperty> ifcBuildingStoreyProperties;

	//bi-directional many-to-one association to IfcBuildingStoreySlabProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelementProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyStairFlightProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyStairMemberProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyStairProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyStairRailingProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyStairRailingProperty> ifcBuildingStoreyStairRailingProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyWallProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyWindowProperty
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties;

	//bi-directional many-to-one association to ProjectIfc
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="ifc_id")
	private ProjectIfc projectIfc;

	//bi-directional many-to-one association to IfcPropertiesValue
	@OneToMany(mappedBy="ifcProperty")
	private List<IfcPropertiesValue> ifcPropertiesValues;

	public IfcProperty() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getPropertyName() {
		return this.propertyName;
	}

	public void setPropertyName(String propertyName) {
		this.propertyName = propertyName;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public Timestamp getUpdated() {
		return this.updated;
	}

	public void setUpdated(Timestamp updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<IfcBuildingProperty> getIfcBuildingProperties() {
		return this.ifcBuildingProperties;
	}

	public void setIfcBuildingProperties(List<IfcBuildingProperty> ifcBuildingProperties) {
		this.ifcBuildingProperties = ifcBuildingProperties;
	}

	public IfcBuildingProperty addIfcBuildingProperty(IfcBuildingProperty ifcBuildingProperty) {
		getIfcBuildingProperties().add(ifcBuildingProperty);
		ifcBuildingProperty.setIfcProperty(this);

		return ifcBuildingProperty;
	}

	public IfcBuildingProperty removeIfcBuildingProperty(IfcBuildingProperty ifcBuildingProperty) {
		getIfcBuildingProperties().remove(ifcBuildingProperty);
		ifcBuildingProperty.setIfcProperty(null);

		return ifcBuildingProperty;
	}

	public List<IfcBuildingStoreyBeamProperty> getIfcBuildingStoreyBeamProperties() {
		return this.ifcBuildingStoreyBeamProperties;
	}

	public void setIfcBuildingStoreyBeamProperties(List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties) {
		this.ifcBuildingStoreyBeamProperties = ifcBuildingStoreyBeamProperties;
	}

	public IfcBuildingStoreyBeamProperty addIfcBuildingStoreyBeamProperty(IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
		getIfcBuildingStoreyBeamProperties().add(ifcBuildingStoreyBeamProperty);
		ifcBuildingStoreyBeamProperty.setIfcProperty(this);

		return ifcBuildingStoreyBeamProperty;
	}

	public IfcBuildingStoreyBeamProperty removeIfcBuildingStoreyBeamProperty(IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
		getIfcBuildingStoreyBeamProperties().remove(ifcBuildingStoreyBeamProperty);
		ifcBuildingStoreyBeamProperty.setIfcProperty(null);

		return ifcBuildingStoreyBeamProperty;
	}

	public List<IfcBuildingStoreyCoveringProperty> getIfcBuildingStoreyCoveringProperties() {
		return this.ifcBuildingStoreyCoveringProperties;
	}

	public void setIfcBuildingStoreyCoveringProperties(List<IfcBuildingStoreyCoveringProperty> ifcBuildingStoreyCoveringProperties) {
		this.ifcBuildingStoreyCoveringProperties = ifcBuildingStoreyCoveringProperties;
	}

	public IfcBuildingStoreyCoveringProperty addIfcBuildingStoreyCoveringProperty(IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
		getIfcBuildingStoreyCoveringProperties().add(ifcBuildingStoreyCoveringProperty);
		ifcBuildingStoreyCoveringProperty.setIfcProperty(this);

		return ifcBuildingStoreyCoveringProperty;
	}

	public IfcBuildingStoreyCoveringProperty removeIfcBuildingStoreyCoveringProperty(IfcBuildingStoreyCoveringProperty ifcBuildingStoreyCoveringProperty) {
		getIfcBuildingStoreyCoveringProperties().remove(ifcBuildingStoreyCoveringProperty);
		ifcBuildingStoreyCoveringProperty.setIfcProperty(null);

		return ifcBuildingStoreyCoveringProperty;
	}

	public List<IfcBuildingStoreyDoorProperty> getIfcBuildingStoreyDoorProperties() {
		return this.ifcBuildingStoreyDoorProperties;
	}

	public void setIfcBuildingStoreyDoorProperties(List<IfcBuildingStoreyDoorProperty> ifcBuildingStoreyDoorProperties) {
		this.ifcBuildingStoreyDoorProperties = ifcBuildingStoreyDoorProperties;
	}

	public IfcBuildingStoreyDoorProperty addIfcBuildingStoreyDoorProperty(IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
		getIfcBuildingStoreyDoorProperties().add(ifcBuildingStoreyDoorProperty);
		ifcBuildingStoreyDoorProperty.setIfcProperty(this);

		return ifcBuildingStoreyDoorProperty;
	}

	public IfcBuildingStoreyDoorProperty removeIfcBuildingStoreyDoorProperty(IfcBuildingStoreyDoorProperty ifcBuildingStoreyDoorProperty) {
		getIfcBuildingStoreyDoorProperties().remove(ifcBuildingStoreyDoorProperty);
		ifcBuildingStoreyDoorProperty.setIfcProperty(null);

		return ifcBuildingStoreyDoorProperty;
	}

	public List<IfcBuildingStoreyProperty> getIfcBuildingStoreyProperties() {
		return this.ifcBuildingStoreyProperties;
	}

	public void setIfcBuildingStoreyProperties(List<IfcBuildingStoreyProperty> ifcBuildingStoreyProperties) {
		this.ifcBuildingStoreyProperties = ifcBuildingStoreyProperties;
	}

	public IfcBuildingStoreyProperty addIfcBuildingStoreyProperty(IfcBuildingStoreyProperty ifcBuildingStoreyProperty) {
		getIfcBuildingStoreyProperties().add(ifcBuildingStoreyProperty);
		ifcBuildingStoreyProperty.setIfcProperty(this);

		return ifcBuildingStoreyProperty;
	}

	public IfcBuildingStoreyProperty removeIfcBuildingStoreyProperty(IfcBuildingStoreyProperty ifcBuildingStoreyProperty) {
		getIfcBuildingStoreyProperties().remove(ifcBuildingStoreyProperty);
		ifcBuildingStoreyProperty.setIfcProperty(null);

		return ifcBuildingStoreyProperty;
	}

	public List<IfcBuildingStoreySlabProperty> getIfcBuildingStoreySlabProperties() {
		return this.ifcBuildingStoreySlabProperties;
	}

	public void setIfcBuildingStoreySlabProperties(List<IfcBuildingStoreySlabProperty> ifcBuildingStoreySlabProperties) {
		this.ifcBuildingStoreySlabProperties = ifcBuildingStoreySlabProperties;
	}

	public IfcBuildingStoreySlabProperty addIfcBuildingStoreySlabProperty(IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
		getIfcBuildingStoreySlabProperties().add(ifcBuildingStoreySlabProperty);
		ifcBuildingStoreySlabProperty.setIfcProperty(this);

		return ifcBuildingStoreySlabProperty;
	}

	public IfcBuildingStoreySlabProperty removeIfcBuildingStoreySlabProperty(IfcBuildingStoreySlabProperty ifcBuildingStoreySlabProperty) {
		getIfcBuildingStoreySlabProperties().remove(ifcBuildingStoreySlabProperty);
		ifcBuildingStoreySlabProperty.setIfcProperty(null);

		return ifcBuildingStoreySlabProperty;
	}

	public List<IfcBuildingStoreySpaceFurnishingelementProperty> getIfcBuildingStoreySpaceFurnishingelementProperties() {
		return this.ifcBuildingStoreySpaceFurnishingelementProperties;
	}

	public void setIfcBuildingStoreySpaceFurnishingelementProperties(List<IfcBuildingStoreySpaceFurnishingelementProperty> ifcBuildingStoreySpaceFurnishingelementProperties) {
		this.ifcBuildingStoreySpaceFurnishingelementProperties = ifcBuildingStoreySpaceFurnishingelementProperties;
	}

	public IfcBuildingStoreySpaceFurnishingelementProperty addIfcBuildingStoreySpaceFurnishingelementProperty(IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
		getIfcBuildingStoreySpaceFurnishingelementProperties().add(ifcBuildingStoreySpaceFurnishingelementProperty);
		ifcBuildingStoreySpaceFurnishingelementProperty.setIfcProperty(this);

		return ifcBuildingStoreySpaceFurnishingelementProperty;
	}

	public IfcBuildingStoreySpaceFurnishingelementProperty removeIfcBuildingStoreySpaceFurnishingelementProperty(IfcBuildingStoreySpaceFurnishingelementProperty ifcBuildingStoreySpaceFurnishingelementProperty) {
		getIfcBuildingStoreySpaceFurnishingelementProperties().remove(ifcBuildingStoreySpaceFurnishingelementProperty);
		ifcBuildingStoreySpaceFurnishingelementProperty.setIfcProperty(null);

		return ifcBuildingStoreySpaceFurnishingelementProperty;
	}

	public List<IfcBuildingStoreySpaceProperty> getIfcBuildingStoreySpaceProperties() {
		return this.ifcBuildingStoreySpaceProperties;
	}

	public void setIfcBuildingStoreySpaceProperties(List<IfcBuildingStoreySpaceProperty> ifcBuildingStoreySpaceProperties) {
		this.ifcBuildingStoreySpaceProperties = ifcBuildingStoreySpaceProperties;
	}

	public IfcBuildingStoreySpaceProperty addIfcBuildingStoreySpaceProperty(IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
		getIfcBuildingStoreySpaceProperties().add(ifcBuildingStoreySpaceProperty);
		ifcBuildingStoreySpaceProperty.setIfcProperty(this);

		return ifcBuildingStoreySpaceProperty;
	}

	public IfcBuildingStoreySpaceProperty removeIfcBuildingStoreySpaceProperty(IfcBuildingStoreySpaceProperty ifcBuildingStoreySpaceProperty) {
		getIfcBuildingStoreySpaceProperties().remove(ifcBuildingStoreySpaceProperty);
		ifcBuildingStoreySpaceProperty.setIfcProperty(null);

		return ifcBuildingStoreySpaceProperty;
	}

	public List<IfcBuildingStoreyStairFlightProperty> getIfcBuildingStoreyStairFlightProperties() {
		return this.ifcBuildingStoreyStairFlightProperties;
	}

	public void setIfcBuildingStoreyStairFlightProperties(List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties) {
		this.ifcBuildingStoreyStairFlightProperties = ifcBuildingStoreyStairFlightProperties;
	}

	public IfcBuildingStoreyStairFlightProperty addIfcBuildingStoreyStairFlightProperty(IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
		getIfcBuildingStoreyStairFlightProperties().add(ifcBuildingStoreyStairFlightProperty);
		ifcBuildingStoreyStairFlightProperty.setIfcProperty(this);

		return ifcBuildingStoreyStairFlightProperty;
	}

	public IfcBuildingStoreyStairFlightProperty removeIfcBuildingStoreyStairFlightProperty(IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
		getIfcBuildingStoreyStairFlightProperties().remove(ifcBuildingStoreyStairFlightProperty);
		ifcBuildingStoreyStairFlightProperty.setIfcProperty(null);

		return ifcBuildingStoreyStairFlightProperty;
	}

	public List<IfcBuildingStoreyStairMemberProperty> getIfcBuildingStoreyStairMemberProperties() {
		return this.ifcBuildingStoreyStairMemberProperties;
	}

	public void setIfcBuildingStoreyStairMemberProperties(List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties) {
		this.ifcBuildingStoreyStairMemberProperties = ifcBuildingStoreyStairMemberProperties;
	}

	public IfcBuildingStoreyStairMemberProperty addIfcBuildingStoreyStairMemberProperty(IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
		getIfcBuildingStoreyStairMemberProperties().add(ifcBuildingStoreyStairMemberProperty);
		ifcBuildingStoreyStairMemberProperty.setIfcProperty(this);

		return ifcBuildingStoreyStairMemberProperty;
	}

	public IfcBuildingStoreyStairMemberProperty removeIfcBuildingStoreyStairMemberProperty(IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
		getIfcBuildingStoreyStairMemberProperties().remove(ifcBuildingStoreyStairMemberProperty);
		ifcBuildingStoreyStairMemberProperty.setIfcProperty(null);

		return ifcBuildingStoreyStairMemberProperty;
	}

	public List<IfcBuildingStoreyStairProperty> getIfcBuildingStoreyStairProperties() {
		return this.ifcBuildingStoreyStairProperties;
	}

	public void setIfcBuildingStoreyStairProperties(List<IfcBuildingStoreyStairProperty> ifcBuildingStoreyStairProperties) {
		this.ifcBuildingStoreyStairProperties = ifcBuildingStoreyStairProperties;
	}

	public IfcBuildingStoreyStairProperty addIfcBuildingStoreyStairProperty(IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
		getIfcBuildingStoreyStairProperties().add(ifcBuildingStoreyStairProperty);
		ifcBuildingStoreyStairProperty.setIfcProperty(this);

		return ifcBuildingStoreyStairProperty;
	}

	public IfcBuildingStoreyStairProperty removeIfcBuildingStoreyStairProperty(IfcBuildingStoreyStairProperty ifcBuildingStoreyStairProperty) {
		getIfcBuildingStoreyStairProperties().remove(ifcBuildingStoreyStairProperty);
		ifcBuildingStoreyStairProperty.setIfcProperty(null);

		return ifcBuildingStoreyStairProperty;
	}

	public List<IfcBuildingStoreyStairRailingProperty> getIfcBuildingStoreyStairRailingProperties() {
		return this.ifcBuildingStoreyStairRailingProperties;
	}

	public void setIfcBuildingStoreyStairRailingProperties(List<IfcBuildingStoreyStairRailingProperty> ifcBuildingStoreyStairRailingProperties) {
		this.ifcBuildingStoreyStairRailingProperties = ifcBuildingStoreyStairRailingProperties;
	}

	public IfcBuildingStoreyStairRailingProperty addIfcBuildingStoreyStairRailingProperty(IfcBuildingStoreyStairRailingProperty ifcBuildingStoreyStairRailingProperty) {
		getIfcBuildingStoreyStairRailingProperties().add(ifcBuildingStoreyStairRailingProperty);
		ifcBuildingStoreyStairRailingProperty.setIfcProperty(this);

		return ifcBuildingStoreyStairRailingProperty;
	}

	public IfcBuildingStoreyStairRailingProperty removeIfcBuildingStoreyStairRailingProperty(IfcBuildingStoreyStairRailingProperty ifcBuildingStoreyStairRailingProperty) {
		getIfcBuildingStoreyStairRailingProperties().remove(ifcBuildingStoreyStairRailingProperty);
		ifcBuildingStoreyStairRailingProperty.setIfcProperty(null);

		return ifcBuildingStoreyStairRailingProperty;
	}

	public List<IfcBuildingStoreyWallProperty> getIfcBuildingStoreyWallProperties() {
		return this.ifcBuildingStoreyWallProperties;
	}

	public void setIfcBuildingStoreyWallProperties(List<IfcBuildingStoreyWallProperty> ifcBuildingStoreyWallProperties) {
		this.ifcBuildingStoreyWallProperties = ifcBuildingStoreyWallProperties;
	}

	public IfcBuildingStoreyWallProperty addIfcBuildingStoreyWallProperty(IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
		getIfcBuildingStoreyWallProperties().add(ifcBuildingStoreyWallProperty);
		ifcBuildingStoreyWallProperty.setIfcProperty(this);

		return ifcBuildingStoreyWallProperty;
	}

	public IfcBuildingStoreyWallProperty removeIfcBuildingStoreyWallProperty(IfcBuildingStoreyWallProperty ifcBuildingStoreyWallProperty) {
		getIfcBuildingStoreyWallProperties().remove(ifcBuildingStoreyWallProperty);
		ifcBuildingStoreyWallProperty.setIfcProperty(null);

		return ifcBuildingStoreyWallProperty;
	}

	public List<IfcBuildingStoreyWindowProperty> getIfcBuildingStoreyWindowProperties() {
		return this.ifcBuildingStoreyWindowProperties;
	}

	public void setIfcBuildingStoreyWindowProperties(List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties) {
		this.ifcBuildingStoreyWindowProperties = ifcBuildingStoreyWindowProperties;
	}

	public IfcBuildingStoreyWindowProperty addIfcBuildingStoreyWindowProperty(IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
		getIfcBuildingStoreyWindowProperties().add(ifcBuildingStoreyWindowProperty);
		ifcBuildingStoreyWindowProperty.setIfcProperty(this);

		return ifcBuildingStoreyWindowProperty;
	}

	public IfcBuildingStoreyWindowProperty removeIfcBuildingStoreyWindowProperty(IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
		getIfcBuildingStoreyWindowProperties().remove(ifcBuildingStoreyWindowProperty);
		ifcBuildingStoreyWindowProperty.setIfcProperty(null);

		return ifcBuildingStoreyWindowProperty;
	}

	public ProjectIfc getProjectIfc() {
		return this.projectIfc;
	}

	public void setProjectIfc(ProjectIfc projectIfc) {
		this.projectIfc = projectIfc;
	}

	public List<IfcPropertiesValue> getIfcPropertiesValues() {
		return this.ifcPropertiesValues;
	}

	public void setIfcPropertiesValues(List<IfcPropertiesValue> ifcPropertiesValues) {
		this.ifcPropertiesValues = ifcPropertiesValues;
	}

	public IfcPropertiesValue addIfcPropertiesValue(IfcPropertiesValue ifcPropertiesValue) {
		getIfcPropertiesValues().add(ifcPropertiesValue);
		ifcPropertiesValue.setIfcProperty(this);

		return ifcPropertiesValue;
	}

	public IfcPropertiesValue removeIfcPropertiesValue(IfcPropertiesValue ifcPropertiesValue) {
		getIfcPropertiesValues().remove(ifcPropertiesValue);
		ifcPropertiesValue.setIfcProperty(null);

		return ifcPropertiesValue;
	}

}