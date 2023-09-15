package se.cygni.quiztddworkshop.tutorial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JpaSliceTest {
    @Autowired
    private HeroRepository heroRepository;

    @Test
    void aVerySimpleAxeTest() {
        // arrange
        var axe = new HeroEntity();
        axe.setName("Mogul Khan");
        axe.setAttribute(HeroEntity.Attribute.STR);
        axe.setUnitResponse("Axe likes this very much!");
        heroRepository.save(axe);

        // act
        var heroes = heroRepository.findAll();

        // assert
        assertThat(heroes).extracting(HeroEntity::getName).contains("Mogul Khan");
        //assertThat(axe.getAttribute()).isEqualByComparingTo(HeroEntity.Attribute.STR).i
    }


}
