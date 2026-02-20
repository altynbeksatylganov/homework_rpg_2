package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.FireLootTable;
import com.narxoz.rpg.loot.LootTable;

import java.util.List;

public class FireComponentFactory implements EnemyComponentFactory {
    @Override public List<Ability> createAbilities() {
        return List.of(new FlameBreath(), new FireShield(), new MeteorStorm());
    }
    @Override public LootTable createLootTable() {
        return new FireLootTable(); }
    @Override public String createAIBehavior() {
        return "AGGRESSIVE"; }
}