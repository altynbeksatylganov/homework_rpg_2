package com.narxoz.rpg.combat;

public class MeteorStorm implements Ability{
    @Override
    public String getName(){
        return "Meteor Storm";
    }
    @Override
    public int getDamage(){
        return 280;
    }
    @Override
    public String getDescription(){
        return "Ultimate AoE impact + fire damage (demo).";
    }
    @Override
    public Ability clone(){
        return new MeteorStorm();
    }




}


