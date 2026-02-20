package com.narxoz.rpg;

import com.narxoz.rpg.builder.*;
import com.narxoz.rpg.enemy.Enemy;
import com.narxoz.rpg.factory.*;
import com.narxoz.rpg.prototype.EnemyRegistry;

public class Main {

    public static void main(String[] args) {

        System.out.println("=== ABSTRACT FACTORY: themed components ===");
        EnemyComponentFactory fire = new FireComponentFactory();
        EnemyComponentFactory ice = new IceComponentFactory();
        EnemyComponentFactory shadow = new ShadowComponentFactory();

        System.out.println("Fire AI: " + fire.createAIBehavior());
        System.out.println("Ice AI: " + ice.createAIBehavior());
        System.out.println("Shadow AI: " + shadow.createAIBehavior());
        System.out.println();

        System.out.println("=== BUILDER + FACTORY METHOD ===");
        EnemyDirector basicDirector = new EnemyDirector(new BasicEnemyBuilder());
        EnemyDirector bossDirector = new EnemyDirector(new BossEnemyBuilder());

        Enemy fireMinion = basicDirector.createMinion(fire);
        fireMinion.setElement("FIRE");
        fireMinion.displayInfo();
        System.out.println();

        Enemy iceElite = basicDirector.createElite(ice);
        iceElite.setElement("ICE");
        iceElite.displayInfo();
        System.out.println();

        Enemy shadowRaidBoss = bossDirector.createRaidBoss(shadow);
        shadowRaidBoss.setElement("SHADOW");
        shadowRaidBoss.displayInfo();
        System.out.println();

        System.out.println("=== PROTOTYPE: registry + deep copy ===");
        EnemyRegistry registry = new EnemyRegistry();
        registry.registerTemplate("goblin-template", fireMinion);
        registry.registerTemplate("dragon-template", shadowRaidBoss);

        System.out.println("Templates: " + registry.listTemplates());
        System.out.println();

        Enemy eliteGoblin = registry.createFromTemplate("goblin-template");
        eliteGoblin.multiplyStats(2.0);
        eliteGoblin.displayInfo();
        System.out.println();

        Enemy ancientDragon = registry.createFromTemplate("dragon-template");
        ancientDragon.multiplyStats(5.0);
        ancientDragon.displayInfo();
        System.out.println();

        System.out.println("=== FULL PIPELINE DONE ===");
    }
}