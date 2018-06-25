package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.User;

public interface UserDao {

	public User addUser(User c);
	public boolean updateUser(User c);
	public boolean removeUser(Long id);
	public User getById(Long id);
	public List<User> listUsers();
	
}
