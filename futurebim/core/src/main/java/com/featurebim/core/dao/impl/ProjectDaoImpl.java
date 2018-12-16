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
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.featurebim.core.dao.ProjectDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.dao.utils.SqlUtils;
import com.featurebim.core.model.Project;

@Transactional
@Repository
@Qualifier("ProjectDaoImpl")
public class ProjectDaoImpl implements ProjectDao {
  
  private static final Logger              logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;
  
  @Autowired
  ProjectDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }
  
  @Override
  public Project addProject(final Project project) throws StorageException {
    logger.debug("Updating Project with id {}...", project.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();
    
    try {
      
      final String sql = "INSERT INTO projects (companyid, parent_project, type, project_name, start_date, deadline, version, status)"
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
      
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, project.getCompanyid());
        ps.setLong(2, project.getParentProjectId());
        ps.setInt(3, project.getProjectType());
        ps.setString(4, project.getProjectName());
        ps.setTimestamp(5, SqlUtils.getTimestampFromDate(project.getStartDate()));
        ps.setTimestamp(6, SqlUtils.getTimestampFromDate(project.getDeadline()));
        ps.setInt(7, project.getVersion());
        ps.setInt(8, project.getStatus());
        
        return ps;
      }, keyHolder);
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Project [name: {}]: {}", project.getProjectName(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(keyHolder.getKey().longValue());
  }
  
  @Override
  public Project updateProject(final Project project) throws StorageException {
    logger.debug("Updating Project with id {}...", project.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "UPDATE projects SET companyid = ?, parent_project = ?, type = ?, project_name = ?," +
          " start_date = ?, deadline = ?, version = ?, status = ? WHERE id = ?";
      
      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, project.getCompanyid());
        ps.setLong(2, project.getParentProjectId());
        ps.setInt(3, project.getProjectType());
        ps.setString(4, project.getProjectName());
        ps.setTimestamp(5, SqlUtils.getTimestampFromDate(project.getStartDate()));
        ps.setTimestamp(6, SqlUtils.getTimestampFromDate(project.getDeadline()));
        ps.setInt(7, project.getVersion());
        ps.setInt(8, project.getStatus());
        ps.setLong(9, project.getId());
        
        return ps;
      });
      
      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update Project [id: {}]", project.getId()));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update Project [id: {}]: {}", project.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(project.getId());
  }
  
  @Override
  public boolean removeProject(final Long id) throws StorageException {
    logger.debug("Deleting Project with id {}...", id);
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "delete from projects where id = ? ";
      //@formatter:on
      
      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, id);
        return ps;
      });
      
      if (deletedRows != 1) {
        throw new StorageException(String.format("Unable to delete Project  [id: {}]", id));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
      return true;
    }
    
    catch (final Exception e) {
      this.platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to delete Project [id: {}]: {}", id, e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
  }
  
  @Override
  public Project getById(final Long id) throws StorageException {
    logger.info("Dao Read Project by id: " + id);
    final String sqlSelect = "SELECT * FROM projects where id=?";
    
    Project project;
    
    try {
      
      project = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;
        
      }, (rs) -> {
        if (rs.next()) {
          return projectFromResultSet(rs);
        }
        else {
          return null;
        }
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Project data: " + e.toString());
    }
    
    return project;
  }
  
  @Override
  public List<Project> listProjects(final Long companyId) throws StorageException {
    logger.info("Dao Read Project List");
    final String sqlSelect = "SELECT * FROM projects where companyid=?";
    
    List<Project> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return projectFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project: " + e.toString());
    }
    
    return list;
  }
  
  private Project projectFromResultSet(final ResultSet rs) throws SQLException {
    final Project project = new Project();
    project.setCompanyid(rs.getLong("companyid"));
    project.setParentProjectId(rs.getLong("parent_project"));
    project.setVersion(rs.getInt("version"));
    project.setProjectType(rs.getInt("type"));
    project.setStartDate(SqlUtils.getDateFromTimestamp(rs.getTimestamp("start_date")));
    project.setDeadline(SqlUtils.getDateFromTimestamp(rs.getTimestamp("deadline")));
    project.setProjectName(rs.getString("project_name"));
    project.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    project.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));
    project.setId(rs.getLong("id"));
    project.setVersion(rs.getInt("version"));
    project.setStatus(rs.getInt("status"));
    
    return project;
  }
}
