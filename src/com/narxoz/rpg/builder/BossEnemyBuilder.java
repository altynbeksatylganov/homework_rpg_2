package com.narxoz.rpg.builder;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.enemy.DragonBoss;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.loot.LootTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BossEnemyBuilder implements EnemyBuilder {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private String aiBehavior;

    private List<Ability> abilities = new ArrayList<>();
    private LootTable lootTable;

    private Map<Integer, Integer> phases = new HashMap<>();

    private boolean canFly = true;
    private boolean hasBreathAttack = true;
    private int wingspan = 20;

    @Override
    public EnemyBuilder reset() {
        name = null;
        health = 0;
        damage = 0;
        defense = 0;
        speed = 0;

        element = "NONE";
        aiBehavior = "TACTICAL";

        abilities = new ArrayList<>();
        lootTable = null;

        phases = new HashMap<>();
        phases.put(1, 10000);
        phases.put(2, 6000);
        phases.put(3, 2500);

        canFly = true;
        hasBreathAttack = true;
        wingspan = 20;

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

    @Override
    public EnemyBuilder addPhase(int phaseNumber, int healthThreshold) {
        if (phaseNumber <= 0) throw new IllegalArgumentException("phaseNumber must be > 0");
        if (healthThreshold <= 0) throw new IllegalArgumentException("healthThreshold must be > 0");
        phases.put(phaseNumber, healthThreshold);
        return this;
    }


    public BossEnemyBuilder setCanFly(boolean canFly) { this.canFly = canFly; return this; }
    public BossEnemyBuilder setHasBreathAttack(boolean hasBreathAttack) { this.hasBreathAttack = hasBreathAttack; return this; }
    public BossEnemyBuilder setWingspan(int wingspan) { this.wingspan = wingspan; return this; }

    @Override
    public Enemy build() {
        if (name == null || name.isBlank()) throw new IllegalStateException("Name is required");
        if (health <= 0) throw new IllegalStateException("Health must be positive");

        int p1 = phases.getOrDefault(1, health);
        int p2 = phases.getOrDefault(2, Math.max(1, health / 2));
        int p3 = phases.getOrDefault(3, Math.max(1, health / 4));

        Enemy enemy = new DragonBoss(
                name,
                health, damage, defense, speed,
                element,
                abilities,
                p1, p2, p3,
                lootTable,
                aiBehavior,
                canFly, hasBreathAttack, wingspan
        );

        reset();
        return enemy;
    }
}