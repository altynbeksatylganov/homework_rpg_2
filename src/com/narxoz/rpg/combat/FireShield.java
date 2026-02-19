package com.narxoz.rpg.combat;

public class FireShield implements Ability{
    @Override
    public String getName(){
        return "Fire Shield";
    }
    @Override
    public int getDamage(){
        return 0;
    }
    @Override
    public String getDescription(){
        return "Defensive buff (demo).";
    }
    @Override
    public Ability clone(){
        return new FireShield();
    }
}
