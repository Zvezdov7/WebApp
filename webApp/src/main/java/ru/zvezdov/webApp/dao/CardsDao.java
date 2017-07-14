package ru.zvezdov.webApp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;
import ru.zvezdov.webApp.model.Card;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
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
        return this.jdbcTemplate.queryForObject("SELECT count(*) FROM cards", Integer.class);
    }

    public List<Card> getAllCards() {
        List<Card> query = this.jdbcTemplate.query("SELECT * FROM cards", new CardMapper());
        System.out.println(query);
        return query;
    }

    public List<Card> getCardsByGrade(int grade) {
        List<Card> query = this.jdbcTemplate.query("SELECT * FROM cards WHERE grade = ?", new CardMapper(), grade);
        return query;
    }

    public Card addCard(String word, String description, String mp3path) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(
                connection -> {
                    PreparedStatement ps = connection.prepareStatement("INSERT INTO cards VALUES (?, ?, ?, ?, ?)", new String[] {"id"});
                    ps.setString(1, null);
                    ps.setString(2, word);
                    ps.setString(3, description);
                    ps.setString(4, "1");
                    ps.setString(5, mp3path);
                    return ps;
                },
                keyHolder);
        return new Card(keyHolder.getKey().intValue(), word, description, 1, mp3path);
    }

    public void updateCard(Card card) {
        jdbcTemplate.update("UPDATE cards SET word = ?, description = ?, grade = ?, mp3path = ? WHERE id = ?",
                card.getWord(),
                card.getDescription(),
                card.getGrade(),
                card.getMp3path(),
                card.getId());
    }

    private static final class CardMapper implements RowMapper<Card> {
        @Override
        public Card mapRow(ResultSet resultSet, int i) throws SQLException {
            Card card = new Card(
                    resultSet.getInt("id"),
                    resultSet.getString("word"),
                    resultSet.getString("description"),
                    resultSet.getInt("grade"),
                    resultSet.getString("mp3path")
            );
            return card;
        }
    }
}
