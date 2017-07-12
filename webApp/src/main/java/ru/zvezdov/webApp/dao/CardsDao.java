package ru.zvezdov.webApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.zvezdov.webApp.model.Card;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Dmitry on 12.07.2017.
 */
@Repository
public class CardsDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setJdbcTemplate(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    public int getUsersNum() {
        return this.jdbcTemplate.queryForObject("select count(*) from cards", Integer.class);
    }

    public List<Card> getAllCards() {
        List<Card> query = this.jdbcTemplate.query("SELECT * FROM cards", new CardMapper());
        System.out.println(query);
        return query;
    }

    private static final class CardMapper implements RowMapper<Card> {

        @Override
        public Card mapRow(ResultSet resultSet, int i) throws SQLException {
            Card card = new Card(
                    resultSet.getInt("id"),
                    resultSet.getString("word"),
                    resultSet.getString("description"),
                    resultSet.getInt("grade")
            );
            return card;
        }
    }
}
