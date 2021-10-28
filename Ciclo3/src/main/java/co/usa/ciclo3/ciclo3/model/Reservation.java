package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

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
@Table(name="reservation")
@JsonPropertyOrder({"idReservation","startDate","devolutionDate","status","game","client","score"})
public class Reservation implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_reservation", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idReservation;
	@Column(name="date_start")
	private String startDate;
	@Column(name="devolution_date")
	private String devolutionDate;
	@Column(name="status")
	private String status;
	@Column(name="score", nullable=true)
	private String score;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="game_id")
	@JsonIgnoreProperties("reservations")
	private Game game;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="client_id")
	@JsonIgnoreProperties({"reservations","messages"})
	private Client client;

	public Reservation() {
		//this.status="created";
	}
	
	public Reservation(Integer idReservation, String startDate, String devolutionDate, String status, Game game,Client client) {
		this.idReservation = idReservation;
		this.startDate = startDate;
		this.devolutionDate = devolutionDate;
		this.status = status;
		this.game = game;
		this.client = client;
		//this.status="created";
	}
	public Integer getIdReservation() {
		return idReservation;
	}
	public void setIdReservation(Integer idReservation) {
		this.idReservation = idReservation;
	}
	public String getStartDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssz");
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
		Date fecha;
		try {
			String strFecha=startDate;
			fecha = sdf.parse(strFecha);
		} catch (ParseException e) {
			fecha=null;
		}
		System.out.println(sdf2.format(fecha));
		return sdf2.format(fecha).replace("GMT+00:00", "+00:00");
	}
	public void setStartDate(String startDate) {
		this.startDate=startDate;
	}
	public String getDevolutionDate() {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.sssz");
        sdf2.setTimeZone(TimeZone.getTimeZone("GMT+00:00"));
        Date fecha;
		try {
			String strFecha=devolutionDate+" 0000";
			fecha = sdf.parse(strFecha);
		} catch (ParseException e) {
			fecha=null;
		}
		System.out.println(sdf2.format(fecha));
		return sdf2.format(fecha).replace("GMT+00:00", "+00:00");
	}
	public void setDevolutionDate(String devolutionDate) {
		this.devolutionDate=devolutionDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
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
