package se.cygni.quiztddworkshop.tutorial;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class HeroEntity {
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String unitResponse;
    private Attribute attribute;

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
