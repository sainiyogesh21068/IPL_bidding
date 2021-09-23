package com.example.ipl.controller;

import com.example.ipl.model.Player;
import com.example.ipl.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @GetMapping("/players/all")
    public Collection<Player> getAllPlayers() {
        return playerService.getAll();
    }

    @GetMapping("/players/byid")
    public Collection<Player> getPlayerById(@RequestParam Integer id) {
        return playerService.getById(id);
    }

}
