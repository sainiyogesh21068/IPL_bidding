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

//    public Collection<Emp> findAll(){
//        List<Emp> empList = new ArrayList<>();
//        empList = jdbcTemplate.query("Select * from employee", new RowMapper<Emp>() {
//            @Override
//            public Emp mapRow(ResultSet resultSet, int i) throws SQLException {
//                Emp emp = new Emp();
//                emp.setEmpId(resultSet.getInt("id"));
//                emp.setEmpName(resultSet.getString("emp_name"));
//                emp.setEmpSalary(resultSet.getInt("salary"));
//                emp.setDeptId(resultSet.getInt("dept_id"));
//                return emp;
//            }
//        });
//        return empList;
//    }

    public Collection<Team> findById(String  name){
        List<Team> teamList = new ArrayList<>();
//        MapSqlParameterSource params = new MapSqlParameterSource().addValue("emp_id",id);
        teamList = jdbcTemplate.query( "Select * from Team where name = ?", new Object[] {name}, new RowMapper<Team>() {
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

//    public boolean saveEmp(Team emp){
//        String insert = "Insert into employee values(?,?,?)";
//        int result = jdbcTemplate.update(insert, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setInt(1,emp.getEmpId());
//                preparedStatement.setString(2,emp.getEmpName());
//                preparedStatement.setint(3,emp.getSalary());
//            }
//        });
//        if(result>0){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean saveEmp(Emp emp){
//        String insert = "Insert into employee(emp_name,salary,dept_id) values(:empName,:empSalary,:deptId)";
//        int result = namedParameterJdbcTemplate.update(insert, new BeanPropertySqlParameterSource(emp));
//        if(result>0){
//            return true;
//        }
//        return false;
//    }
//
//    public boolean delEmp(int id){
//        String delete = "Delete from employee where id=?";
//        int result = jdbcTemplate.update(delete, new PreparedStatementSetter() {
//            @Override
//            public void setValues(PreparedStatement preparedStatement) throws SQLException {
//                preparedStatement.setInt(1,id);
//            }
//        });
//        if(result>0){
//            return true;
//        }
//        return false;
//    }
}
