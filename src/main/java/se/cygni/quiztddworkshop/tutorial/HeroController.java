package se.cygni.quiztddworkshop.tutorial;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hero")
@RequiredArgsConstructor
public class HeroController {

    private final HeroService heroService;

    @GetMapping("/all")
    public ResponseEntity<List<HeroModel>> findAllHeroesInPool() {
        var allHeroes = heroService.findAllHeroes();
        var allHeroModelList = new ArrayList<HeroModel>();
        allHeroes.forEach(hero -> {
            var heroModel = HeroModel.builder()
                    .id(hero.getId())
                    .name(hero.getName())
                    .damage(hero.getDamage())
                    .mainAttribute(hero.getMainAttribute())
                    .build();
            allHeroModelList.add(heroModel);
        });
        return ResponseEntity.ok(allHeroModelList);
    }
}
