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

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.service.MessageService;

@RestController
@RequestMapping("/api/Message")
@CrossOrigin(origins = "*",methods = {RequestMethod.PUT,RequestMethod.GET,RequestMethod.POST,RequestMethod.DELETE}) 
public class MessageController {

	@Autowired
	private MessageService messageService;
	
	@GetMapping("/all")
	public List<Message> getMessages() {
		return messageService.getAll();
	}
	
	@PostMapping("/save")
	@ResponseStatus(HttpStatus.CREATED)
	public Message insertMessage(@RequestBody Message message) {
		try {
			return messageService.saveMessage(message);
		} catch (Exception e) {
			return null;
		}
	}
	
	@GetMapping("/{idMessage}")
	public Optional<Message> getMessage(@PathVariable("idMessage") int messageId) {
		return messageService.getMessage(messageId);
	}
	
	@PutMapping("/update")
	@ResponseStatus(HttpStatus.CREATED)
	public Message updateMessage(@RequestBody Message message) {
		try {
			return messageService.updateMessage(message);
		} catch (Exception e) {
			return null;
		}
	}
	@DeleteMapping("/{idMessage}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public boolean deleteMessage(@PathVariable("idMessage") int messageId) {
		return messageService.deleteMessage(messageId);
		
	}
	
}
