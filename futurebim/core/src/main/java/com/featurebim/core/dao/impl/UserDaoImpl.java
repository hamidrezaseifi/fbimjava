package com.featurebim.core.dao.impl;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.featurebim.core.dao.UserDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.UserFull;

@Transactional
@Repository
public class UserDaoImpl implements UserDao {

  private static final Logger              logger = LoggerFactory.getLogger(ProjectDaoImpl.class);
  private final JdbcTemplate               jdbcTemplate;
  private final PlatformTransactionManager platformTransactionManager;

  @Autowired
  UserDaoImpl(final JdbcTemplate jdbcTemplate, final PlatformTransactionManager platformTransactionManager) {
    this.jdbcTemplate = jdbcTemplate;
    this.platformTransactionManager = platformTransactionManager;
  }

  @Override
  public UserFull addUser(final UserFull user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public UserFull updateUser(final UserFull user) throws StorageException {
    logger.debug("Updating user with id {}...", user.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "UPDATE users SET username = ?, gender = ?, firstname = ?, lastname = ?, name_tag = ?"
          + ", birthday = ?, email = ?, status = ?, version = ? WHERE id = ?;";
      //@formatter:on
      
      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, user.getUsername());
        ps.setInt(2, user.getGender());
        ps.setString(3, user.getFirstname());
        ps.setString(4, user.getLastname());
        ps.setString(5, user.getNameTag());
        ps.setDate(6, Date.valueOf(user.getBirthdate()));
        ps.setString(7, user.getEmail());
        ps.setInt(8, user.getStatus());
        ps.setInt(9, user.getVersion());
        ps.setLong(10, user.getId());
        
        return ps;
      });
      
      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update user [id: {}]", user.getId()));
      }
      
      final String sqldelrole = "DELETE FROM user_roles WHERE userid = ? ";
      //@formatter:on
      
      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sqldelrole);
        ps.setLong(1, user.getId());
        return ps;
      });
      
      final String sqlinsrole = "INSERT INTO user_roles(userid, roleid) VALUES(?, ?);";
      for (final Integer role : user.getRoles()) {
        this.jdbcTemplate.update(con -> {
          final PreparedStatement ps = con.prepareStatement(sqlinsrole);
          ps.setLong(1, user.getId());
          ps.setInt(2, role);
          return ps;
        });
      }
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update user [id: {}]: {}", user.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return getById(user.getId());
  }
  
  @Override
  public boolean setUserPassword(final Long id, final String password) throws StorageException {
    logger.debug("Updating user password id {}...", id);
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {
      
      final String sql = "UPDATE users SET hash_password = ? WHERE id = ?;";
      //@formatter:on
      
      final int changedRows = jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, password);

        ps.setLong(2, id);
        
        return ps;
      });
      
      if (changedRows != 1) {
        throw new StorageException(String.format("Unable to update user password [id: {}]", id));
      }
      
      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update user [id: {}]: {}", id, e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return true;
  }
  
  @Override
  public boolean updateUserRoles(final UserFull user) throws StorageException {
    logger.debug("Updating user roles with id {}...", user.getId());
    final TransactionStatus transactionStatus = this.platformTransactionManager.getTransaction(new DefaultTransactionDefinition());
    try {

      final String sqldelrole = "DELETE FROM user_roles WHERE userid = ? ";
      //@formatter:on

      this.jdbcTemplate.update(con -> {
        final PreparedStatement ps = con.prepareStatement(sqldelrole);
        ps.setLong(1, user.getId());
        return ps;
      });

      final String sqlinsrole = "INSERT INTO user_roles(userid, roleid) VALUES(?, ?);";
      for (final Integer role : user.getRoles()) {
        this.jdbcTemplate.update(con -> {
          final PreparedStatement ps = con.prepareStatement(sqlinsrole);
          ps.setLong(1, user.getId());
          ps.setInt(2, role);
          return ps;
        });
      }

      this.platformTransactionManager.commit(transactionStatus);
    }
    catch (final Exception e) {
      platformTransactionManager.rollback(transactionStatus);
      logger.error("Unable to update user roles [id: {}]: {}", user.getId(), e.toString(), e);
      throw new StorageException(e.toString(), e);
    }
    return true;
  }

  @Override
  public boolean removeUser(final Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public UserFull getById(final Long id) throws StorageException {
    logger.info("Dao Read UserFull by id: " + id);
    final String sqlSelect = "SELECT * FROM users where id=?";

    UserFull user;

    try {

      user = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, id);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userFullFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve UserFull data: " + e.toString());
    }

    return user;
  }

  @Override
  public UserFull getByUsername(final String username) throws StorageException {
    logger.info("Dao Read UserFull by username: " + username);
    final String sqlSelect = "SELECT * FROM users where username=?";

    UserFull user;

    try {

      user = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, username);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userFullFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve UserFull data: " + e.toString());
    }

    return user;
  }

  @Override
  public List<UserFull> listUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<UserFull> listCompanyUsers(final Long companyId) throws StorageException {
    logger.info("Dao Read User list by companyId: " + companyId);
    final String sqlSelect = "SELECT * FROM users where companyid=?";

    List<UserFull> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, companyId);
        return ps;

      }, (rs, rowNum) -> {

        return userFullFromResultSet(rs);

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to Read User list by companyID: " + e.toString());
    }

    return list;
  }
  
  private UserFull userFullFromResultSet(final ResultSet rs) throws SQLException {
    final UserFull user = new UserFull();
    user.setId(rs.getLong("id"));
    user.setCompanyid(rs.getLong("companyid"));
    user.setUsername(rs.getString("username"));
    user.setEmail(rs.getString("email"));
    user.setFirstname(rs.getString("firstname"));
    user.setGender(rs.getShort("gender"));
    user.setHashPassword(rs.getString("hash_password"));
    user.setLastname(rs.getString("lastname"));
    user.setNameTag(rs.getString("name_tag"));
    user.setStatus(rs.getInt("status"));
    user.setCreated(rs.getTimestamp("created").toLocalDateTime());
    user.setUpdated(rs.getTimestamp("updated").toLocalDateTime());
    user.setVersion(rs.getInt("version"));
    
    final Timestamp ts = rs.getTimestamp("birthday");

    if (ts != null) {
      user.setBirthdate(ts.toLocalDateTime().toLocalDate());
    }
    
    List<Integer> roles;
    try {
      roles = listUserRoles(user.getId());
      user.setRoles(roles);
    }
    catch (final StorageException e) {
      e.printStackTrace();
    }

    return user;
  }

  @Override
  public List<Integer> listUserRoles(final Long userId) throws StorageException {
    logger.info("Dao Read Use Roles by userid: " + userId);
    final String sqlSelect = "SELECT * FROM user_roles where userid=?";

    List<Integer> list = new ArrayList<>();

    try {
      list = jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setLong(1, userId);
        return ps;

      }, (rs, rowNum) -> {

        return rs.getInt("roleid");

      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve  Use Roles: " + e.toString());
    }

    return list;
  }

}
