package com.futurebim.core.dao;

import java.util.List;

import com.futurebim.core.model.UserRich;

public interface UserDao {

  public UserRich addUser(UserRich c);

  public boolean updateUser(UserRich c);

  public boolean removeUser(Long id);

  public UserRich getById(Long id);

  public List<UserRich> listUsers();

}
