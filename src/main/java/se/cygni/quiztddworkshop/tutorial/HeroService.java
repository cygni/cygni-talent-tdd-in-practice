package se.cygni.quiztddworkshop.tutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HeroService {
    private final static int DAMAGE_FACTOR = 1;
    private final static float UNIVERSAL_DAMAGE_FACTOR = 0.7f;

    private final HeroRepository heroRepository;

    public HeroEntity storeHero(HeroEntity hero) {
        return heroRepository.save(hero);
    }

    public HeroEntity calculateDamage(HeroEntity hero) {
        int damage;
        switch(hero.getMainAttribute()) {
            default -> damage = 0;
            case STR-> damage = attributeToDamage(hero.getStrength());
            case AGI-> damage = attributeToDamage(hero.getAgility());
            case INT-> damage = attributeToDamage(hero.getIntelligence());
            case UNI -> damage = allAttributesToDamage(hero);
        }
        hero.setDamage(damage);
        // persist the change (...)
        return hero;
    }

    private int attributeToDamage(int attributePoints) {
        return attributePoints * DAMAGE_FACTOR;
    }

    private int allAttributesToDamage(HeroEntity hero) {
        var sumOFAttributes = hero.getAgility() + hero.getStrength() + hero.getIntelligence();
        return (int) Math.floor(sumOFAttributes * UNIVERSAL_DAMAGE_FACTOR);
    }

    public List<HeroEntity> findAllHeroes() {
        return heroRepository.findAll();
    }
}
