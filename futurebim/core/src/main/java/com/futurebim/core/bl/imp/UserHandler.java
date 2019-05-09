package com.futurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.futurebim.common.exceptions.EExceptionType;
import com.futurebim.common.exceptions.FBCustomizedException;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.core.bl.IUserHandler;
import com.futurebim.core.dao.CompanyDao;
import com.futurebim.core.dao.ProjectDao;
import com.futurebim.core.dao.UserDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.Company;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.User;
import com.futurebim.core.model.UserFull;

@Service
public class UserHandler implements IUserHandler {

	private final UserDao userDao;

	private final CompanyDao companyDao;

	private final ProjectDao projectDao;

	private final PasswordEncoder passwordEncoder;

	private static final String DEFAULT_PASSWORD = "123456";

	public UserHandler(@Autowired final UserDao userDao, @Autowired final PasswordEncoder passwordEncoder,
			@Autowired final CompanyDao companyDao, final ProjectDao projectDao) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
		this.companyDao = companyDao;
		this.projectDao = projectDao;
	}

	@Override
	public UserFull saveUser(final UserFull user) throws StorageException {
		if (user.isNew()) {
			user.setVersion(1);
			user.setHashPassword(passwordEncoder.encode(DEFAULT_PASSWORD));
			return prepareUser(userDao.addUser(user));
		} else {
			checkRecordVersion(user.getId(), user.getVersion());
			user.setVersion(user.getVersion() + 1);
			return prepareUser(userDao.updateUser(user));
		}

	}

	@Override
	public boolean removeUser(final UserFull user) throws StorageException {
		if (!user.getIsDeletable()) {
			throw new FBCustomizedException(EExceptionType.UserIsNotDeleteable.name(), "",
					EModule.CORE.getModuleName());
		}

		return userDao.removeUser(user.getId());
	}

	@Override
	public UserFull getById(final Long id) throws StorageException {
		return prepareUser(userDao.getById(id));
	}

	@Override
	public UserFull getByUsername(final String companyIdent, final String username) throws StorageException {
		return prepareUser(userDao.getByUsername(companyIdent, username));
	}

	@Override
	public List<UserFull> listUsers() throws StorageException {
		return prepareUsers(userDao.listUsers());
	}

	@Override
	public List<UserFull> listCompanyUsers(final Long companyId) throws StorageException {
		return prepareUsers(userDao.listCompanyUsers(companyId));
	}

	@Override
	public UserFull authenticateUser(final String companyIdent, final String username, final String password)
			throws StorageException {

		final UserFull fUser = getByUsername(companyIdent, username);

		if (fUser != null && passwordEncoder.matches(password, fUser.getHashPassword())) {
			return prepareUser(fUser);
		}
		return null;
	}

	@Override
	public boolean setUserPassword(final User user, final String password) throws StorageException {

		checkRecordVersion(user.getId(), user.getVersion());

		return userDao.setUserPassword(user.getId(), passwordEncoder.encode(password));
	}

	private boolean checkRecordVersion(final long userId, final int version) throws StorageException {
		final UserFull existsUser = userDao.getById(userId);
		if (existsUser.getVersion() > version) {
			throw new FBCustomizedException(EExceptionType.VersionMismatch.name(), "", EModule.CORE.getModuleName());
		}

		return true;
	}

	private List<UserFull> prepareUsers(final List<UserFull> users) {
		users.forEach(u -> prepareUser(u));

		return users;
	}

	private UserFull prepareUser(final UserFull user) {
		final Company company = companyDao.getById(user.getCompanyid());
		user.setIsContactPerson(company.getContactPersons().contains(user.getId()));

		final List<Project> respProject = projectDao.listProjectsResponsibleBy(user.getId());

		/*
		 * project_comments userid project_responsible userid task reporter task
		 * assigned_to team created_by team leader team_member created_by team_member
		 * userid user_project_access user_project_roles user_roles workflow reporter
		 * workflow responsible
		 *
		 */

		user.setIsDeletable(user.getIsDeletable() && respProject.isEmpty());
		user.setIsDeletable(user.getIsDeletable() && !user.getIsContactPerson());

		return user;
	}

}
