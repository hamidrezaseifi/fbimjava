package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_beam database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_beam")
@NamedQuery(name="IfcBuildingStoreyBeam.findAll", query="SELECT i FROM IfcBuildingStoreyBeam i")
public class IfcBuildingStoreyBeam implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="beam_name")
	private String beamName;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stair_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyBeamPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyBeam")
	private List<IfcBuildingStoreyBeamPresentationlayer> ifcBuildingStoreyBeamPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyBeamProperty
	@OneToMany(mappedBy="ifcBuildingStoreyBeam")
	private List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties;

	public IfcBuildingStoreyBeam() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBeamName() {
		return this.beamName;
	}

	public void setBeamName(String beamName) {
		this.beamName = beamName;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getObjectPlacement() {
		return this.objectPlacement;
	}

	public void setObjectPlacement(String objectPlacement) {
		this.objectPlacement = objectPlacement;
	}

	public String getObjectType() {
		return this.objectType;
	}

	public void setObjectType(String objectType) {
		this.objectType = objectType;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getTag() {
		return this.tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
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

	public IfcBuildingStorey getIfcBuildingStorey() {
		return this.ifcBuildingStorey;
	}

	public void setIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
	}

	public List<IfcBuildingStoreyBeamPresentationlayer> getIfcBuildingStoreyBeamPresentationlayers() {
		return this.ifcBuildingStoreyBeamPresentationlayers;
	}

	public void setIfcBuildingStoreyBeamPresentationlayers(List<IfcBuildingStoreyBeamPresentationlayer> ifcBuildingStoreyBeamPresentationlayers) {
		this.ifcBuildingStoreyBeamPresentationlayers = ifcBuildingStoreyBeamPresentationlayers;
	}

	public IfcBuildingStoreyBeamPresentationlayer addIfcBuildingStoreyBeamPresentationlayer(IfcBuildingStoreyBeamPresentationlayer ifcBuildingStoreyBeamPresentationlayer) {
		getIfcBuildingStoreyBeamPresentationlayers().add(ifcBuildingStoreyBeamPresentationlayer);
		ifcBuildingStoreyBeamPresentationlayer.setIfcBuildingStoreyBeam(this);

		return ifcBuildingStoreyBeamPresentationlayer;
	}

	public IfcBuildingStoreyBeamPresentationlayer removeIfcBuildingStoreyBeamPresentationlayer(IfcBuildingStoreyBeamPresentationlayer ifcBuildingStoreyBeamPresentationlayer) {
		getIfcBuildingStoreyBeamPresentationlayers().remove(ifcBuildingStoreyBeamPresentationlayer);
		ifcBuildingStoreyBeamPresentationlayer.setIfcBuildingStoreyBeam(null);

		return ifcBuildingStoreyBeamPresentationlayer;
	}

	public List<IfcBuildingStoreyBeamProperty> getIfcBuildingStoreyBeamProperties() {
		return this.ifcBuildingStoreyBeamProperties;
	}

	public void setIfcBuildingStoreyBeamProperties(List<IfcBuildingStoreyBeamProperty> ifcBuildingStoreyBeamProperties) {
		this.ifcBuildingStoreyBeamProperties = ifcBuildingStoreyBeamProperties;
	}

	public IfcBuildingStoreyBeamProperty addIfcBuildingStoreyBeamProperty(IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
		getIfcBuildingStoreyBeamProperties().add(ifcBuildingStoreyBeamProperty);
		ifcBuildingStoreyBeamProperty.setIfcBuildingStoreyBeam(this);

		return ifcBuildingStoreyBeamProperty;
	}

	public IfcBuildingStoreyBeamProperty removeIfcBuildingStoreyBeamProperty(IfcBuildingStoreyBeamProperty ifcBuildingStoreyBeamProperty) {
		getIfcBuildingStoreyBeamProperties().remove(ifcBuildingStoreyBeamProperty);
		ifcBuildingStoreyBeamProperty.setIfcBuildingStoreyBeam(null);

		return ifcBuildingStoreyBeamProperty;
	}

}