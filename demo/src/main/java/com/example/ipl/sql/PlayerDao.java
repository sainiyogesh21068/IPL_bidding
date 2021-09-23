package com.example.ipl.sql;

import com.example.ipl.model.Emp;
import com.example.ipl.model.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class PlayerDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Collection<Player> findAll(){
        List<Player> playerList = new ArrayList<>();
        playerList = jdbcTemplate.query("Select * from player", new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player = new Player();
                player.setPlayerId(resultSet.getInt("id"));
                player.setPlayerName(resultSet.getString("player_name"));
                player.setPlayerImageUrl(resultSet.getString("image_url"));
                player.setBasePrice(resultSet.getInt("base_price"));
                player.setForm(resultSet.getInt("form"));
                player.setSocialFollowing(resultSet.getInt("social_following"));
                player.setPreviousRecord(resultSet.getInt("prev_record"));
                return player;
            }
        });
        return playerList;
    }

}

