package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the ifc_building_storey_window database table.
 * 
 */
@Entity
@Table(name="ifc_building_storey_window")
@NamedQuery(name="IfcBuildingStoreyWindow.findAll", query="SELECT i FROM IfcBuildingStoreyWindow i")
public class IfcBuildingStoreyWindow implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String id;

	private Timestamp created;

	@Column(name="object_placement")
	private String objectPlacement;

	@Column(name="object_type")
	private String objectType;

	@Column(name="overall_height")
	private String overallHeight;

	@Column(name="overall_width")
	private String overallWidth;

	private short status;

	private String tag;

	private Timestamp updated;

	private int version;

	@Column(name="window_name")
	private String windowName;

	//bi-directional many-to-one association to IfcBuildingStorey
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="storey_id")
	private IfcBuildingStorey ifcBuildingStorey;

	//bi-directional many-to-one association to IfcBuildingStoreyWindowPresentationlayer
	@OneToMany(mappedBy="ifcBuildingStoreyWindow")
	private List<IfcBuildingStoreyWindowPresentationlayer> ifcBuildingStoreyWindowPresentationlayers;

	//bi-directional many-to-one association to IfcBuildingStoreyWindowProperty
	@OneToMany(mappedBy="ifcBuildingStoreyWindow")
	private List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties;

	//bi-directional many-to-one association to IfcBuildingStoreyWindowStyle
	@OneToMany(mappedBy="ifcBuildingStoreyWindow")
	private List<IfcBuildingStoreyWindowStyle> ifcBuildingStoreyWindowStyles;

	public IfcBuildingStoreyWindow() {
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

	public String getOverallHeight() {
		return this.overallHeight;
	}

	public void setOverallHeight(String overallHeight) {
		this.overallHeight = overallHeight;
	}

	public String getOverallWidth() {
		return this.overallWidth;
	}

	public void setOverallWidth(String overallWidth) {
		this.overallWidth = overallWidth;
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

	public String getWindowName() {
		return this.windowName;
	}

	public void setWindowName(String windowName) {
		this.windowName = windowName;
	}

	public IfcBuildingStorey getIfcBuildingStorey() {
		return this.ifcBuildingStorey;
	}

	public void setIfcBuildingStorey(IfcBuildingStorey ifcBuildingStorey) {
		this.ifcBuildingStorey = ifcBuildingStorey;
	}

	public List<IfcBuildingStoreyWindowPresentationlayer> getIfcBuildingStoreyWindowPresentationlayers() {
		return this.ifcBuildingStoreyWindowPresentationlayers;
	}

	public void setIfcBuildingStoreyWindowPresentationlayers(List<IfcBuildingStoreyWindowPresentationlayer> ifcBuildingStoreyWindowPresentationlayers) {
		this.ifcBuildingStoreyWindowPresentationlayers = ifcBuildingStoreyWindowPresentationlayers;
	}

	public IfcBuildingStoreyWindowPresentationlayer addIfcBuildingStoreyWindowPresentationlayer(IfcBuildingStoreyWindowPresentationlayer ifcBuildingStoreyWindowPresentationlayer) {
		getIfcBuildingStoreyWindowPresentationlayers().add(ifcBuildingStoreyWindowPresentationlayer);
		ifcBuildingStoreyWindowPresentationlayer.setIfcBuildingStoreyWindow(this);

		return ifcBuildingStoreyWindowPresentationlayer;
	}

	public IfcBuildingStoreyWindowPresentationlayer removeIfcBuildingStoreyWindowPresentationlayer(IfcBuildingStoreyWindowPresentationlayer ifcBuildingStoreyWindowPresentationlayer) {
		getIfcBuildingStoreyWindowPresentationlayers().remove(ifcBuildingStoreyWindowPresentationlayer);
		ifcBuildingStoreyWindowPresentationlayer.setIfcBuildingStoreyWindow(null);

		return ifcBuildingStoreyWindowPresentationlayer;
	}

	public List<IfcBuildingStoreyWindowProperty> getIfcBuildingStoreyWindowProperties() {
		return this.ifcBuildingStoreyWindowProperties;
	}

	public void setIfcBuildingStoreyWindowProperties(List<IfcBuildingStoreyWindowProperty> ifcBuildingStoreyWindowProperties) {
		this.ifcBuildingStoreyWindowProperties = ifcBuildingStoreyWindowProperties;
	}

	public IfcBuildingStoreyWindowProperty addIfcBuildingStoreyWindowProperty(IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
		getIfcBuildingStoreyWindowProperties().add(ifcBuildingStoreyWindowProperty);
		ifcBuildingStoreyWindowProperty.setIfcBuildingStoreyWindow(this);

		return ifcBuildingStoreyWindowProperty;
	}

	public IfcBuildingStoreyWindowProperty removeIfcBuildingStoreyWindowProperty(IfcBuildingStoreyWindowProperty ifcBuildingStoreyWindowProperty) {
		getIfcBuildingStoreyWindowProperties().remove(ifcBuildingStoreyWindowProperty);
		ifcBuildingStoreyWindowProperty.setIfcBuildingStoreyWindow(null);

		return ifcBuildingStoreyWindowProperty;
	}

	public List<IfcBuildingStoreyWindowStyle> getIfcBuildingStoreyWindowStyles() {
		return this.ifcBuildingStoreyWindowStyles;
	}

	public void setIfcBuildingStoreyWindowStyles(List<IfcBuildingStoreyWindowStyle> ifcBuildingStoreyWindowStyles) {
		this.ifcBuildingStoreyWindowStyles = ifcBuildingStoreyWindowStyles;
	}

	public IfcBuildingStoreyWindowStyle addIfcBuildingStoreyWindowStyle(IfcBuildingStoreyWindowStyle ifcBuildingStoreyWindowStyle) {
		getIfcBuildingStoreyWindowStyles().add(ifcBuildingStoreyWindowStyle);
		ifcBuildingStoreyWindowStyle.setIfcBuildingStoreyWindow(this);

		return ifcBuildingStoreyWindowStyle;
	}

	public IfcBuildingStoreyWindowStyle removeIfcBuildingStoreyWindowStyle(IfcBuildingStoreyWindowStyle ifcBuildingStoreyWindowStyle) {
		getIfcBuildingStoreyWindowStyles().remove(ifcBuildingStoreyWindowStyle);
		ifcBuildingStoreyWindowStyle.setIfcBuildingStoreyWindow(null);

		return ifcBuildingStoreyWindowStyle;
	}

}