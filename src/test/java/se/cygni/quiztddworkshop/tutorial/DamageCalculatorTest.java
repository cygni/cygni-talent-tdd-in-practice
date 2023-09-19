package se.cygni.quiztddworkshop.tutorial;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;


@ExtendWith(MockitoExtension.class)
public class DamageCalculatorTest {

    private static HeroEntity axe;

    @InjectMocks
    private HeroService heroService;

    @BeforeAll
    static void spawnAxe() {
        axe = new HeroEntity();
        axe.setName("Mogul Khan");
        axe.setMainAttribute(HeroEntity.Attribute.STR);
        axe.setUnitResponse("Axe likes this very much!");
        axe.setAgility(1);
        axe.setIntelligence(1);
        axe.setStrength(1);
    }

    @Test
    void axesDamageShouldScaleWithStrength() {
        // arrange - axe spawns (beforeAll) and levels up
        axe.setStrength(2);

        // act - calculate new damage
        var axeLevel2 = heroService.calculateDamage(axe);

        // assert - damage has scaled with strength
        assertEquals(2, axeLevel2.getDamage());
    }
}
