package se.cygni.quiztddworkshop.tutorial;

import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Builder;
import lombok.Data;

import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;

@Data
@Entity
public class HeroEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String unitResponse;
    private Attribute mainAttribute;
    private int strength;
    private int agility;
    private int intelligence;
    private int damage;


    @Data
    public static class Stats {
        private int strength;
        private int agility;
        private int intelligence;

    }
    /**
     * STR - Strength (hp)
     * AGI - Agility (armor)
     * INT - Intelligence (mana)
     * UNI - Universal (damage)
     **/
    public enum Attribute {
        STR,
        AGI,
        INT,
        UNI
    };
}
