package com.featurebim.core.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.featurebim.core.dao.ProjectUserDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.dao.utils.SqlUtils;
import com.featurebim.core.model.ProjectUser;

@Transactional
@Repository
public class ProjectUserDaoImpl implements ProjectUserDao {
  
  private static final Logger              logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  @Autowired
  public ProjectUserDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }
  
  @Override
  public ProjectUser add(final ProjectUser projectUser) throws StorageException {
    logger.debug("inser Project User with id {} {}  {} ...", projectUser.getProjectId(), projectUser.getUpdated(), projectUser.getRoleId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    remove(projectUser);
    
    try {

      final String sql = "INSERT INTO project_users(project_id, user_id, role_id, access_type) VALUES(?, ?, ?, ?, ?)";

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, projectUser.getProjectId());
        ps.setLong(2, projectUser.getUserId());
        ps.setLong(3, projectUser.getRoleId());
        ps.setInt(4, projectUser.getAccessType());
        
        return ps;
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Project user : {}", e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return projectUser;
  }

  @Override
  public boolean remove(final ProjectUser projectUser) throws StorageException {
    logger.debug("Delete Project User with id {} {}  {} ...", projectUser.getProjectId(), projectUser.getUpdated(), projectUser.getRoleId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {

      final String sql = "DELETE from project_users where project_id=? and user_id=?";

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, projectUser.getProjectId());
        ps.setLong(2, projectUser.getUserId());
        
        return ps;
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to Delete Project user : {}", e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return true;
  }
  
  @Override
  public List<ProjectUser> listByProject(final Long projectId) throws StorageException {
    logger.info("Dao Read Project roles for company List");
    final String sqlSelect = "SELECT * FROM project_users where project_id=?";
    
    List<ProjectUser> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, projectId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return projectuserFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project roles: " + e.toString());
    }
    
    return list;
  }
  
  @Override
  public List<ProjectUser> listByUser(final Long userId) throws StorageException {
    logger.info("Dao Read Project roles for company List");
    final String sqlSelect = "SELECT * FROM project_users where user_id=?";
    
    List<ProjectUser> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, userId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return projectuserFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project roles: " + e.toString());
    }
    
    return list;
  }

  private ProjectUser projectuserFromResultSet(final ResultSet rs) throws SQLException {
    final ProjectUser puser = new ProjectUser();

    puser.setAccessType(rs.getInt("access_type"));
    puser.setProjectId(rs.getLong("project_id"));
    puser.setRoleId(rs.getLong("role_id"));
    puser.setUserId(rs.getLong("user_id"));
    puser.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    puser.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));

    return puser;
  }
}
