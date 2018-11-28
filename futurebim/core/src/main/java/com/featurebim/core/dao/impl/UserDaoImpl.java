package com.featurebim.core.dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.Transactional;

import com.featurebim.core.dao.UserDao;
import com.featurebim.core.dao.exceptions.StorageException;
import com.featurebim.core.model.User;

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
  public User addUser(final User user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User updateUser(final User user) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public boolean removeUser(final Long id) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public User getById(final Long id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public User getByUsername(final String username) throws StorageException {
    logger.info("Dao Read User by username: " + username);
    final String sqlSelect = "SELECT * FROM users where username=?";

    User user;

    try {

      user = this.jdbcTemplate.query(con -> {
        final PreparedStatement ps = con.prepareStatement(sqlSelect);
        ps.setString(1, username);
        return ps;

      }, (rs) -> {
        if (rs.next()) {
          return userFromResultSet(rs);
        }
        else {
          return null;
        }
      });

    }
    catch (final Exception e) {
      throw new StorageException("Unable to retrieve User data: " + e.toString());
    }

    return user;
  }

  @Override
  public List<User> listUsers() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<User> listCompanyUsers(final Long companyId) {
    // TODO Auto-generated method stub
    return null;
  }

  private User userFromResultSet(final ResultSet rs) throws SQLException {
    final User user = new User();
    user.setId(rs.getLong("id"));
    user.setCompanyid(rs.getLong("companyid"));
    user.setUsername(rs.getString("username"));
    user.setBirthday(rs.getTimestamp("birthday").toLocalDateTime().toLocalDate());
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

    return user;
  }
}
