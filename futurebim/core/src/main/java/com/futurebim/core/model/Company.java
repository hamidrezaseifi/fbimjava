package com.futurebim.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
public class Company implements Serializable {
	private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;

	private String comments;

  @Column(name="company_name")
	private String companyName;

  private int status;

	private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = User.class)
  private List<User> users = new ArrayList<>();

  //@JsonIgnore
  @LazyCollection(LazyCollectionOption.FALSE)
  @OneToMany(mappedBy = "companyid", targetEntity = Project.class)
  private List<Project> projects = new ArrayList<>();

	public Company() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getCompanyName() {
		return this.companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public int getStatus() {
		return this.status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

  public List<User> getUsers() {
    return users;
  }

  public void setUsers(List<User> users) {
    this.users = users;
  }
  
  public List<Project> getProjects() {
    return projects;
  }
  
  public void setProjects(List<Project> projects) {
    this.projects = projects;
  }

  @Override
	public String toString(){
		return "id="+id+", name="+companyName+", updated="+updated;
	}

}