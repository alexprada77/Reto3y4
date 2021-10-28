package co.usa.ciclo3.ciclo3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import co.usa.ciclo3.ciclo3.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> {

}
