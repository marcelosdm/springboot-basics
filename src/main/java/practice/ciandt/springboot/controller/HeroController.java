package practice.ciandt.springboot.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import practice.ciandt.springboot.domain.Hero;
import practice.ciandt.springboot.util.DateUtil;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("hero")
@Log4j2
@RequiredArgsConstructor
public class HeroController {

    private final DateUtil dateUtil;

    @GetMapping(path = "list")
    public List<Hero> list() {
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return List.of(new Hero("Superman"), new Hero("Batman"));
    }
}
