package com.example.ipl.model;

import lombok.Data;

@Data
public class Player{
    int playerId;
    String playerName;
    String playerImageUrl;
    int socialFollowing;
    int form;
    int previousRecord;
    String type;
    int isSold;
    int teamID;
    double basePrice;
    double price;
}
