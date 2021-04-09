package io.springsecurity.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import io.springsecurity.config.AppConfig;
import io.springsecurity.dao.model.User;
import io.springsecurity.dao.model.UserPropertyModel;

@Repository
public class UserDao {
	private static Logger LOG = LoggerFactory.getLogger(UserDao.class);
    private JdbcTemplate jdbcTemplate;
    private static final Integer batchSize = 1000;

    @Autowired
    private AppConfig config;
    
    @Autowired
    public UserDao(@Qualifier("JdbcTemplateSpringSec") JdbcTemplate jdbcTemplate, @Qualifier("AppConfig") AppConfig config) {
        jdbcTemplate.setFetchSize(config.getJdbcFetchRowSize());
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<UserPropertyModel> getDefaultProps(Long contactId) {

		String sql = "SELECT "
				+ "c.id  id,"
				+ "c.username username,"
				+ "c.password password,"
				+ "c.active active,"
				+ "c.roles roles"
				+ " from userdetails c where c.id="+contactId;

		return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(UserPropertyModel.class));
    }
    
    public User getDetailsByUsername(String username) {

		String sql = "SELECT "
				+ "c.id  id,"
				+ "c.username username,"
				+ "c.password password,"
				+ "c.active active,"
				+ "c.roles roles"
				+ " from userdetails c where c.username='"+username+"'";

		User usr= jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class));
		System.out.println(usr.getPassword());
		return usr;

    }
}
