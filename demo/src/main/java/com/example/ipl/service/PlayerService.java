package com.example.ipl.service;

import com.example.ipl.model.Player;
import com.example.ipl.sql.PlayerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class PlayerService {
    @Autowired
    PlayerDao playerDao;

    public Collection<Player> getAll(){
        return playerDao.findAll();
    }
    public Collection<Player> getById(Integer id){
        return playerDao.findById(id);
    }
    public boolean savePlayer(Player player){
        return playerDao.savePlayer(player);
    }

    public boolean updatePlayerPrice(Integer teamId, Integer playerId, Double bidPrice){
        return playerDao.updatePrice(teamId, playerId, bidPrice);
    }

    public Double getPlayerPrice(Integer playerId){
        return playerDao.getPrice(playerId);
    }

    public boolean startBidding(){
        return playerDao.startBidding();
    }
    public Player biddingPlayer(){
        return playerDao.biddingPlayer();
    }

}
