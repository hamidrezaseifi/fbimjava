package com.futurebim.core.bl.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.futurebim.core.bl.IProjectUserHandler;
import com.futurebim.core.dao.ProjectUserDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.model.ProjectUser;

@Service
public class ProjectUserHandler implements IProjectUserHandler {
  
  @Autowired
  ProjectUserDao projectUserDao;

  @Override
  public ProjectUser save(final ProjectUser projectUser) throws StorageException {
    return projectUserDao.add(projectUser);
  }

  @Override
  public boolean remove(final ProjectUser projectUser) throws StorageException {
    return projectUserDao.remove(projectUser);
  }
  
  @Override
  public List<ProjectUser> listByProject(final Long projectId) throws StorageException {
    return projectUserDao.listByProject(projectId);
  }
  
  @Override
  public List<ProjectUser> listByUser(final Long userId) throws StorageException {
    return projectUserDao.listByUser(userId);
  }
  
}
