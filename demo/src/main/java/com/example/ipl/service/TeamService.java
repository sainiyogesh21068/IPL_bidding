package com.example.ipl.service;


import com.example.ipl.model.Team;
import com.example.ipl.sql.TeamDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class TeamService {
    @Autowired
    TeamDao tdao;


    public Collection<Team> getById( String name){
        return tdao.findById(name);
    }

//    public boolean saveEmp(Team t){
//        return empDao.saveEmp(emp);
//    }
//
//    public boolean saveEmpBetter(Emp emp){
//        return empDao.saveEmp(emp);
//    }
//
//    public boolean delEmp(int id){
//        return empDao.delEmp(id);
//    }
}
