package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@Entity
@Table(name="message")
@JsonPropertyOrder({"idMessage","messageText","game","client"})
public class Message implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_message", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idMessage;
	@Column(name="message_text", nullable=false, length=250)
	private String messageText;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="game_id")
	@JsonIgnoreProperties({"messages","reservations"})
	private Game game;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties({"messages","reservations"})
	private Client client;

	public Message() {}
	
	

	public Message(Integer idMessage, String messageText, Game game, Client client) {
		this.idMessage = idMessage;
		this.messageText = messageText;
		this.game = game;
		this.client = client;
	}



	public Integer getIdMessage() {
		return idMessage;
	}

	public void setIdMessage(Integer idMessage) {
		this.idMessage = idMessage;
	}

	public String getMessageText() {
		return messageText;
	}

	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	
	
	
	

}
