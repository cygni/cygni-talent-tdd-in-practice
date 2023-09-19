package se.cygni.quiztddworkshop.tutorial;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = HeroController.class)
public class HeroControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private HeroService heroService;

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
    void findAllHeroesInPool() throws Exception {
        given(heroService.findAllHeroes()).willReturn(List.of(axe, phantomAssassin));
        mockMvc.perform(get("/api/hero/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

}
