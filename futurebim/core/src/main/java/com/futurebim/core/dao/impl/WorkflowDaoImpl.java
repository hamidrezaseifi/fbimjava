package com.futurebim.core.dao.impl;

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

import com.futurebim.core.dao.WorkflowDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.dao.utils.SqlUtils;
import com.futurebim.core.model.CheckVersion;
import com.futurebim.core.model.Workflow;

@Transactional
@Repository
public class WorkflowDaoImpl implements WorkflowDao {
  
  private static final Logger              logger = LoggerFactory.getLogger(WorkflowDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  @Autowired
  WorkflowDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }
  
  @Override
  public Workflow addNew(final Workflow workflow) throws StorageException {
    logger.debug("insert Workflow {}...", workflow.getName());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder         keyHolder         = new GeneratedKeyHolder();
    
    try {
      
      final String sql = "INSERT INTO workflow (project_id, workflow_type, name, reporter, responsible, version, status)" + "VALUES (?, ?, ?, ?, ?, ?, ?)";
      
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, workflow.getProjectid());
        ps.setInt(2, workflow.getType());
        ps.setString(3, workflow.getName());
        ps.setLong(4, workflow.getReporter());
        ps.setLong(5, workflow.getResponsible());
        ps.setInt(6, workflow.getVersion());
        ps.setInt(7, workflow.getStatus());
        
        return ps;
      }, keyHolder);
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Workflow [name: {}]: {}", workflow.getName(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(keyHolder.getKey().longValue());
  }
  
  @Override
  public Workflow getById(final Long id) throws StorageException {
    logger.info("Dao Read Project by id: " + id);
    final String sqlSelect = "SELECT * FROM workflow where id=?";
    
    Workflow workflow;
    
    try {
      
      workflow = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;
        
      }, (rs) -> {
        if (rs.next()) {
          return workflowFromResultSet(rs);
        }
        else {
          return null;
        }
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Project data: " + e.toString());
    }
    
    return workflow;
  }
  
  @Override
  public List<Workflow> list(final Long projectId) throws StorageException {
    logger.info("Dao Read Project Workflow List");
    final String sqlSelect = "SELECT * FROM workflow where project_id=?";
    
    List<Workflow> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, projectId);
        return ps;
        
      }, (rs, rowNum) -> {
        
        return workflowFromResultSet(rs);
        
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project Workflow: " + e.toString());
    }
    
    return list;
  }
  
  @Override
  public Workflow update(final Workflow workflow) throws StorageException {
    logger.debug("Updating Project with id {}...", workflow.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "UPDATE workflow SET project_id = ?, workflow_type = ?, name = ?, reporter = ?," +
                                                                                                                                                              " responsible = ?, version = ? ,status = ? WHERE id = ?";
      
      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, workflow.getProjectid());
        ps.setInt(2, workflow.getType());
        ps.setString(3, workflow.getName());
        ps.setLong(4, workflow.getReporter());
        ps.setLong(5, workflow.getResponsible());
        ps.setInt(6, workflow.getVersion());
        ps.setInt(7, workflow.getStatus());
        ps.setLong(8, workflow.getId());
        
        return ps;
      });
      
      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update Project [id: {}]", workflow.getId()));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update Project [id: {}]: {}", workflow.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(workflow.getId());
  }
  
  @Override
  public boolean delete(final Workflow workflow) throws StorageException {
    logger.debug("Deleting Workflow with id {}...", workflow.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "delete from workflow where id = ? ";

      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, workflow.getId());
        return ps;
      });

      if (deletedRows != 1) {
        throw new StorageException(String.format("Unable to delete Project  [id: {}]", workflow.getId()));
      }

      this.platformTransactionManager.commit(transactionStatus);
      return true;
    }

    catch (final Exception e) {
      this.platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to delete Workflow [id: {}]: {}", workflow.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
  }
  
  private Workflow workflowFromResultSet(final ResultSet rs) throws SQLException {
    final Workflow model = new Workflow();
    
    model.setResponsible(rs.getLong("responsible"));
    model.setType(rs.getInt("workflow_type"));
    model.setName(rs.getString("name"));
    model.setProjectid(rs.getLong("project_id"));
    model.setReporter(rs.getLong("reporter"));
    model.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    model.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));
    model.setId(rs.getLong("id"));
    model.setVersion(rs.getInt("version"));
    model.setStatus(rs.getInt("status"));
    
    return model;
  }
  
  @Override
  public CheckVersion checkWorkflowVersion(final CheckVersion checkingWorkflow) {
    logger.info("Dao Read Workflow version List");
    final String sqlSelect = "SELECT * FROM workflow where id=?";
    
    CheckVersion checkWorkflow = new CheckVersion();

    try {
      
      checkWorkflow = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, checkingWorkflow.getId());
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return workflowCheckVersionFromResultSet(rs);
        }
        else {
          throw new StorageException("Unable to retrieve workflow data for id: " + checkingWorkflow.getId());
        }
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve workflow data: " + e.toString());
    }

    return checkWorkflow;
  }
  
  private CheckVersion workflowCheckVersionFromResultSet(final ResultSet rs) throws SQLException {
    final CheckVersion ver = new CheckVersion();
    ver.setId(rs.getLong("id"));
    ver.setVersion(rs.getInt("version"));

    return ver;
  }
}
