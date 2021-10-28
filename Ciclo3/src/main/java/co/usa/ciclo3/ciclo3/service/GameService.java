package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Game;
import co.usa.ciclo3.ciclo3.repository.GameRepository;

@Service
public class GameService {
	@Autowired
	private GameRepository gameRepository;
	
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}
	
	public List<Game> getAll(){
		return gameRepository.findAll();
	}
	public Optional<Game> getGame(int id){
		return gameRepository.findById(id);
	}
	
	public Game updateGame(Game game) {
		if(game.getId()!=null) {
			Optional<Game> gam= getGame(game.getId());
			if(gam.isPresent()) {
				if(game.getName()!=null) {
					gam.get().setName(game.getName());
				}
				if(game.getDeveloper()!=null) {
					gam.get().setDeveloper(game.getDeveloper());
				}
				if(game.getYear()!=0) {
					gam.get().setYear(game.getYear());
				}
				if(game.getDescription()!=null) {
					gam.get().setDescription(game.getDescription());
				}
				return saveGame(gam.get());
			}
		}
		return game;
	}
	
	public boolean deleteGame(int id) {
		Optional<Game> game= getGame(id);
		if(game.isPresent()) {
			gameRepository.delete(game.get());
			return true;
		}
		return false;
	}
}
