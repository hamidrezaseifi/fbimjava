package com.futurebim.core.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.futurebim.core.dao.ProjectDao;
import com.futurebim.core.model.Project;
import com.futurebim.core.model.ProjectRich;

@Transactional
@Repository
@Qualifier("ProjectDaoImpl")
public class ProjectDaoImpl implements ProjectDao {

  private static final Logger logger = LoggerFactory.getLogger(ProjectDaoImpl.class);

  @Autowired
  private SessionFactory sessionFactory;

  @Override
  public ProjectRich addProject(final ProjectRich c) {
    final Session session = this.sessionFactory.getCurrentSession();
    final Long id = (Long) session.save(c);
    logger.info("Project saved successfully, Project Details=" + c);
    return getById(id);
  }

  @Override
  public boolean updateProject(final ProjectRich c) {
    final Session session = this.sessionFactory.getCurrentSession();
    final Project uc = (Project) session.merge(c);
    logger.info("Project updated successfully, Project Details=" + c);
    return uc != null;
  }

  @Override
  public boolean removeProject(final Long id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final Project c = session.get(Project.class, id);

    if (null != c) {
      session.delete(c);
      logger.info("Project deleted successfully, Project details=" + c);
    }
    else {
      logger.info("Project not found!");
      return false;
    }

    return session.get(Project.class, id) == null;
  }

  @Override
  public ProjectRich getById(final Long id) {
    final Session session = this.sessionFactory.getCurrentSession();
    final ProjectRich c = session.get(ProjectRich.class, id);
    if (c != null) {
      logger.info("Project loaded successfully, Project details=" + c);
    }
    else {
      logger.info("Project not found!");
    }

    return c;
  }

  @SuppressWarnings("unchecked")
  @Override
  public List<ProjectRich> listProjects(final Long companyId) {
    logger.info("Read Project List");
    final Session session = this.sessionFactory.getCurrentSession();

    final Query<ProjectRich> query = session.createQuery("from ProjectRich where companyid = :cid ");
    query.setParameter("cid", companyId);
    final List<ProjectRich> list = query.list();

    return list;
  }

}
