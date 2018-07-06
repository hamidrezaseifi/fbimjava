package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey")
@NamedQuery(name="IfcBuildingStorey.findAll", query="SELECT i FROM IfcBuildingStorey i")
public class IfcBuildingStorey implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	@Column(name="building_id")
	private String buildingId;

	@Column(name="composition_type")
	private String compositionType;

	private Timestamp created;

	private String elevation;

	@Column(name="object_placement")
	private String objectPlacement;

	private short status;

	@Column(name="storey_name")
	private String storeyName;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreyStair
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyStair> ifcBuildingStoreyStairs;

	//bi-directional many-to-one association to IfcBuildingStoreyStairFlight
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyStairFlight> ifcBuildingStoreyStairFlights;

	//bi-directional many-to-one association to IfcBuildingStoreyStairMember
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyStairMember> ifcBuildingStoreyStairMembers;

	//bi-directional many-to-one association to IfcBuildingStoreyStairRailing
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyStairRailing> ifcBuildingStoreyStairRailings;

	public IfcBuildingStorey() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getBuildingId() {
		return this.buildingId;
	}

	public void setBuildingId(String buildingId) {
		this.buildingId = buildingId;
	}

	public String getCompositionType() {
		return this.compositionType;
	}

	public void setCompositionType(String compositionType) {
		this.compositionType = compositionType;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getElevation() {
		return this.elevation;
	}

	public void setElevation(String elevation) {
		this.elevation = elevation;
	}

	public String getObjectPlacement() {
		return this.objectPlacement;
	}

	public void setObjectPlacement(String objectPlacement) {
		this.objectPlacement = objectPlacement;
	}

	public short getStatus() {
		return this.status;
	}

	public void setStatus(short status) {
		this.status = status;
	}

	public String getStoreyName() {
		return this.storeyName;
	}

	public void setStoreyName(String storeyName) {
		this.storeyName = storeyName;
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

	public List<IfcBuildingStoreyStair> getIfcBuildingStoreyStairs() {
		return this.ifcBuildingStoreyStairs;
	}

	public void setIfcBuildingStoreyStairs(List<IfcBuildingStoreyStair> ifcBuildingStoreyStairs) {
		this.ifcBuildingStoreyStairs = ifcBuildingStoreyStairs;
	}

	public IfcBuildingStoreyStair addIfcBuildingStoreyStair(IfcBuildingStoreyStair ifcBuildingStoreyStair) {
		getIfcBuildingStoreyStairs().add(ifcBuildingStoreyStair);
		ifcBuildingStoreyStair.setIfcBuildingStorey(this);

		return ifcBuildingStoreyStair;
	}

	public IfcBuildingStoreyStair removeIfcBuildingStoreyStair(IfcBuildingStoreyStair ifcBuildingStoreyStair) {
		getIfcBuildingStoreyStairs().remove(ifcBuildingStoreyStair);
		ifcBuildingStoreyStair.setIfcBuildingStorey(null);

		return ifcBuildingStoreyStair;
	}

	public List<IfcBuildingStoreyStairFlight> getIfcBuildingStoreyStairFlights() {
		return this.ifcBuildingStoreyStairFlights;
	}

	public void setIfcBuildingStoreyStairFlights(List<IfcBuildingStoreyStairFlight> ifcBuildingStoreyStairFlights) {
		this.ifcBuildingStoreyStairFlights = ifcBuildingStoreyStairFlights;
	}

	public IfcBuildingStoreyStairFlight addIfcBuildingStoreyStairFlight(IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
		getIfcBuildingStoreyStairFlights().add(ifcBuildingStoreyStairFlight);
		ifcBuildingStoreyStairFlight.setIfcBuildingStorey(this);

		return ifcBuildingStoreyStairFlight;
	}

	public IfcBuildingStoreyStairFlight removeIfcBuildingStoreyStairFlight(IfcBuildingStoreyStairFlight ifcBuildingStoreyStairFlight) {
		getIfcBuildingStoreyStairFlights().remove(ifcBuildingStoreyStairFlight);
		ifcBuildingStoreyStairFlight.setIfcBuildingStorey(null);

		return ifcBuildingStoreyStairFlight;
	}

	public List<IfcBuildingStoreyStairMember> getIfcBuildingStoreyStairMembers() {
		return this.ifcBuildingStoreyStairMembers;
	}

	public void setIfcBuildingStoreyStairMembers(List<IfcBuildingStoreyStairMember> ifcBuildingStoreyStairMembers) {
		this.ifcBuildingStoreyStairMembers = ifcBuildingStoreyStairMembers;
	}

	public IfcBuildingStoreyStairMember addIfcBuildingStoreyStairMember(IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember) {
		getIfcBuildingStoreyStairMembers().add(ifcBuildingStoreyStairMember);
		ifcBuildingStoreyStairMember.setIfcBuildingStorey(this);

		return ifcBuildingStoreyStairMember;
	}

	public IfcBuildingStoreyStairMember removeIfcBuildingStoreyStairMember(IfcBuildingStoreyStairMember ifcBuildingStoreyStairMember) {
		getIfcBuildingStoreyStairMembers().remove(ifcBuildingStoreyStairMember);
		ifcBuildingStoreyStairMember.setIfcBuildingStorey(null);

		return ifcBuildingStoreyStairMember;
	}

	public List<IfcBuildingStoreyStairRailing> getIfcBuildingStoreyStairRailings() {
		return this.ifcBuildingStoreyStairRailings;
	}

	public void setIfcBuildingStoreyStairRailings(List<IfcBuildingStoreyStairRailing> ifcBuildingStoreyStairRailings) {
		this.ifcBuildingStoreyStairRailings = ifcBuildingStoreyStairRailings;
	}

	public IfcBuildingStoreyStairRailing addIfcBuildingStoreyStairRailing(IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing) {
		getIfcBuildingStoreyStairRailings().add(ifcBuildingStoreyStairRailing);
		ifcBuildingStoreyStairRailing.setIfcBuildingStorey(this);

		return ifcBuildingStoreyStairRailing;
	}

	public IfcBuildingStoreyStairRailing removeIfcBuildingStoreyStairRailing(IfcBuildingStoreyStairRailing ifcBuildingStoreyStairRailing) {
		getIfcBuildingStoreyStairRailings().remove(ifcBuildingStoreyStairRailing);
		ifcBuildingStoreyStairRailing.setIfcBuildingStorey(null);

		return ifcBuildingStoreyStairRailing;
	}

}