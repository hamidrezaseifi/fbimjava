package com.futurebim.core.model;

import java.io.Serializable;
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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.futurebim.common.models.edo.CompanyEdo;
import com.futurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the companies database table.
 * 
 */
@Entity
@Table(name="companies")
public class CompanyReference extends SerializableModelBase {
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

  public CompanyReference() {
  }

  public CompanyReference(final CompanyEdo edo) {
    this.setId(edo.getId());
    this.setCompanyName(edo.getCompanyName());
    this.setComments(edo.getComments());
    this.setCreated(edo.getCreated());
    this.setStatus(edo.getStatus());
    this.setUpdated(edo.getUpdated());
    this.setVersion(edo.getVersion());
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

	public int getStatus() {
		return this.status;
	}

	public void setStatus(final int status) {
		this.status = status;
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

  @Override
	public String toString(){
		return "id="+id+", name="+companyName+", updated="+updated;
	}

}