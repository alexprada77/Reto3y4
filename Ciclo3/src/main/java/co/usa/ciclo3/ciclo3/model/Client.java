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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@Entity
@Table(name="client")
@JsonPropertyOrder({"idClient","email","password","name","age","messages","reservations"})
public class Client implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_client", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer idClient;
	@Column(name="name", nullable=true, length=250)
	private String name;
	@Column(name="email", nullable=true, length=45)
	private String email;
	@Column(name="age")
	private int age;
	@Column(name="password", nullable=true, length=45)
	private String password;
	
	@OneToMany(cascade= {CascadeType.PERSIST}, mappedBy="client")
	//@JsonIgnoreProperties("category")
	private List<Message> messages;

	@OneToMany(cascade= {CascadeType.PERSIST}, mappedBy="client")
	//@JsonIgnoreProperties("category")
	private List<Reservation> reservations;

	public Client() {
		messages = new ArrayList<Message>();
		reservations = new ArrayList<Reservation>();
	}

	public Client(Integer id, String name, String email,int age,String password) {
		this.idClient = id;
		this.name = name;
		this.email = email;
		this.age = age;
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public List<Message> getMessages() {
		return messages;
	}

	public List<Reservation> getReservations() {
		return reservations;
	}

	public Integer getIdClient() {
		return idClient;
	}

	public void setIdClient(Integer idClient) {
		this.idClient = idClient;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [idClient=" + idClient + ", name=" + name + ", email=" + email + ", age=" + age + ", password="
				+ password + "]";
	}

}
