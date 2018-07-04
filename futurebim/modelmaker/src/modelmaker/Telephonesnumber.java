package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the telephonesnumbers database table.
 * 
 */
@Entity
@Table(name="telephonesnumbers")
@NamedQuery(name="Telephonesnumber.findAll", query="SELECT t FROM Telephonesnumber t")
public class Telephonesnumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private TelephonesnumberPK id;

	@Column(name="city_code")
	private String cityCode;

	private String comments;

	@Column(name="country_code")
	private String countryCode;

	private Timestamp created;

	private String subscriber;

	@Column(name="telephone_name")
	private String telephoneName;

	private Timestamp updated;

	private int version;

	public Telephonesnumber() {
	}

	public TelephonesnumberPK getId() {
		return this.id;
	}

	public void setId(TelephonesnumberPK id) {
		this.id = id;
	}

	public String getCityCode() {
		return this.cityCode;
	}

	public void setCityCode(String cityCode) {
		this.cityCode = cityCode;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getSubscriber() {
		return this.subscriber;
	}

	public void setSubscriber(String subscriber) {
		this.subscriber = subscriber;
	}

	public String getTelephoneName() {
		return this.telephoneName;
	}

	public void setTelephoneName(String telephoneName) {
		this.telephoneName = telephoneName;
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

}