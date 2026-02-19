package com.narxoz.rpg.combat;

public class FrostBreath implements Ability {
    @Override
    public String getName(){
        return "Glacier Breath";
    }
    @Override
    public int getDamage(){
        return 115;
    }
    @Override
    public String getDescription(){
        return "AoE ice damage + slow.";
    }
    @Override
    public Ability clone(){
        return new FrostBreath();
    }

}
