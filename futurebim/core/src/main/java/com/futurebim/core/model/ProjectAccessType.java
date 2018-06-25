package com.futurebim.core.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import com.futurebim.core.model.base.SerializableModelBase;
import com.futurebim.core.model.enums.EStatus;
import com.futurebim.core.model.enums.base.UnknownEnumValueException;


/**
 * The persistent class for the project_access_type database table.
 * 
 */
@Entity
@Table(name="project_access_type")
public class ProjectAccessType extends SerializableModelBase {
	private static final long serialVersionUID = 1L;

  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private LocalDateTime created;

	private EStatus status;

	private String typeName;

	private LocalDateTime updated;

	//private List<UserProjectAccess> userProjectAccesses;

	public ProjectAccessType() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public EStatus getStatus() {
		return this.status;
	}

	public void setStatus(Long status) throws UnknownEnumValueException {
		this.status = EStatus.ofId(status);
	}

	public String getTypeName() {
		return this.typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	/*public List<UserProjectAccess> getUserProjectAccesses() {
		return this.userProjectAccesses;
	}

	public void setUserProjectAccesses(List<UserProjectAccess> userProjectAccesses) {
		this.userProjectAccesses = userProjectAccesses;
	}

	public UserProjectAccess addUserProjectAccess(UserProjectAccess userProjectAccess) {
		getUserProjectAccesses().add(userProjectAccess);
		userProjectAccess.setProjectAccessType(this);

		return userProjectAccess;
	}

	public UserProjectAccess removeUserProjectAccess(UserProjectAccess userProjectAccess) {
		getUserProjectAccesses().remove(userProjectAccess);
		userProjectAccess.setProjectAccessType(null);

		return userProjectAccess;
	}*/

}