package com.example.ipl.sql;

import com.example.ipl.model.Team;
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
public class TeamDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    public Collection<Team> findById(String  name){
        List<Team> teamList = new ArrayList<>();
        teamList = jdbcTemplate.query( "Select * from team where team_name = ?", new Object[] {name}, new RowMapper<Team>() {
            @Override
            public Team mapRow(ResultSet resultSet, int i) throws SQLException {
                Team t = new Team();
                t.setId(resultSet.getInt("id"));
                t.setName(resultSet.getString("team_name"));

                return t;
            }
        });
        return teamList;
    }

}
