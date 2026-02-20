package com.narxoz.rpg.prototype;

import com.narxoz.rpg.enemy.Enemy;

import java.util.*;

public class EnemyRegistry {

    private final Map<String, Enemy> templates = new HashMap<>();

    public void registerTemplate(String key, Enemy template) {
        if (key == null || key.isBlank()) throw new IllegalArgumentException("Key is required");
        if (template == null) throw new IllegalArgumentException("Template is required");
        templates.put(key, template);
    }

    public Enemy createFromTemplate(String key) {
        Enemy template = templates.get(key);
        if (template == null) throw new IllegalArgumentException("Unknown template: " + key);
        return template.clone(); // IMPORTANT: return clone, not original
    }

    public List<String> listTemplates() {
        List<String> keys = new ArrayList<>(templates.keySet());
        Collections.sort(keys);
        return keys;
    }
}