package com.example.ipl.controller;


import com.example.ipl.model.Team;
import com.example.ipl.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class TeamController {

    @Autowired
    TeamService tservice;

    @GetMapping("/findbyname")
    public Collection<Team> findById(@RequestParam String name) {
        return tservice.getById(name);
    }


}
