package com.featurebim.common.model.edo;

import java.util.List;

public class UserFullCollectionEdo {

	List<UserFullEdo> users;

	public UserFullCollectionEdo() {

	}

	public UserFullCollectionEdo(final List<UserFullEdo> users) {
		setUsers(users);
	}

	/**
	 * @return the users
	 */
	public List<UserFullEdo> getUsers() {
		return users;
	}

	/**
	 * @param users the users to set
	 */
	public void setUsers(final List<UserFullEdo> users) {
		this.users = users;
	}

}
