package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_stair_flight database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_stair_flight")
@NamedQuery(name="IfcBuildingStoreyStairFlight.findAll", query="SELECT i FROM IfcBuildingStoreyStairFlight i")
public class IfcBuildingStoreyStairFlight implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="flight_name")
	private String flightName;

	@Column(name="number_of_riser")
	private String numberOfRiser;

	@Column(name="number_of_treads")
	private String numberOfTreads;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="riser_height")
	private String riserHeight;

	private short status;

	private String tag;

	@Column(name="treads_height")
	private String treadsHeight;

	private Timestamp updated;

	private int version;

	//bi-directional many-to-one association to IfcBuildingStoreyStairFlightPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyStairFlight")
	private List<IfcBuildingStoreyStairFlightPresentationlayer> ifcBuildingStoreyStairFlightPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyStairFlightProperty
	@OneToMany(mappedBy="ifcBuildingStoreyStairFlight")
	private List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyStair
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="stair_id")
	private IfcBuildingStoreyStair ifcBuildingStoreyStair;

	public IfcBuildingStoreyStairFlight() {
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

	public String getFlightName() {
		return this.flightName;
	}

	public void setFlightName(String flightName) {
		this.flightName = flightName;
	}

	public String getNumberOfRiser() {
		return this.numberOfRiser;
	}

	public void setNumberOfRiser(String numberOfRiser) {
		this.numberOfRiser = numberOfRiser;
	}

	public String getNumberOfTreads() {
		return this.numberOfTreads;
	}

	public void setNumberOfTreads(String numberOfTreads) {
		this.numberOfTreads = numberOfTreads;
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

	public String getRiserHeight() {
		return this.riserHeight;
	}

	public void setRiserHeight(String riserHeight) {
		this.riserHeight = riserHeight;
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

	public String getTreadsHeight() {
		return this.treadsHeight;
	}

	public void setTreadsHeight(String treadsHeight) {
		this.treadsHeight = treadsHeight;
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

	public List<IfcBuildingStoreyStairFlightPresentationlayer> getIfcBuildingStoreyStairFlightPresentationlayers() {
		return this.ifcBuildingStoreyStairFlightPresentationlayers;
	}

	public void setIfcBuildingStoreyStairFlightPresentationlayers(List<IfcBuildingStoreyStairFlightPresentationlayer> ifcBuildingStoreyStairFlightPresentationlayers) {
		this.ifcBuildingStoreyStairFlightPresentationlayers = ifcBuildingStoreyStairFlightPresentationlayers;
	}

	public IfcBuildingStoreyStairFlightPresentationlayer addIfcBuildingStoreyStairFlightPresentationlayer(IfcBuildingStoreyStairFlightPresentationlayer ifcBuildingStoreyStairFlightPresentationlayer) {
		getIfcBuildingStoreyStairFlightPresentationlayers().add(ifcBuildingStoreyStairFlightPresentationlayer);
		ifcBuildingStoreyStairFlightPresentationlayer.setIfcBuildingStoreyStairFlight(this);

		return ifcBuildingStoreyStairFlightPresentationlayer;
	}

	public IfcBuildingStoreyStairFlightPresentationlayer removeIfcBuildingStoreyStairFlightPresentationlayer(IfcBuildingStoreyStairFlightPresentationlayer ifcBuildingStoreyStairFlightPresentationlayer) {
		getIfcBuildingStoreyStairFlightPresentationlayers().remove(ifcBuildingStoreyStairFlightPresentationlayer);
		ifcBuildingStoreyStairFlightPresentationlayer.setIfcBuildingStoreyStairFlight(null);

		return ifcBuildingStoreyStairFlightPresentationlayer;
	}

	public List<IfcBuildingStoreyStairFlightProperty> getIfcBuildingStoreyStairFlightProperties() {
		return this.ifcBuildingStoreyStairFlightProperties;
	}

	public void setIfcBuildingStoreyStairFlightProperties(List<IfcBuildingStoreyStairFlightProperty> ifcBuildingStoreyStairFlightProperties) {
		this.ifcBuildingStoreyStairFlightProperties = ifcBuildingStoreyStairFlightProperties;
	}

	public IfcBuildingStoreyStairFlightProperty addIfcBuildingStoreyStairFlightProperty(IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
		getIfcBuildingStoreyStairFlightProperties().add(ifcBuildingStoreyStairFlightProperty);
		ifcBuildingStoreyStairFlightProperty.setIfcBuildingStoreyStairFlight(this);

		return ifcBuildingStoreyStairFlightProperty;
	}

	public IfcBuildingStoreyStairFlightProperty removeIfcBuildingStoreyStairFlightProperty(IfcBuildingStoreyStairFlightProperty ifcBuildingStoreyStairFlightProperty) {
		getIfcBuildingStoreyStairFlightProperties().remove(ifcBuildingStoreyStairFlightProperty);
		ifcBuildingStoreyStairFlightProperty.setIfcBuildingStoreyStairFlight(null);

		return ifcBuildingStoreyStairFlightProperty;
	}

	public IfcBuildingStoreyStair getIfcBuildingStoreyStair() {
		return this.ifcBuildingStoreyStair;
	}

	public void setIfcBuildingStoreyStair(IfcBuildingStoreyStair ifcBuildingStoreyStair) {
		this.ifcBuildingStoreyStair = ifcBuildingStoreyStair;
	}

}