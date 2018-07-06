package modelmaker;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.TIMESTAMP)
	private Date birthday;

	private Timestamp created;

	private String email;

	private String firstname;

	private short gender;

	@Column(name="hash_password")
	private String hashPassword;

	private String lastname;

	@Column(name="name_tag")
	private String nameTag;

	private short status;

	private Timestamp updated;

	private String username;

	private int version;

	//bi-directional many-to-many association to Company
	@ManyToMany
	@JoinTable(
		name="company_contact_person"
		, joinColumns={
			@JoinColumn(name="userid")
			}
		, inverseJoinColumns={
			@JoinColumn(name="companyid")
			}
		)
	private List<Company> companies;

	//bi-directional many-to-one association to ProjectResponsible
	@OneToMany(mappedBy="user")
	private List<ProjectResponsible> projectResponsibles;

	//bi-directional many-to-one association to UserProjectAccess
	@OneToMany(mappedBy="user")
	private List<UserProjectAccess> userProjectAccesses;

	//bi-directional many-to-one association to Company
	@ManyToOne
	@JoinColumn(name="companyid")
	private Company company;

	public User() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Timestamp getCreated() {
		return this.created;
	}

	public void setCreated(Timestamp created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public short getGender() {
		return this.gender;
	}

	public void setGender(short gender) {
		this.gender = gender;
	}

	public String getHashPassword() {
		return this.hashPassword;
	}

	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getNameTag() {
		return this.nameTag;
	}

	public void setNameTag(String nameTag) {
		this.nameTag = nameTag;
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

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Company> getCompanies() {
		return this.companies;
	}

	public void setCompanies(List<Company> companies) {
		this.companies = companies;
	}

	public List<ProjectResponsible> getProjectResponsibles() {
		return this.projectResponsibles;
	}

	public void setProjectResponsibles(List<ProjectResponsible> projectResponsibles) {
		this.projectResponsibles = projectResponsibles;
	}

	public ProjectResponsible addProjectResponsible(ProjectResponsible projectResponsible) {
		getProjectResponsibles().add(projectResponsible);
		projectResponsible.setUser(this);

		return projectResponsible;
	}

	public ProjectResponsible removeProjectResponsible(ProjectResponsible projectResponsible) {
		getProjectResponsibles().remove(projectResponsible);
		projectResponsible.setUser(null);

		return projectResponsible;
	}

	public List<UserProjectAccess> getUserProjectAccesses() {
		return this.userProjectAccesses;
	}

	public void setUserProjectAccesses(List<UserProjectAccess> userProjectAccesses) {
		this.userProjectAccesses = userProjectAccesses;
	}

	public UserProjectAccess addUserProjectAccess(UserProjectAccess userProjectAccess) {
		getUserProjectAccesses().add(userProjectAccess);
		userProjectAccess.setUser(this);

		return userProjectAccess;
	}

	public UserProjectAccess removeUserProjectAccess(UserProjectAccess userProjectAccess) {
		getUserProjectAccesses().remove(userProjectAccess);
		userProjectAccess.setUser(null);

		return userProjectAccess;
	}

	public Company getCompany() {
		return this.company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

}