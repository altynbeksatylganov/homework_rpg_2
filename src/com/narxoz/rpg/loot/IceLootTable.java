package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;
public class IceLootTable implements LootTable {
    private final List<String> items = List.of("Ice Gem", "Frost Scale", "Ice Rune");
    private final int gold = 230;
    private final int exp = 480;

    @Override
    public List<String> getItems(){
        return new ArrayList<>(items);
    }
    @Override
    public int getGoldDrop(){
        return gold;
    }
    @Override
    public int getExperienceDrop(){
        return exp;
    }
    @Override
    public LootTable clone(){
        return new IceLootTable();
    }




}
