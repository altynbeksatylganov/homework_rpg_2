package com.narxoz.rpg.combat;

public class DarkNova implements Ability{
    @Override
    public String getName(){
        return "Dark Nova";
    }
    @Override
    public int getDamage(){
        return 250;
    }
    @Override
    public String getDescription(){
        return "Ultimate AoE shadow damage (demo).";
    }
    @Override
    public Ability clone(){
        return new DarkNova();
    }
}
