package com.futurebim.gui.bl.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.futurebim.common.model.edo.EncryptedContentEdo;
import com.futurebim.common.model.edo.FBCollectionEdo;
import com.futurebim.common.model.edo.UserFullEdo;
import com.futurebim.common.model.edo.UserLoginEdo;
import com.futurebim.common.model.edo.UserPasswordEdo;
import com.futurebim.common.model.enums.EModule;
import com.futurebim.gui.bl.IUserHandler;
import com.futurebim.gui.configuration.UiConfiguration;
import com.futurebim.gui.helper.IUiRestTemplateCall;
import com.futurebim.gui.helper.MessagesHelper;
import com.futurebim.gui.model.futurebim.GuiUserFull;

@Service
public class UserHandler implements IUserHandler {

	private final Logger logger = LoggerFactory.getLogger(UserHandler.class);

	@Autowired
	private MessagesHelper messages;

	@Autowired
	private UiConfiguration.CoreAccessConfig coreAccessConfig;

	@Autowired
	private IUiRestTemplateCall restTemplateCall;

	@Autowired
	private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter;

	@Override
	public GuiUserFull authenticateUser(final String username, final String password, final String companyIdent) {

		logger.debug("get projects list from core");

		final UserLoginEdo loginEdo = new UserLoginEdo(username, password, companyIdent);
		final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();

		try {
			encrypedEdo.setContentObject(loginEdo, mappingJackson2HttpMessageConverter.getObjectMapper());
		} catch (final Exception e) {
			return null;
		}

		final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserAuthenticate(),
				EModule.CORE, encrypedEdo, EncryptedContentEdo.class, true);

		try {
			final UserFullEdo userEdo = encrypedResEdo.getObjectContent(UserFullEdo.class,
					mappingJackson2HttpMessageConverter.getObjectMapper());
			return prepareUser(GuiUserFull.fromEdo(userEdo));
		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public GuiUserFull saveUser(final GuiUserFull user) {
		final UserFullEdo edo = user.toEdo();
		final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();

		try {
			encrypedEdo.setContentObject(edo, mappingJackson2HttpMessageConverter.getObjectMapper());

			final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserSave(),
					EModule.CORE, encrypedEdo, EncryptedContentEdo.class, true);
			final UserFullEdo userEdo = encrypedResEdo.getObjectContent(UserFullEdo.class,
					mappingJackson2HttpMessageConverter.getObjectMapper());
			return prepareUser(GuiUserFull.fromEdo(userEdo));

		} catch (final Exception e) {
			return null;
		}

	}

	@Override
	public GuiUserFull saveUserPassword(final GuiUserFull user, final String password) {
		UserFullEdo userEdo = user.toEdo();

		final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();

		try {
			encrypedEdo.setContentObject(userEdo, mappingJackson2HttpMessageConverter.getObjectMapper());

			final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestPost(coreAccessConfig.getUserSave(),
					EModule.CORE, encrypedEdo, EncryptedContentEdo.class, true);

			userEdo = encrypedResEdo.getObjectContent(UserFullEdo.class,
					mappingJackson2HttpMessageConverter.getObjectMapper());

			final UserPasswordEdo edoPassword = new UserPasswordEdo();
			edoPassword.setPassword(password);
			edoPassword.setUser(GuiUserFull.fromEdo(userEdo).toUser().toEdo());
			encrypedEdo.setContentObject(edoPassword, mappingJackson2HttpMessageConverter.getObjectMapper());

			restTemplateCall.callRestPost(coreAccessConfig.getUserSetPassword(), EModule.CORE, encrypedEdo, Void.class,
					true);

			return prepareUser(GuiUserFull.fromEdo(userEdo));

		} catch (final Exception e) {
			return null;
		}

	}

	@Override
	public List<GuiUserFull> getCompanyUsers(final Long companyId) {
		logger.debug("get user list for company from core");

		final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestGet(
				coreAccessConfig.getUserCompanyUserList(), EModule.CORE, EncryptedContentEdo.class, true, companyId);
		try {

			final TypeReference<FBCollectionEdo<UserFullEdo>> typeRef = new TypeReference<FBCollectionEdo<UserFullEdo>>() {
			};

			final FBCollectionEdo<UserFullEdo> edoCollection = encrypedResEdo.getObjectContent(typeRef,
					mappingJackson2HttpMessageConverter.getObjectMapper());
			return prepareUserList(GuiUserFull.fromEdoList(edoCollection.getItems()));
		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public GuiUserFull getById(final Long userId) {

		try {

			final EncryptedContentEdo encrypedResEdo = restTemplateCall.callRestGet(coreAccessConfig.getUserReadUrl(),
					EModule.CORE, EncryptedContentEdo.class, true, userId);
			final UserFullEdo userEdo = encrypedResEdo.getObjectContent(UserFullEdo.class,
					mappingJackson2HttpMessageConverter.getObjectMapper());
			return prepareUser(GuiUserFull.fromEdo(userEdo));

		} catch (final Exception e) {
			return null;
		}
	}

	@Override
	public GuiUserFull prepareUser(final GuiUserFull user) {
		user.setStatusName(getStatusName(user.getStatus()));
		user.setGenderName(getGenderName(user.getGender()));
		return user;
	}

	@Override
	public List<GuiUserFull> prepareUserList(final List<GuiUserFull> list) {

		list.forEach(u -> prepareUser(u));
		return list;
	}

	@Override
	public String getStatusName(final int status) {

		switch (status) {
		case 1:
			return messages.get("user.status-active");
		case 2:
			return messages.get("user.status-deactive");
		case 3:
			return messages.get("user.status-deleted");
		case 4:
			return messages.get("user.status-notinitialize");
		}

		return messages.get("common.unknown");
	}

	@Override
	public String getGenderName(final int gender) {

		switch (gender) {
		case 1:
			return messages.get("user.genderman");
		case 2:
			return messages.get("user.genderwoman");
		case 3:
			return messages.get("user.genderinter");
		}

		return messages.get("common.unknown");
	}

	@Override
	public Map<Integer, String> getStatusMap() {
		final Map<Integer, String> map = new HashMap<>();

		map.put(1, messages.get("user.status-active"));
		map.put(2, messages.get("user.status-deactive"));
		map.put(3, messages.get("user.status-deleted"));
		map.put(4, messages.get("user.status-notinitialize"));

		return map;
	}

	@Override
	public Map<Integer, String> getGenderMap() {
		final Map<Integer, String> map = new HashMap<>();

		map.put(1, messages.get("user.genderman"));
		map.put(2, messages.get("user.genderwoman"));
		map.put(3, messages.get("user.genderinter"));

		return map;
	}

	@Override
	public boolean deleteUser(final GuiUserFull user) {
		final UserFullEdo edo = user.toEdo();
		final EncryptedContentEdo encrypedEdo = new EncryptedContentEdo();

		try {
			encrypedEdo.setContentObject(edo, mappingJackson2HttpMessageConverter.getObjectMapper());

			restTemplateCall.callRestPost(coreAccessConfig.getUserDelete(), EModule.CORE, encrypedEdo,
					EncryptedContentEdo.class, true);

			return true;
		} catch (final Exception ex) {
			return false;
		}
	}

	@Override
	public boolean isUserDeletable() {

		return false;
	}

}
