package practice.ciandt.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.ciandt.springboot.domain.Hero;
import practice.ciandt.springboot.service.HeroesService;
import practice.ciandt.springboot.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("heroes")
@Log4j2
@RequiredArgsConstructor
public class HeroController {
    private final DateUtil dateUtil;
    private final HeroesService heroesService;

    @GetMapping
    public ResponseEntity<List<Hero>> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return ResponseEntity.ok(heroesService.listAll());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Hero> findById(@PathVariable long id) {
        return ResponseEntity.ok(heroesService.findById(id));
    }
}
