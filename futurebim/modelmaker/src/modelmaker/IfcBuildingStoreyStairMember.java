package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_stair_member database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_stair_member")
@NamedQuery(name="IfcBuildingStoreyStairMember.findAll", query="SELECT i FROM IfcBuildingStoreyStairMember i")
public class IfcBuildingStoreyStairMember implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="member_name")
	private String memberName;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne
	@JoinColumn(name="stair_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyStair
	@ManyToOne
	@JoinColumn(name="stair_id")
	private IfcBuildingStoreyStair ifcBuildingStoreyStair;

	//bi-directional many-to-one association to IfcBuildingStoreyStairMemberPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyStairMember")
	private List<IfcBuildingStoreyStairMemberPresentationlayer> ifcBuildingStoreyStairMemberPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyStairMemberProperty
	@OneToMany(mappedBy="ifcBuildingStoreyStairMember")
	private List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties;

	public IfcBuildingStoreyStairMember() {
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

	public String getMemberName() {
		return this.memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
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

	public IfcBuildingStoreyStair getIfcBuildingStoreyStair() {
		return this.ifcBuildingStoreyStair;
	}

	public void setIfcBuildingStoreyStair(IfcBuildingStoreyStair ifcBuildingStoreyStair) {
		this.ifcBuildingStoreyStair = ifcBuildingStoreyStair;
	}

	public List<IfcBuildingStoreyStairMemberPresentationlayer> getIfcBuildingStoreyStairMemberPresentationlayers() {
		return this.ifcBuildingStoreyStairMemberPresentationlayers;
	}

	public void setIfcBuildingStoreyStairMemberPresentationlayers(List<IfcBuildingStoreyStairMemberPresentationlayer> ifcBuildingStoreyStairMemberPresentationlayers) {
		this.ifcBuildingStoreyStairMemberPresentationlayers = ifcBuildingStoreyStairMemberPresentationlayers;
	}

	public IfcBuildingStoreyStairMemberPresentationlayer addIfcBuildingStoreyStairMemberPresentationlayer(IfcBuildingStoreyStairMemberPresentationlayer ifcBuildingStoreyStairMemberPresentationlayer) {
		getIfcBuildingStoreyStairMemberPresentationlayers().add(ifcBuildingStoreyStairMemberPresentationlayer);
		ifcBuildingStoreyStairMemberPresentationlayer.setIfcBuildingStoreyStairMember(this);

		return ifcBuildingStoreyStairMemberPresentationlayer;
	}

	public IfcBuildingStoreyStairMemberPresentationlayer removeIfcBuildingStoreyStairMemberPresentationlayer(IfcBuildingStoreyStairMemberPresentationlayer ifcBuildingStoreyStairMemberPresentationlayer) {
		getIfcBuildingStoreyStairMemberPresentationlayers().remove(ifcBuildingStoreyStairMemberPresentationlayer);
		ifcBuildingStoreyStairMemberPresentationlayer.setIfcBuildingStoreyStairMember(null);

		return ifcBuildingStoreyStairMemberPresentationlayer;
	}

	public List<IfcBuildingStoreyStairMemberProperty> getIfcBuildingStoreyStairMemberProperties() {
		return this.ifcBuildingStoreyStairMemberProperties;
	}

	public void setIfcBuildingStoreyStairMemberProperties(List<IfcBuildingStoreyStairMemberProperty> ifcBuildingStoreyStairMemberProperties) {
		this.ifcBuildingStoreyStairMemberProperties = ifcBuildingStoreyStairMemberProperties;
	}

	public IfcBuildingStoreyStairMemberProperty addIfcBuildingStoreyStairMemberProperty(IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
		getIfcBuildingStoreyStairMemberProperties().add(ifcBuildingStoreyStairMemberProperty);
		ifcBuildingStoreyStairMemberProperty.setIfcBuildingStoreyStairMember(this);

		return ifcBuildingStoreyStairMemberProperty;
	}

	public IfcBuildingStoreyStairMemberProperty removeIfcBuildingStoreyStairMemberProperty(IfcBuildingStoreyStairMemberProperty ifcBuildingStoreyStairMemberProperty) {
		getIfcBuildingStoreyStairMemberProperties().remove(ifcBuildingStoreyStairMemberProperty);
		ifcBuildingStoreyStairMemberProperty.setIfcBuildingStoreyStairMember(null);

		return ifcBuildingStoreyStairMemberProperty;
	}

}