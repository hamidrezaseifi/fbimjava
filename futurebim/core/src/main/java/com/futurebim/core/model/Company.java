package com.futurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.futurebim.common.model.edo.CompanyEdo;
import com.futurebim.core.model.base.SerializableModelBase;
import com.futurebim.common.model.enums.EStatus;
import com.futurebim.common.model.enums.base.UnknownEnumValueException;

/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
public class Company extends SerializableModelBase {
	private static final long serialVersionUID = 1L;

	@Id
  	@Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String comments;

	@Column(name="company_name")
	private String companyName;

	private EStatus status;

	private int version;

	private LocalDateTime created;

	private LocalDateTime updated;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = UserReference.class)
  private List<UserReference> users = new ArrayList<>();

  //@JsonIgnore
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = ProjectReference.class)
  private List<ProjectReference> projects = new ArrayList<>();

  public Company() {
  }

	public Company(String name, String comments) {
		this.companyName = name;
		this.comments = comments;
		this.status = EStatus.Active;
		this.created = LocalDateTime.now();
		this.updated = LocalDateTime.now();
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(final String comments) {
		this.comments = comments;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(final String companyName) {
		this.companyName = companyName;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	public EStatus getStatus() {
		return this.status;
	}

	public void setStatus(Long status) throws UnknownEnumValueException {
		this.status = EStatus.ofId(status);
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}


  public List<UserReference> getUsers() {
    return users;
  }

  public void setUsers(final List<UserReference> users) {
    this.users = users;
  }
  
  public List<ProjectReference> getProjects() {
    return projects;
  }
  
  public void setProjects(final List<ProjectReference> projects) {
    this.projects = projects;
  }

	@Override
	public String toString(){
		return "id="+id+", name="+companyName+", updated="+updated;
	}

}