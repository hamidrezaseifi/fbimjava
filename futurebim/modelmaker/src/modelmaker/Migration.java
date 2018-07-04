package modelmaker;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the migration database table.
 * 
 */
@Entity
@NamedQuery(name="Migration.findAll", query="SELECT m FROM Migration m")
public class Migration implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String version;

	@Column(name="apply_time")
	private int applyTime;

	public Migration() {
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public int getApplyTime() {
		return this.applyTime;
	}

	public void setApplyTime(int applyTime) {
		this.applyTime = applyTime;
	}

}