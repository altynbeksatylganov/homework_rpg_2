package com.narxoz.rpg.combat;

public class Blizzard implements Ability{
    @Override
    public String getName(){
        return "Blizzard";
    }
    @Override
    public int getDamage(){
        return 230;
    }
    @Override
    public String getDescription(){
        return "Ultimate AoE ice damage (demo).";
    }
    @Override
    public Ability clone(){
        return new Blizzard();
    }
}
