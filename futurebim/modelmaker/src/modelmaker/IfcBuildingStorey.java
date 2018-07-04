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

	//bi-directional many-to-one association to IfcBuilding
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="building_id")
	private IfcBuilding ifcBuilding;

	//bi-directional many-to-one association to IfcBuildingStoreyBeam
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyBeam> ifcBuildingStoreyBeams;

	//bi-directional many-to-one association to IfcBuildingStoreyCovering
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyCovering> ifcBuildingStoreyCoverings;

	//bi-directional many-to-one association to IfcBuildingStoreyDoor
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyDoor> ifcBuildingStoreyDoors;

	//bi-directional many-to-one association to IfcBuildingStoreyProperty
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyProperty> ifcBuildingStoreyProperties;

	//bi-directional many-to-one association to IfcBuildingStoreySlab
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreySlab> ifcBuildingStoreySlabs;

	//bi-directional many-to-one association to IfcBuildingStoreySpace
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreySpace> ifcBuildingStoreySpaces;

	//bi-directional many-to-one association to IfcBuildingStoreySpaceFurnishingelement
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreySpaceFurnishingelement> ifcBuildingStoreySpaceFurnishingelements;

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

	//bi-directional many-to-one association to IfcBuildingStoreyWall
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyWall> ifcBuildingStoreyWalls;

	//bi-directional many-to-one association to IfcBuildingStoreyWindow
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyWindow> ifcBuildingStoreyWindows;

	//bi-directional many-to-one association to IfcBuildingStoreyWallstandardcase
	@OneToMany(mappedBy="ifcBuildingStorey")
	private List<IfcBuildingStoreyWallstandardcase> ifcBuildingStoreyWallstandardcases;

	public IfcBuildingStorey() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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

	public IfcBuilding getIfcBuilding() {
		return this.ifcBuilding;
	}

	public void setIfcBuilding(IfcBuilding ifcBuilding) {
		this.ifcBuilding = ifcBuilding;
	}

	public List<IfcBuildingStoreyBeam> getIfcBuildingStoreyBeams() {
		return this.ifcBuildingStoreyBeams;
	}

	public void setIfcBuildingStoreyBeams(List<IfcBuildingStoreyBeam> ifcBuildingStoreyBeams) {
		this.ifcBuildingStoreyBeams = ifcBuildingStoreyBeams;
	}

	public IfcBuildingStoreyBeam addIfcBuildingStoreyBeam(IfcBuildingStoreyBeam ifcBuildingStoreyBeam) {
		getIfcBuildingStoreyBeams().add(ifcBuildingStoreyBeam);
		ifcBuildingStoreyBeam.setIfcBuildingStorey(this);

		return ifcBuildingStoreyBeam;
	}

	public IfcBuildingStoreyBeam removeIfcBuildingStoreyBeam(IfcBuildingStoreyBeam ifcBuildingStoreyBeam) {
		getIfcBuildingStoreyBeams().remove(ifcBuildingStoreyBeam);
		ifcBuildingStoreyBeam.setIfcBuildingStorey(null);

		return ifcBuildingStoreyBeam;
	}

	public List<IfcBuildingStoreyCovering> getIfcBuildingStoreyCoverings() {
		return this.ifcBuildingStoreyCoverings;
	}

	public void setIfcBuildingStoreyCoverings(List<IfcBuildingStoreyCovering> ifcBuildingStoreyCoverings) {
		this.ifcBuildingStoreyCoverings = ifcBuildingStoreyCoverings;
	}

	public IfcBuildingStoreyCovering addIfcBuildingStoreyCovering(IfcBuildingStoreyCovering ifcBuildingStoreyCovering) {
		getIfcBuildingStoreyCoverings().add(ifcBuildingStoreyCovering);
		ifcBuildingStoreyCovering.setIfcBuildingStorey(this);

		return ifcBuildingStoreyCovering;
	}

	public IfcBuildingStoreyCovering removeIfcBuildingStoreyCovering(IfcBuildingStoreyCovering ifcBuildingStoreyCovering) {
		getIfcBuildingStoreyCoverings().remove(ifcBuildingStoreyCovering);
		ifcBuildingStoreyCovering.setIfcBuildingStorey(null);

		return ifcBuildingStoreyCovering;
	}

	public List<IfcBuildingStoreyDoor> getIfcBuildingStoreyDoors() {
		return this.ifcBuildingStoreyDoors;
	}

	public void setIfcBuildingStoreyDoors(List<IfcBuildingStoreyDoor> ifcBuildingStoreyDoors) {
		this.ifcBuildingStoreyDoors = ifcBuildingStoreyDoors;
	}

	public IfcBuildingStoreyDoor addIfcBuildingStoreyDoor(IfcBuildingStoreyDoor ifcBuildingStoreyDoor) {
		getIfcBuildingStoreyDoors().add(ifcBuildingStoreyDoor);
		ifcBuildingStoreyDoor.setIfcBuildingStorey(this);

		return ifcBuildingStoreyDoor;
	}

	public IfcBuildingStoreyDoor removeIfcBuildingStoreyDoor(IfcBuildingStoreyDoor ifcBuildingStoreyDoor) {
		getIfcBuildingStoreyDoors().remove(ifcBuildingStoreyDoor);
		ifcBuildingStoreyDoor.setIfcBuildingStorey(null);

		return ifcBuildingStoreyDoor;
	}

	public List<IfcBuildingStoreyProperty> getIfcBuildingStoreyProperties() {
		return this.ifcBuildingStoreyProperties;
	}

	public void setIfcBuildingStoreyProperties(List<IfcBuildingStoreyProperty> ifcBuildingStoreyProperties) {
		this.ifcBuildingStoreyProperties = ifcBuildingStoreyProperties;
	}

	public IfcBuildingStoreyProperty addIfcBuildingStoreyProperty(IfcBuildingStoreyProperty ifcBuildingStoreyProperty) {
		getIfcBuildingStoreyProperties().add(ifcBuildingStoreyProperty);
		ifcBuildingStoreyProperty.setIfcBuildingStorey(this);

		return ifcBuildingStoreyProperty;
	}

	public IfcBuildingStoreyProperty removeIfcBuildingStoreyProperty(IfcBuildingStoreyProperty ifcBuildingStoreyProperty) {
		getIfcBuildingStoreyProperties().remove(ifcBuildingStoreyProperty);
		ifcBuildingStoreyProperty.setIfcBuildingStorey(null);

		return ifcBuildingStoreyProperty;
	}

	public List<IfcBuildingStoreySlab> getIfcBuildingStoreySlabs() {
		return this.ifcBuildingStoreySlabs;
	}

	public void setIfcBuildingStoreySlabs(List<IfcBuildingStoreySlab> ifcBuildingStoreySlabs) {
		this.ifcBuildingStoreySlabs = ifcBuildingStoreySlabs;
	}

	public IfcBuildingStoreySlab addIfcBuildingStoreySlab(IfcBuildingStoreySlab ifcBuildingStoreySlab) {
		getIfcBuildingStoreySlabs().add(ifcBuildingStoreySlab);
		ifcBuildingStoreySlab.setIfcBuildingStorey(this);

		return ifcBuildingStoreySlab;
	}

	public IfcBuildingStoreySlab removeIfcBuildingStoreySlab(IfcBuildingStoreySlab ifcBuildingStoreySlab) {
		getIfcBuildingStoreySlabs().remove(ifcBuildingStoreySlab);
		ifcBuildingStoreySlab.setIfcBuildingStorey(null);

		return ifcBuildingStoreySlab;
	}

	public List<IfcBuildingStoreySpace> getIfcBuildingStoreySpaces() {
		return this.ifcBuildingStoreySpaces;
	}

	public void setIfcBuildingStoreySpaces(List<IfcBuildingStoreySpace> ifcBuildingStoreySpaces) {
		this.ifcBuildingStoreySpaces = ifcBuildingStoreySpaces;
	}

	public IfcBuildingStoreySpace addIfcBuildingStoreySpace(IfcBuildingStoreySpace ifcBuildingStoreySpace) {
		getIfcBuildingStoreySpaces().add(ifcBuildingStoreySpace);
		ifcBuildingStoreySpace.setIfcBuildingStorey(this);

		return ifcBuildingStoreySpace;
	}

	public IfcBuildingStoreySpace removeIfcBuildingStoreySpace(IfcBuildingStoreySpace ifcBuildingStoreySpace) {
		getIfcBuildingStoreySpaces().remove(ifcBuildingStoreySpace);
		ifcBuildingStoreySpace.setIfcBuildingStorey(null);

		return ifcBuildingStoreySpace;
	}

	public List<IfcBuildingStoreySpaceFurnishingelement> getIfcBuildingStoreySpaceFurnishingelements() {
		return this.ifcBuildingStoreySpaceFurnishingelements;
	}

	public void setIfcBuildingStoreySpaceFurnishingelements(List<IfcBuildingStoreySpaceFurnishingelement> ifcBuildingStoreySpaceFurnishingelements) {
		this.ifcBuildingStoreySpaceFurnishingelements = ifcBuildingStoreySpaceFurnishingelements;
	}

	public IfcBuildingStoreySpaceFurnishingelement addIfcBuildingStoreySpaceFurnishingelement(IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
		getIfcBuildingStoreySpaceFurnishingelements().add(ifcBuildingStoreySpaceFurnishingelement);
		ifcBuildingStoreySpaceFurnishingelement.setIfcBuildingStorey(this);

		return ifcBuildingStoreySpaceFurnishingelement;
	}

	public IfcBuildingStoreySpaceFurnishingelement removeIfcBuildingStoreySpaceFurnishingelement(IfcBuildingStoreySpaceFurnishingelement ifcBuildingStoreySpaceFurnishingelement) {
		getIfcBuildingStoreySpaceFurnishingelements().remove(ifcBuildingStoreySpaceFurnishingelement);
		ifcBuildingStoreySpaceFurnishingelement.setIfcBuildingStorey(null);

		return ifcBuildingStoreySpaceFurnishingelement;
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

	public List<IfcBuildingStoreyWall> getIfcBuildingStoreyWalls() {
		return this.ifcBuildingStoreyWalls;
	}

	public void setIfcBuildingStoreyWalls(List<IfcBuildingStoreyWall> ifcBuildingStoreyWalls) {
		this.ifcBuildingStoreyWalls = ifcBuildingStoreyWalls;
	}

	public IfcBuildingStoreyWall addIfcBuildingStoreyWall(IfcBuildingStoreyWall ifcBuildingStoreyWall) {
		getIfcBuildingStoreyWalls().add(ifcBuildingStoreyWall);
		ifcBuildingStoreyWall.setIfcBuildingStorey(this);

		return ifcBuildingStoreyWall;
	}

	public IfcBuildingStoreyWall removeIfcBuildingStoreyWall(IfcBuildingStoreyWall ifcBuildingStoreyWall) {
		getIfcBuildingStoreyWalls().remove(ifcBuildingStoreyWall);
		ifcBuildingStoreyWall.setIfcBuildingStorey(null);

		return ifcBuildingStoreyWall;
	}

	public List<IfcBuildingStoreyWindow> getIfcBuildingStoreyWindows() {
		return this.ifcBuildingStoreyWindows;
	}

	public void setIfcBuildingStoreyWindows(List<IfcBuildingStoreyWindow> ifcBuildingStoreyWindows) {
		this.ifcBuildingStoreyWindows = ifcBuildingStoreyWindows;
	}

	public IfcBuildingStoreyWindow addIfcBuildingStoreyWindow(IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
		getIfcBuildingStoreyWindows().add(ifcBuildingStoreyWindow);
		ifcBuildingStoreyWindow.setIfcBuildingStorey(this);

		return ifcBuildingStoreyWindow;
	}

	public IfcBuildingStoreyWindow removeIfcBuildingStoreyWindow(IfcBuildingStoreyWindow ifcBuildingStoreyWindow) {
		getIfcBuildingStoreyWindows().remove(ifcBuildingStoreyWindow);
		ifcBuildingStoreyWindow.setIfcBuildingStorey(null);

		return ifcBuildingStoreyWindow;
	}

	public List<IfcBuildingStoreyWallstandardcase> getIfcBuildingStoreyWallstandardcases() {
		return this.ifcBuildingStoreyWallstandardcases;
	}

	public void setIfcBuildingStoreyWallstandardcases(List<IfcBuildingStoreyWallstandardcase> ifcBuildingStoreyWallstandardcases) {
		this.ifcBuildingStoreyWallstandardcases = ifcBuildingStoreyWallstandardcases;
	}

	public IfcBuildingStoreyWallstandardcase addIfcBuildingStoreyWallstandardcas(IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcas) {
		getIfcBuildingStoreyWallstandardcases().add(ifcBuildingStoreyWallstandardcas);
		ifcBuildingStoreyWallstandardcas.setIfcBuildingStorey(this);

		return ifcBuildingStoreyWallstandardcas;
	}

	public IfcBuildingStoreyWallstandardcase removeIfcBuildingStoreyWallstandardcas(IfcBuildingStoreyWallstandardcase ifcBuildingStoreyWallstandardcas) {
		getIfcBuildingStoreyWallstandardcases().remove(ifcBuildingStoreyWallstandardcas);
		ifcBuildingStoreyWallstandardcas.setIfcBuildingStorey(null);

		return ifcBuildingStoreyWallstandardcas;
	}

}