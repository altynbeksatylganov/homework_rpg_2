package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.enemy.Goblin;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.List;

public class BasicEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private String aiBehavior;

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    @Override
    public EnemyBuilder reset() {
        name = null;
        health = 0;
        damage = 0;
        defense = 0;
        speed = 0;
        element = "NONE";
        aiBehavior = "AGGRESSIVE";
        abilities = new ArrayList<>();
        lootTable = null;
        return this;
    }

    @Override public EnemyBuilder setName(String name) { this.name = name; return this; }
    @Override public EnemyBuilder setHealth(int health) { this.health = health; return this; }
    @Override public EnemyBuilder setDamage(int damage) { this.damage = damage; return this; }
    @Override public EnemyBuilder setDefense(int defense) { this.defense = defense; return this; }
    @Override public EnemyBuilder setSpeed(int speed) { this.speed = speed; return this; }

    @Override public EnemyBuilder setElement(String element) { this.element = element; return this; }
    @Override public EnemyBuilder setAI(String aiBehavior) { this.aiBehavior = aiBehavior; return this; }

    @Override public EnemyBuilder addAbility(Ability ability) { if (ability != null) abilities.add(ability); return this; }
    @Override public EnemyBuilder setAbilities(List<Ability> abilities) {
        this.abilities = new ArrayList<>();
        if (abilities != null) this.abilities.addAll(abilities);
        return this;
    }

    @Override public EnemyBuilder setLootTable(LootTable loot) { this.lootTable = loot; return this; }

    @Override public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        return this;
    }

    @Override
    public Enemy build() {
        if (name == null || name.isBlank()) throw new IllegalStateException("Name is required");
        if (health <= 0) throw new IllegalStateException("Health must be positive");

        Enemy enemy = new Goblin(
                name, health, damage, defense, speed,
                element, aiBehavior, abilities, lootTable
        );

        reset();
        return enemy;
    }
}