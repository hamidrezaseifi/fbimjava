package com.futurebim.gui.model.futurebim;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.futurebim.common.model.edo.UserFullEdo;
import com.futurebim.gui.model.enums.EGuiUserStatus;
import com.futurebim.gui.model.ui.enums.EUiUserRole;

/**
 * The persistent class for the users database table.
 *
 */
public class GuiUserFull {

	private Long id;

	private Long companyid;

	private String username;

	private short gender;

	private String genderName;

	private String lastname;

	private String firstname;

	private String nameTag;

	private LocalDate birthdate;

	private String email;

	private Boolean isContactPerson;

	private Boolean isDeletable;

	private int status;

	private String statusName;

	private int version;

	private LocalDateTime created;

	private LocalDateTime updated;

	private final List<EUiUserRole> roles = new ArrayList<>();

	public GuiUserFull() {
	}

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public Long getCompanyid() {
		return this.companyid;
	}

	public void setCompanyid(final Long company) {
		this.companyid = company;
	}

	@JsonFormat(pattern = "dd.MM.yyyy")
	@DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
	public LocalDate getBirthdate() {
		return this.birthdate;
	}

	public void setBirthdate(final LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	public LocalDateTime getCreated() {
		return this.created;
	}

	public void setCreated(final LocalDateTime created) {
		this.created = created;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(final String firstname) {
		this.firstname = firstname;
	}

	public String getFullname() {
		return this.lastname + ", " + this.firstname;
	}

	public short getGender() {
		return this.gender;
	}

	public void setGender(final short gender) {
		this.gender = gender;
	}

	public String getGenderName() {
		return genderName;
	}

	public void setGenderName(final String genderName) {
		this.genderName = genderName;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(final String lastname) {
		this.lastname = lastname;
	}

	public String getNameTag() {
		return this.nameTag;
	}

	public void setNameTag(final String nameTag) {
		this.nameTag = nameTag;
	}

	public int getStatus() {
		return this.status;
	}

	public EGuiUserStatus getStatusEnum() {
		return EGuiUserStatus.fromId(this.status);
	}

	public void setStatus(final int status) {
		this.status = status;
	}

	/**
	 * @return the statusName
	 */
	public String getStatusName() {
		return statusName;
	}

	/**
	 * @param statusName the statusName to set
	 */
	public void setStatusName(final String statusName) {
		this.statusName = statusName;
	}

	public LocalDateTime getUpdated() {
		return this.updated;
	}

	public void setUpdated(final LocalDateTime updated) {
		this.updated = updated;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(final String username) {
		this.username = username;
	}

	public Boolean getIsContactPerson() {
		return isContactPerson;
	}

	public void setIsContactPerson(final Boolean isContactPerson) {
		this.isContactPerson = isContactPerson;
	}

	public Boolean getIsDeletable() {
		return isDeletable;
	}

	public void setIsDeletable(final Boolean isDeletable) {
		this.isDeletable = isDeletable;
	}

	public int getVersion() {
		return this.version;
	}

	public void setVersion(final int version) {
		this.version = version;
	}

	public List<EUiUserRole> getRoles() {
		return roles;
	}

	public void setRoles(final List<Integer> roles) {
		for (final Integer role : roles) {
			this.roles.add(EUiUserRole.ofId(role));
		}

	}

	public void addRole(final EUiUserRole role) {
		this.roles.add(role);

	}

	public List<GrantedAuthority> getAuthorities() {

		final List<GrantedAuthority> list = new ArrayList<>();

		String strRoles = "";

		for (final EUiUserRole role : roles) {
			strRoles += "ROLE_" + role.name() + ",";
		}
		list.addAll(AuthorityUtils.commaSeparatedStringToAuthorityList(strRoles));
		return list;
	}

	public boolean isAdmin() {
		return this.roles.contains(EUiUserRole.ADMIN);
	}

	public GuiUser toUser() {
		final GuiUser user = new GuiUser();
		user.setBirthdate(birthdate);
		user.setCompanyid(companyid);
		user.setEmail(email);
		user.setFirstname(firstname);
		user.setGender(gender);
		user.setLastname(lastname);
		user.setNameTag(nameTag);
		user.setUsername(username);
		user.setIsContactPerson(isContactPerson);
		user.setIsDeletable(isDeletable);

		user.setCreated(created);
		user.setId(id);
		user.setStatus(status);
		user.setUpdated(updated);
		user.setVersion(version);

		return user;
	}

	public UserFullEdo toEdo() {
		final UserFullEdo edo = new UserFullEdo();
		edo.setBirthdate(birthdate);
		edo.setCompanyid(companyid);
		edo.setEmail(email);
		edo.setFirstname(firstname);
		edo.setGender(gender);
		edo.setLastname(lastname);
		edo.setNameTag(nameTag);
		edo.setUsername(username);
		edo.setIsContactPerson(isContactPerson);
		edo.setIsDeletable(isDeletable);

		edo.setCreated(created);
		edo.setId(id);
		edo.setStatus(status);
		edo.setUpdated(updated);
		edo.setVersion(version);

		for (final EUiUserRole role : this.roles) {
			edo.addRole(role.getId());
		}

		return edo;
	}

	public static GuiUserFull fromEdo(final UserFullEdo edo) {
		if (edo == null) {
			return null;
		}

		final GuiUserFull user = new GuiUserFull();

		user.setBirthdate(edo.getBirthdate());
		user.setCompanyid(edo.getCompanyid());
		user.setEmail(edo.getEmail());
		user.setFirstname(edo.getFirstname());
		user.setGender(edo.getGender());
		user.setLastname(edo.getLastname());
		user.setNameTag(edo.getNameTag());
		user.setUsername(edo.getUsername());
		user.setIsContactPerson(edo.getIsContactPerson());
		user.setIsDeletable(edo.getIsDeletable());

		user.setCreated(edo.getCreated());
		user.setId(edo.getId());
		user.setStatus(edo.getStatus());
		user.setUpdated(edo.getUpdated());
		user.setVersion(edo.getVersion());
		user.setRoles(edo.getRoles());

		return user;
	}

	public static List<UserFullEdo> toEdoList(final List<GuiUserFull> list) {

		final List<UserFullEdo> edoList = new ArrayList<>();
		for (final GuiUserFull p : list) {
			edoList.add(p.toEdo());
		}
		return edoList;
	}

	public static List<GuiUserFull> fromEdoList(final List<UserFullEdo> edoList) {

		final List<GuiUserFull> list = new ArrayList<>();
		for (final UserFullEdo edo : edoList) {
			list.add(GuiUserFull.fromEdo(edo));
		}
		return list;
	}

	public static GuiUserFull createNew(final Long companyId, final String username) {
		final GuiUserFull user = new GuiUserFull();

		user.setCompanyid(companyId);
		user.setUsername(username);
		user.setEmail("");
		user.setFirstname("");
		user.setLastname("");
		user.setId(0L);
		user.setStatus(1);
		user.setVersion(1);
		user.setGender((short) 1);
		user.setIsContactPerson(Boolean.FALSE);
		user.setIsDeletable(Boolean.FALSE);
		user.setStatus(EGuiUserStatus.NOT_INITIALIZED.getId());

		return user;
	}
}
