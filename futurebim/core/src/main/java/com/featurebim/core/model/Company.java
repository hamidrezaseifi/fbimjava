package com.featurebim.core.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import com.featurebim.common.model.edo.CompanyEdo;
import com.featurebim.common.model.enums.EStatus;
import com.featurebim.core.model.base.SerializableModelBase;

/**
 * The persistent class for the companies database table.
 *
 */
public class Company extends SerializableModelBase {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String comments;

  private String companyName;

  private EStatus status;

  private int version;

  private LocalDateTime created;

  private LocalDateTime updated;

  public Company() {
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

  public void setStatus(final Long status) {
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

  @Override
  public String toString() {
    return "id=" + id + ", name=" + companyName + ", updated=" + updated;
  }

  public CompanyEdo toEdo() {
    final CompanyEdo edo = new CompanyEdo();
    edo.setComments(comments);
    edo.setCompanyName(companyName);
    edo.setCreated(created);
    edo.setId(id);
    edo.setStatus(status.getDbId());
    edo.setUpdated(updated);
    edo.setVersion(version);

    return edo;
  }

  public static List<CompanyEdo> toEdoList(final List<Company> list) {

    final List<CompanyEdo> edoList = new ArrayList<>();
    for (final Company p : list) {
      edoList.add(p.toEdo());
    }
    return edoList;
  }
}
