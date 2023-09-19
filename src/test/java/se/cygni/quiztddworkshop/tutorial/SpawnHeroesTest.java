package se.cygni.quiztddworkshop.tutorial;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class SpawnHeroesTest {
    // This is stubbed or mocked since not under test
    @Mock
    HeroRepository heroRepository;

    // This is under test and injected
    @InjectMocks
    HeroService heroService;

    private static HeroEntity axe;
    private static HeroEntity phantomAssassin;
    @BeforeAll
    static void spawnHeroes() {
        axe = new HeroEntity();
        axe.setName("Mogul Khan");
        axe.setMainAttribute(HeroEntity.Attribute.STR);
        axe.setUnitResponse("Axe likes this very much!");
        axe.setAgility(1);
        axe.setIntelligence(1);
        axe.setStrength(1);

        phantomAssassin = new HeroEntity();
        phantomAssassin.setName("Mortred");
        phantomAssassin.setMainAttribute(HeroEntity.Attribute.AGI);
        phantomAssassin.setUnitResponse("Out of the veil");
        phantomAssassin.setAgility(1);
        phantomAssassin.setIntelligence(1);
        phantomAssassin.setStrength(1);
    }


    @Test
    void spawnAnyHeroAndVerifyAxeInPool() {
        // arrange - axe will always spawn!
        given(heroRepository.save(any(HeroEntity.class))).willReturn(axe);

        // act - spawn axe
        var storedHero = heroService.storeHero(axe);

        // assert - yes it's axe!
        assertEquals(axe.getName(), storedHero.getName());
    }

    @Test
    void spawnAnyHeroAndVerifyPool() {
        // arrange - first argument is any instance of the HeroEntity Class
        given(heroRepository.save(any(HeroEntity.class))).willAnswer(i -> i.getArguments()[0]);

        // act
        var storedHero = heroService.storeHero(axe);
        var anotherHero = heroService.storeHero(phantomAssassin);

        // assert
        assertEquals(axe.getName(), storedHero.getName());
        assertEquals(phantomAssassin.getName(), anotherHero.getName());
    }

    @Test
    @DisplayName("Spawn two heroes in to the database, count persisted amount and verify names")
    void spawnTwoHeroesAndCountAndVerifyNames() {
        // arrange - see before all, stub return value of findAll
        given(heroRepository.findAll()).willReturn(List.of(axe, phantomAssassin));

        // act
        heroService.storeHero(axe);
        heroService.storeHero(phantomAssassin);

        // assert
        var heroCollection = heroRepository.findAll();
        assertThat(heroCollection.size()).isEqualTo(2);
        assertThat(heroCollection).extracting(HeroEntity::getName).contains("Mogul Khan", "Mortred");
    }
}
