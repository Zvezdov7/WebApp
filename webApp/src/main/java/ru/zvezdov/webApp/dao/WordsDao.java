package ru.zvezdov.webApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * Created by Dmitry on 12.07.2017.
 */
@Repository
public class WordsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getUsersNum() {
        return this.jdbcTemplate.queryForObject("select count(*) from users", Integer.class);
    }
}
