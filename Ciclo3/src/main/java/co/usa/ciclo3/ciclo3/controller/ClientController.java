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

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.service.ClientService;

@RestController
@RequestMapping("/api/Client")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE}) 
public class ClientController {

	@Autowired
	private ClientService clientService;
	
	@GetMapping("/all")
	public List<Client> getClients() {
		return clientService.getAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Client insertClient(@RequestBody Client client) {
		try {
			return clientService.saveClient(client);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{idClient}")
	public Optional<Client> getClient(@PathVariable("idClient") int clientId) {
		return clientService.getClient(clientId);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Client updateClient(@RequestBody Client client) {
		try {
			return clientService.updateClient(client);
		} catch (Exception e) {
			return null;
		}
	}
	@DeleteMapping("/{idClient}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteClient(@PathVariable("idClient") int clientId) {
		return clientService.deleteClient(clientId);
		
	}
	
}
