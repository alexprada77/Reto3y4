package co.usa.ciclo3.ciclo3.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="game")
@JsonPropertyOrder({"id","name","developer","year","description","category","messages","reservations"})
public class Game implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="developer", nullable=false, length=45)
	private String developer;
	private int year;
	@ManyToOne
	@JoinColumn(name="category_id")
	@JsonIgnoreProperties("games")
	private Category category;

	@Column(name="name", nullable=false, length=45)
	private String name;
	@Column(name="description", nullable=true, length=250)
	private String description;
	
	@OneToMany(cascade= {CascadeType.PERSIST}, mappedBy="game")
	@JsonIgnoreProperties({"game","client"})
	private List<Message> messages;
	@OneToMany(cascade= {CascadeType.PERSIST}, mappedBy="game")
	@JsonIgnoreProperties("game")
	private List<Reservation> reservations;


	public Game() {
		messages = new ArrayList<Message>();
		reservations = new ArrayList<Reservation>();
	}
	
	public Game(Integer id, String developer,int year, Category category_Id, String name, String description) {
		this.id = id;
		this.developer = developer;
		this.year=year;
		this.category = category_Id;
		this.name = name;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category categoryId) {
		this.category = categoryId;
	}

	public List<Message> getMessages() {
		return messages;
	}
	public List<Reservation> getReservations() {
		return reservations;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", developer=" + developer + ", year=" + year + ", categoryId=" + category
				+ ", name=" + name + ", description=" + description + "]";
	}
	
	
	
}
