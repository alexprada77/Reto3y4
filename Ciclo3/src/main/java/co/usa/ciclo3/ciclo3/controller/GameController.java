package co.usa.ciclo3.ciclo3.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import co.usa.ciclo3.ciclo3.model.Game;
import co.usa.ciclo3.ciclo3.service.GameService;

@RestController
@RequestMapping("/api/Game")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE}) 
public class GameController {

	@Autowired
	private GameService gameService;
	
	@GetMapping("/all")
	public List<Game> getGames() {
		return gameService.getAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Game insertGame(@RequestBody Game game) {
		try {
			return gameService.saveGame(game);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{id}")
	public Optional<Game> getGame(@PathVariable("id") int gameId) {
		return gameService.getGame(gameId);
	}
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Game updateGame(@RequestBody Game game) {
		try {
			return gameService.updateGame(game);
		} catch (Exception e) {
			return null;
		}
	}
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteGame(@PathVariable("id") int gameId) {
		return gameService.deleteGame(gameId);
		
	}
	
	
}
