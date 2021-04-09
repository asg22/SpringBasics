package io.springsecurity.dao;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import io.springsecurity.config.AppConfig;

@Repository
public class MonitorDao {

	private static Logger log = LoggerFactory.getLogger(MonitorDao.class);
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public MonitorDao(@Qualifier("JdbcTemplateSpringSec") JdbcTemplate jdbcTemplate, @Qualifier("AppConfig") AppConfig config) {
        jdbcTemplate.setFetchSize(config.getJdbcFetchRowSize());
        this.jdbcTemplate = jdbcTemplate;
    }

    public void pingDB() {
        jdbcTemplate.queryForObject("select "
            + "    1 "
            + "from"
            + "    dual", String.class);
    }
}
