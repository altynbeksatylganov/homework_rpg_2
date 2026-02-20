package com.narxoz.rpg.builder;

import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.EnemyComponentFactory;

public class EnemyDirector {

    private final EnemyBuilder builder;

    public EnemyDirector(EnemyBuilder builder) {
        this.builder = builder;
    }

    public Enemy createMinion(EnemyComponentFactory factory) {
        builder.reset();
        return builder
                .setName("Minion")
                .setHealth(80)
                .setDamage(12)
                .setDefense(4)
                .setSpeed(30)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build(); // Factory Method call :contentReference[oaicite:6]{index=6}
    }

    public Enemy createElite(EnemyComponentFactory factory) {
        builder.reset();
        return builder
                .setName("Elite")
                .setHealth(220)
                .setDamage(35)
                .setDefense(14)
                .setSpeed(28)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .build();
    }

    public Enemy createMiniBoss(EnemyComponentFactory factory) {
        builder.reset();
        return builder
                .setName("Mini Boss")
                .setHealth(2500)
                .setDamage(160)
                .setDefense(80)
                .setSpeed(18)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 2500)
                .addPhase(2, 1400)
                .addPhase(3, 700)
                .build();
    }

    public Enemy createRaidBoss(EnemyComponentFactory factory) {
        builder.reset();
        return builder
                .setName("Raid Boss")
                .setHealth(50000)
                .setDamage(500)
                .setDefense(250)
                .setSpeed(15)
                .setElement("THEMED")
                .setAbilities(factory.createAbilities())
                .setLootTable(factory.createLootTable())
                .setAI(factory.createAIBehavior())
                .addPhase(1, 50000)
                .addPhase(2, 30000)
                .addPhase(3, 12000)
                .build();
    }
}