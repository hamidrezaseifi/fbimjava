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

	//bi-directional many-to-one association to ProjectIfc
	@ManyToOne
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