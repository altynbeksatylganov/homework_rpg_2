package com.narxoz.rpg.factory;

import com.narxoz.rpg.combat.*;
import com.narxoz.rpg.loot.LootTable;
import com.narxoz.rpg.loot.ShadowLootTable;

import java.util.List;

public class ShadowComponentFactory implements EnemyComponentFactory {
    @Override public List<Ability> createAbilities() {
        return List.of(new ShadowStrike(), new Vanish(), new DarkNova());
    }
    @Override public LootTable createLootTable() {
        return new ShadowLootTable(); }
    @Override public String createAIBehavior() {
        return "TACTICAL"; }
}