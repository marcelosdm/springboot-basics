package practice.ciandt.springboot.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import practice.ciandt.springboot.domain.Hero;

import java.util.List;

@Service
public class HeroesService {

    private final List<Hero> heroes = List.of(new Hero(1L, "Superman"), new Hero(2L, "Batman"));

    public List<Hero> listAll() {
        return heroes;
    }

    public Hero findById(long id) {
        return heroes.stream()
                .filter(hero -> hero.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Hero not found"));
    }
}
