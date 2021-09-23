package com.example.ipl.sql;

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
import java.util.*;

@Service
public class PlayerDao {

    static Integer curPlayerId;
    static Integer curpos = 0;
    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public Collection<Player> findAll() {
        List<Player> playerList = new ArrayList<>();
        playerList = jdbcTemplate.query("Select * from player order by base_price", new RowMapper<Player>() {
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

    public Collection<Player> findById(Integer id) {
        List<Player> playerList = new ArrayList<>();
        playerList = jdbcTemplate.query("Select * from player where id = ?", new Object[]{id}, new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player = new Player();
                player.setPlayerId(resultSet.getInt("id"));
                player.setPlayerName(resultSet.getString("player_name"));
                player.setPlayerImageUrl(resultSet.getString("image_url"));
                player.setBasePrice(resultSet.getDouble("base_price"));
                player.setForm(resultSet.getInt("form"));
                player.setSocialFollowing(resultSet.getInt("social_following"));
                player.setPreviousRecord(resultSet.getInt("prev_record"));
                player.setType(resultSet.getString("type"));
                player.setTeamID(resultSet.getInt("team_id"));
                player.setPrice(resultSet.getDouble("price_sold"));
                player.setIsSold(resultSet.getInt("sold_unsold"));
                return player;
            }
        });
        return playerList;
    }

    public boolean savePlayer(Player player) {
        String insert = "Insert into player(player_name,image_url,base_price,form,social_following,prev_record,type,sold_unsold)" +
                " values(:playerName,:playerImageUrl,:basePrice,:form,:socialFollowing,:previousRecord,:type,:isSold)";
        int result = namedParameterJdbcTemplate.update(insert, new BeanPropertySqlParameterSource(player));
        if (result > 0) {
            return true;
        }
        return false;
    }

    public boolean updatePrice(Integer teamId, Integer playerId, Double bidPrice) {
        boolean done = false;
        List<Player> playerList = (List<Player>) findById(playerId);
        if (!playerList.isEmpty()) {
            Double prev_price = playerList.get(0).getPrice();
            Double base_price = playerList.get(0).getBasePrice()
            if ( ( prev_price == null || prev_price < bidPrice) && bidPrice>base_price) {
                String update = "Update player set team_id = ?, price_sold = ?, sold_unsold = 1 where id = ?";
                int result = jdbcTemplate.update(update, new Object[]{teamId, bidPrice, playerId});
                if (result > 0) {
                    done = true;
                }
            }
        }
        return done;
    }

    public Double getPrice(Integer playerId) {
        Double price = Double.valueOf(-1);
        List<Player> playerList = (List<Player>) findById(playerId);
        if (!playerList.isEmpty()) {
            price = playerList.get(0).getPrice();
        }
        return price;
    }
    
    public boolean startBidding(){
        PlayerDao.curpos = 0;
        TimerTask timerTask =new TimerTask() {
            @Override
            public void run(){
                    PlayerDao.curpos++;
            }
        };
        Timer timer =new Timer();
        //Schedule the specified task to start repeated, fixed delays at a specified time.This is executed every 3 seconds
        timer.schedule(timerTask,10,3000);
        return true;
    }

    public Player biddingPlayer() {
        List<Player> playerList = new ArrayList<>();
        playerList = jdbcTemplate.query("Select * from player order by base_price", new RowMapper<Player>() {
            @Override
            public Player mapRow(ResultSet resultSet, int i) throws SQLException {
                Player player = new Player();
                player.setPlayerId(resultSet.getInt("id"));
                player.setPlayerName(resultSet.getString("player_name"));
                player.setPlayerImageUrl(resultSet.getString("image_url"));
                player.setBasePrice(resultSet.getDouble("base_price"));
                player.setForm(resultSet.getInt("form"));
                player.setSocialFollowing(resultSet.getInt("social_following"));
                player.setPreviousRecord(resultSet.getInt("prev_record"));
                player.setPrice(resultSet.getDouble("price_sold"));
                return player;
            }
        });
        if( playerList.size() > PlayerDao.curpos )
            return playerList.get(PlayerDao.curpos);
        else
            return new Player();
    }
}
