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

import com.featurebim.core.dao.TaskDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.dao.utils.SqlUtils;
import com.featurebim.core.model.Task;

@Transactional
@Repository
public class TaskDaoImpl implements TaskDao {

  private static final Logger              logger = LoggerFactory.getLogger(TaskDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;
  
  @Autowired
  TaskDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }
  
  @Override
  public Task addTask(final Task task) throws StorageException {
    logger.debug("insert Task {}...", task.getName());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder keyHolder = new GeneratedKeyHolder();

    try {

      final String sql = "INSERT INTO tasks (project_id, name, comments, reporter, assigned_to, start_date, deatline, status, version)"
          + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, task.getProjectid());
        ps.setString(2, task.getName());
        ps.setString(3, task.getComments());
        ps.setLong(4, task.getReporter());
        ps.setLong(5, task.getAssignedTo());
        ps.setTimestamp(6, SqlUtils.getTimestampFromDate(task.getStartDate()));
        ps.setTimestamp(7, SqlUtils.getTimestampFromDate(task.getDeadline()));
        ps.setInt(8, task.getStatus());
        ps.setInt(9, task.getVersion());

        return ps;
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Task [name: {}]: {}", task.getName(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(keyHolder.getKey().longValue());
  }

  @Override
  public Task getById(final Long id) throws StorageException {
    logger.info("Dao Read Project by id: " + id);
    final String sqlSelect = "SELECT * FROM tasks where id=?";

    Task task;

    try {

      task = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return taskFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Project data: " + e.toString());
    }

    return task;
  }

  @Override
  public List<Task> listTasks(final Long projectId) throws StorageException {
    logger.info("Dao Read Project Task List");
    final String sqlSelect = "SELECT * FROM tasks where project_id=?";

    List<Task> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, projectId);
        return ps;

      }, (rs, rowNum) -> {

        return taskFromResultSet(rs);

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve project Task: " + e.toString());
    }

    return list;
  }

  @Override
  public Task updateTask(final Task task) throws StorageException {
    logger.debug("Updating Project with id {}...", task.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "UPDATE projects SET project_id = ?, name = ?, comments = ?, reporter = ?," +
          " assigned_to = ?, start_date = ?, deadline = ?, status = ?, version = ? WHERE id = ?";

      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, task.getProjectid());
        ps.setString(2, task.getName());
        ps.setString(3, task.getComments());
        ps.setLong(4, task.getReporter());
        ps.setLong(5, task.getAssignedTo());
        ps.setTimestamp(6, SqlUtils.getTimestampFromDate(task.getStartDate()));
        ps.setTimestamp(7, SqlUtils.getTimestampFromDate(task.getDeadline()));
        ps.setInt(8, task.getStatus());
        ps.setInt(9, task.getVersion());
        ps.setLong(10, task.getId());

        return ps;
      });

      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update Project [id: {}]", task.getId()));
      }

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update Project [id: {}]: {}", task.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(task.getId());
  }

  @Override
  public boolean deleteTask(final Task task) throws StorageException {
    logger.debug("Deleting Task with id {}...", task.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "delete from tasks where id = ? ";
      
      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, task.getId());
        return ps;
      });
      
      if (deletedRows != 1) {
        throw new StorageException(String.format("Unable to delete Project  [id: {}]", task.getId()));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
      return true;
    }
    
    catch (final Exception e) {
      this.platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to delete Task [id: {}]: {}", task.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
  }

  private Task taskFromResultSet(final ResultSet rs) throws SQLException {
    final Task model = new Task();
    
    model.setAssignedTo(rs.getLong("assigned_to"));
    model.setComments(rs.getString("comments"));
    model.setName(rs.getString("name"));
    model.setProjectid(rs.getLong("project_id"));
    model.setReporter(rs.getLong("reporter"));
    model.setStartDate(SqlUtils.getDateFromTimestamp(rs.getTimestamp("start_date")));
    model.setDeadline(SqlUtils.getDateFromTimestamp(rs.getTimestamp("deadline")));
    model.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    model.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));
    model.setId(rs.getLong("id"));
    model.setVersion(rs.getInt("version"));
    model.setStatus(rs.getInt("status"));

    return model;
  }
}
