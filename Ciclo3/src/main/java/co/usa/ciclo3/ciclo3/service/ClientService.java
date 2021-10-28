package co.usa.ciclo3.ciclo3.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.usa.ciclo3.ciclo3.model.Client;
import co.usa.ciclo3.ciclo3.repository.ClientRepository;

@Service
public class ClientService {
	@Autowired
	private ClientRepository clientRepository;
	
	public Client saveClient(Client client) {
		return clientRepository.save(client);
	}
	
	public List<Client> getAll(){
		return clientRepository.findAll();
	}
	public Optional<Client> getClient(int id){
		return clientRepository.findById(id);
	}
	
	public Client updateClient(Client client) {
		if(client.getIdClient()!=null) {
			Optional<Client> cliente= getClient(client.getIdClient());
			if(cliente.isPresent()) {
				if(client.getPassword()!=null) {
					cliente.get().setPassword(client.getPassword());
				}
				if(client.getAge()>0) {
					cliente.get().setAge(client.getAge());
				}
				if(client.getName()!=null) {
					cliente.get().setName(client.getName());
				}
				return saveClient(cliente.get());
			}
		}
		return client;
	}
	
	public boolean deleteClient(int id) {
		Optional<Client> cliente= getClient(id);
		if(cliente.isPresent()) {
			clientRepository.delete(cliente.get());
			return true;
		}
		return false;
	}
}
