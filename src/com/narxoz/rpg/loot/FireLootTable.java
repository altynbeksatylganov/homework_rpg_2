package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;
public class FireLootTable implements LootTable {
    private final List<String> items = List.of("Fire Gem", "Dragon Scale", "Flame Rune");
    private final int gold = 250;
    private final int exp = 500;
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
        return new FireLootTable();
    }


}
