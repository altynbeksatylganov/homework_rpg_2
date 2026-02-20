package com.narxoz.rpg.loot;

import java.util.ArrayList;
import java.util.List;

public class ShadowLootTable implements LootTable {
    private final List<String> items = List.of("Shadow gem", "Dark Essence", "Shadow rune");
    private final int gold = 280;
    private final int exp = 550;

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
        return new ShadowLootTable();
    }
    @Override
    public String getLootInfo() {
        return "Items=" + getItems() + " | Gold=" + getGoldDrop() + " | EXP=" + getExperienceDrop();
    }

}
