package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Message;
import co.usa.ciclo3.ciclo3.repository.MessageRepository;

@Service
public class MessageService {
	@Autowired
	private MessageRepository messageRepository;
	
	public Message saveMessage(Message message) {
		return messageRepository.save(message);
	}
	
	public List<Message> getAll(){
		return messageRepository.findAll();
	}
	public Optional<Message> getMessage(int id){
		return messageRepository.findById(id);
	}
	public Message updateMessage(Message message) {
		if(message.getIdMessage()!=null) {
			Optional<Message> msg= getMessage(message.getIdMessage());
			if(msg.isPresent()) {
				if(message.getMessageText()!=null) {
					msg.get().setMessageText(message.getMessageText());
					
				}
				return saveMessage(msg.get());
			}
		}
		return message;
	}
	public boolean deleteMessage(int IdMessage) {
		Optional<Message> msg= getMessage(IdMessage);
		if(msg.isPresent()) {
			messageRepository.delete(msg.get());
			return true;
		}
		return false;
	}
}
