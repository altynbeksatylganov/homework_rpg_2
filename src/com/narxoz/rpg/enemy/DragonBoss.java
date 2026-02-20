package com.narxoz.rpg.enemy;

import com.narxoz.rpg.combat.Ability;
import com.narxoz.rpg.loot.LootTable;

import java.util.*;

public class DragonBoss implements Enemy {

    private String name;
    private int health;
    private int damage;
    private int defense;
    private int speed;

    private String element;

    private List<Ability> abilities;
    private Map<Integer, Integer> phases;

    private LootTable lootTable;
    private String aiBehavior;

    private boolean canFly;
    private boolean hasBreathAttack;
    private int wingspan;

    public DragonBoss(String name,
                      int health, int damage, int defense, int speed,
                      String element,
                      List<Ability> abilities,
                      int phase1Threshold, int phase2Threshold, int phase3Threshold,
                      LootTable lootTable,
                      String aiBehavior,
                      boolean canFly, boolean hasBreathAttack, int wingspan) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.defense = defense;
        this.speed = speed;
        this.element = element;


        this.abilities = new ArrayList<>();
        if (abilities != null) {
            for (Ability a : abilities) this.abilities.add(a == null ? null : a.clone());
        }


        this.phases = new HashMap<>();
        this.phases.put(1, phase1Threshold);
        this.phases.put(2, phase2Threshold);
        this.phases.put(3, phase3Threshold);


        this.lootTable = (lootTable == null) ? null : lootTable.clone();
        this.aiBehavior = aiBehavior;

        this.canFly = canFly;
        this.hasBreathAttack = hasBreathAttack;
        this.wingspan = wingspan;
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
    @Override public Map<Integer, Integer> getPhases() { return Collections.unmodifiableMap(phases); }

    @Override
    public void displayInfo() {
        System.out.println("=== " + name + " (Dragon Boss) ===");
        System.out.println("Health: " + health + " | Damage: " + damage + " | Defense: " + defense + " | Speed: " + speed);
        System.out.println("Element: " + element);

        System.out.println("Abilities (" + abilities.size() + "):");
        for (Ability a : abilities) {
            if (a == null) continue;
            System.out.println(" - " + a.getName() + " (dmg=" + a.getDamage() + "): " + a.getDescription());
        }

        System.out.println("Boss Phases: " + phases.size());
        for (Map.Entry<Integer, Integer> phase : phases.entrySet()) {
            System.out.println(" Phase " + phase.getKey() + ": triggers at " + phase.getValue() + " HP");
        }

        System.out.println("AI Behavior: " + aiBehavior);
        System.out.println("Can Fly: " + canFly + " | Breath Attack: " + hasBreathAttack + " | Wingspan: " + wingspan);

        if (lootTable != null) {
            System.out.println("Loot items: " + lootTable.getItems());
            System.out.println("Gold: " + lootTable.getGoldDrop() + " | EXP: " + lootTable.getExperienceDrop());
        } else {
            System.out.println("Loot: -");
        }
    }

    @Override
    public Enemy clone() {

        List<Ability> abilitiesCopy = new ArrayList<>();
        for (Ability a : this.abilities) abilitiesCopy.add(a == null ? null : a.clone());

        Map<Integer, Integer> phasesCopy = new HashMap<>(this.phases);

        LootTable lootCopy = (this.lootTable == null) ? null : this.lootTable.clone();


        int p1 = phasesCopy.getOrDefault(1, 0);
        int p2 = phasesCopy.getOrDefault(2, 0);
        int p3 = phasesCopy.getOrDefault(3, 0);

        return new DragonBoss(
                this.name,
                this.health, this.damage, this.defense, this.speed,
                this.element,
                abilitiesCopy,
                p1, p2, p3,
                lootCopy,
                this.aiBehavior,
                this.canFly, this.hasBreathAttack, this.wingspan
        );
    }

    @Override
    public void setElement(String element) {
        this.element = element;
    }

    @Override
    public void multiplyStats(double multiplier) {
        if (multiplier <= 0) throw new IllegalArgumentException("Multiplier must be > 0");
        this.health = (int) Math.round(this.health * multiplier);
        this.damage = (int) Math.round(this.damage * multiplier);
        this.defense = (int) Math.round(this.defense * multiplier);
        this.speed = (int) Math.round(this.speed * multiplier);
    }
}