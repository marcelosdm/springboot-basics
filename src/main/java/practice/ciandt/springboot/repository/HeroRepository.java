package practice.ciandt.springboot.repository;

import org.springframework.stereotype.Repository;
import practice.ciandt.springboot.domain.Hero;

import java.util.List;

@Repository
public interface HeroRepository {
    List<Hero> listAll();
}
