package se.cygni.quiztddworkshop.tutorial;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HeroModel {
    private Long id;
    private String name;
    private String unitResponse;
    private HeroEntity.Attribute mainAttribute;
    private int strength;
    private int agility;
    private int intelligence;
    private int damage;
}
