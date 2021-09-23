package com.example.ipl.controller;

import com.example.ipl.model.Emp;
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
    @PostMapping("/players/saveplayer")
    public boolean savePlayer(@RequestBody Player player) {
        return playerService.savePlayer(player);
    }

    @PostMapping("/bid")
    public boolean updatePlayerPrice(@RequestParam Integer teamId, @RequestParam Integer playerId, @RequestParam Double bidPrice) {
        return playerService.updatePlayerPrice(teamId, playerId, bidPrice);
    }

    @GetMapping("/players/price")
    public Double getPlayerPrice(@RequestParam Integer playerId) {
        return playerService.getPlayerPrice(playerId);
    }

    @GetMapping("/startbidding")
    public boolean startBidding() {
        return playerService.startBidding();
    }

    @GetMapping("/getbidplayer")
    public Player getBidPLayer() {
        return playerService.biddingPlayer();
    }
}
