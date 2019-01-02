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

import com.futurebim.core.dao.TaskDao;
import com.futurebim.core.dao.exceptions.StorageException;
import com.futurebim.core.dao.utils.SqlUtils;
import com.futurebim.core.model.CheckVersion;
import com.futurebim.core.model.SubTask;
import com.futurebim.core.model.Task;

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
  public Task addNew(final Task task) throws StorageException {
    logger.debug("insert Task {}...", task.getName());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder         keyHolder         = new GeneratedKeyHolder();
    
    try {
      
      final String sql = "INSERT INTO tasks (project_id, name, comments, reporter, assigned_to, start_date, deadline, status, version)" + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
      
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
  public SubTask addNewSubTask(final SubTask task) throws StorageException {
    logger.debug("insert Task {}...", task.getTitle());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    final KeyHolder         keyHolder         = new GeneratedKeyHolder();

    try {

      final String sql = "INSERT INTO subtask(taskid, title, progress, comments, reporter, status, version) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps.setLong(1, task.getTaskid());
        ps.setString(2, task.getTitle());
        ps.setInt(3, task.getProgress());
        ps.setString(4, task.getComments());
        ps.setLong(5, task.getReporter());
        ps.setInt(6, task.getStatus());
        ps.setInt(7, task.getVersion());

        return ps;
      }, keyHolder);

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Task [name: {}]: {}", task.getTitle(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getSubTaskById(keyHolder.getKey().longValue());
  }
  
  @Override
  public Task getById(final Long id) throws StorageException {
    logger.info("Dao Read Task by id: " + id);
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
      throw new StorageException("Unable to retrieve Task data: " + e.toString());
    }
    
    return task;
  }

  @Override
  public SubTask getSubTaskById(final Long id) throws StorageException {
    logger.info("Dao Read subtask by id: " + id);
    final String sqlSelect = "SELECT * FROM subtask where id=?";
    
    SubTask task;
    
    try {
      
      task = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;
        
      }, (rs) -> {
        if (rs.next()) {
          return subtaskFromResultSet(rs);
        }
        else {
          return null;
        }
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve subtask data: " + e.toString());
    }
    
    return task;
  }
  
  @Override
  public List<Task> listByProject(final Long projectId) throws StorageException {
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
  public List<SubTask> listSubTaskByTask(final Long taskId) throws StorageException {
    logger.info("Dao Read Task SubTask List");
    final String sqlSelect = "SELECT * FROM subtask where taskid=?";

    List<SubTask> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, taskId);
        return ps;

      }, (rs, rowNum) -> {

        return subtaskFromResultSet(rs);

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve Task SubTask List: " + e.toString());
    }

    return list;
  }
  
  @Override
  public List<Task> listByWorkflow(final Long workflowId) throws StorageException {
    logger.info("Dao Read Workflow Task List");
    final String sqlSelect = "SELECT tasks.* FROM workflow_tasks inner join tasks on workflow_tasks.task_id = tasks.id where workflow_id=?";
    
    List<Task> list = new ArrayList<>();
    
    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, workflowId);
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
  public Task update(final Task task) throws StorageException {
    logger.debug("Updating Task with id {}...", task.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "UPDATE tasks SET project_id = ?, name = ?, comments = ?, reporter = ?, assigned_to = ?, start_date = ?, deadline = ?, status = ?, version = ? WHERE id = ?";
      
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
        throw new StorageException(String.format("Unable to update Task [id: {}]", task.getId()));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update Task [id: {}]: {}", task.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(task.getId());
  }

  @Override
  public SubTask updateSubTask(final SubTask subTask) throws StorageException {
    logger.debug("Updating SubTask with id {}...", subTask.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "UPDATE subtask SET title = ?, comments = ?, reporter = ?, progress = ?, status = ?, version = ? WHERE id = ?";
      
      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, subTask.getTitle());
        ps.setString(2, subTask.getComments());
        ps.setLong(3, subTask.getReporter());
        ps.setInt(4, subTask.getProgress());
        ps.setInt(5, subTask.getStatus());
        ps.setInt(6, subTask.getVersion());
        ps.setLong(7, subTask.getId());
        
        return ps;
      });
      
      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update SubTask [id: {}]", subTask.getId()));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update SubTask [id: {}]: {}", subTask.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getSubTaskById(subTask.getId());
  }
  
  @Override
  public boolean delete(final Task task) throws StorageException {
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
        throw new StorageException(String.format("Unable to delete Task  [id: {}]", task.getId()));
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

  @Override
  public boolean deleteSubTask(final SubTask subTask) throws StorageException {
    logger.debug("Deleting SubTask with id {}...", subTask.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "delete from subtask where id = ? ";

      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, subTask.getId());
        return ps;
      });

      if (deletedRows != 1) {
        throw new StorageException(String.format("Unable to delete SubTask  [id: {}]", subTask.getId()));
      }

      this.platformTransactionManager.commit(transactionStatus);
      return true;
    }

    catch (final Exception e) {
      this.platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to delete SubTask [id: {}]: {}", subTask.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
  }
  
  @Override
  public boolean addWorkflowTask(final Long workflowId, final Long taskId) throws StorageException {

    logger.debug("insert Task {} to workflow {}...", taskId, workflowId);
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    
    try {
      
      final String sql = "INSERT INTO workflow_tasks (workflow_id, task_id, status) VALUES (?, ?, 1)";
      
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, workflowId);
        ps.setLong(2, taskId);
        
        return ps;
      });
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to insert Task {} to workflow {} : {}", taskId, workflowId, e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return true;
  }
  
  @Override
  public boolean deleteWorkflowTask(final Long workflowId, final Long taskId) throws StorageException {
    logger.debug("Deleting Task {} from workflow {}...", taskId, workflowId);
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sql = "delete from workflow_tasks where workflow_id = ? and task_id = ? ";

      final int deletedRows = this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setLong(1, workflowId);
        ps.setLong(2, taskId);
        return ps;
      });

      if (deletedRows != 1) {
        throw new StorageException(String.format("Unable to Deleting Task {} from workflow {}...", taskId, workflowId));
      }

      this.platformTransactionManager.commit(transactionStatus);
      return true;
    }

    catch (final Exception e) {
      this.platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to Deleting Task {} from workflow {}...{}", taskId, workflowId, e.toString(), e);
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
    model.setSubTasks(listSubTaskByTask(model.getId()));
    
    return model;
  }

  private SubTask subtaskFromResultSet(final ResultSet rs) throws SQLException {
    final SubTask model = new SubTask();

    model.setComments(rs.getString("comments"));
    model.setTitle(rs.getString("title"));
    model.setTaskid(rs.getLong("taskid"));
    model.setReporter(rs.getLong("reporter"));
    model.setCreated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("created")));
    model.setUpdated(SqlUtils.getDatetimeFromTimestamp(rs.getTimestamp("updated")));
    model.setId(rs.getLong("id"));
    model.setVersion(rs.getInt("version"));
    model.setProgress(rs.getInt("progress"));
    model.setStatus(rs.getInt("status"));
    
    return model;
  }

  @Override
  public CheckVersion checkTaskVersion(final CheckVersion checkingTask) {
    logger.info("Dao Read Task Version by id: " + checkingTask.getId());
    final String sqlSelect = "SELECT id, version FROM tasks where id=?";
    
    final CheckVersion checkVersion = new CheckVersion();
    checkVersion.setId(checkingTask.getId());
    
    try {
      
      this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, checkingTask.getId());
        return ps;
        
      }, (rs) -> {
        if (rs.next()) {
          checkVersion.setVersion(rs.getInt("version"));
        }
        else {
          throw new StorageException("Unable to retrieve task data for id: " + checkingTask.getId());
        }
      });
      
    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve task data: " + e.toString());
    }
    
    return checkVersion;
  }
  
  @Override
  public List<CheckVersion> checkTaskListVersion(final List<CheckVersion> checkingTaskList) {
    logger.info("Dao Read Task List version");
    
    List<CheckVersion> list = new ArrayList<>();
    
    if (checkingTaskList.size() > 0) {
      String sqlSelect = "SELECT id, version FROM tasks where id in (";
      for (final CheckVersion cVer : checkingTaskList) {
        sqlSelect += cVer.getId() + ", ";
      }
      sqlSelect = sqlSelect.trim();
      if (sqlSelect.endsWith(",")) {
        sqlSelect = sqlSelect.substring(0, sqlSelect.length() - 1);
      }
      sqlSelect += ")";
      
      final String finalSqlSelect = sqlSelect;
      
      try {
        list = jdbcTemplate.query(con -> {
          final PreparedStatement ps = con.prepareStatement(finalSqlSelect);
          return ps;
          
        }, (rs, rowNum) -> {
          
          return taskCheckVersionFromResultSet(rs);
          
        });
        
      }
      catch (final Exception e) {
        throw new StorageException("Unable to retrieve Task version list: " + e.toString());
      }
    }
    
    return list;
  }

  private CheckVersion taskCheckVersionFromResultSet(final ResultSet rs) throws SQLException {
    final CheckVersion ver = new CheckVersion();
    ver.setId(rs.getLong("id"));
    ver.setVersion(rs.getInt("version"));
    
    return ver;
  }
}
