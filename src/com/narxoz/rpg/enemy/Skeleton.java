package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class Skeleton implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;
    private String aiBehavior;

    private List<Ability> abilities;
    private LootTable lootTable;

    public Skeleton(String name) {
        this.name = name;
        this.health = 120;
        this.damage = 20;
        this.defense = 8;
        this.speed = 25;

        this.element = "NONE";
        this.aiBehavior = "DEFENSIVE";

        this.abilities = new ArrayList<>();
        this.lootTable = null;
    }

    public Skeleton(String name, int health, int damage, int defense, int speed,
                    String element, String aiBehavior, List<Ability> abilities, LootTable lootTable) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;
        this.aiBehavior = aiBehavior;

        this.abilities = new ArrayList<>();
        if (abilities != null) for (Ability a : abilities) this.abilities.add(a == null ? null : a.clone());

        this.lootTable = (lootTable == null) ? null : lootTable.clone();
    }

    @Override public String getName() { return name; }
    @Override public int getHealth() { return health; }
    @Override public int getDamage() { return damage; }
    @Override public int getDefense() { return defense; }
    @Override public int getSpeed() { return speed; }
    @Override public String getElement() { return element; }
    @Override public String getAIBehavior() { return aiBehavior; }
    @Override public List<Ability> getAbilities() { return Collections.unmodifiableList(abilities); }
    @Override public LootTable getLootTable() { return lootTable; }
    @Override public Map<Integer, Integer> getPhases() { return Map.of(); }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Skeleton) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);
        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            if (a == null) continue;
            System.out.println(" - " + a.getName() + " (dmg=" + a.getDamage() + "): " + a.getDescription());
        }
        if (lootTable != null) {
            System.out.println("Loot items: " + lootTable.getItems());
            System.out.println("Gold: " + lootTable.getGoldDrop() + " | EXP: " + lootTable.getExperienceDrop());
        } else {
            System.out.println("Loot: -");
        }
    }

    @Override
    public Enemy clone() {
        return new Skeleton(
                this.name, this.health, this.damage, this.defense, this.speed,
                this.element, this.aiBehavior, this.abilities, this.lootTable
        );
    }

    @Override public void setElement(String element) { this.element = element; }

    @Override
    public void multiplyStats(double multiplier) {
        if (multiplier <= 0) throw new IllegalArgumentException("Multiplier must be > 0");
        this.health = (int) Math.round(this.health * multiplier);
        this.damage = (int) Math.round(this.damage * multiplier);
        this.defense = (int) Math.round(this.defense * multiplier);
        this.speed = (int) Math.round(this.speed * multiplier);
    }
}