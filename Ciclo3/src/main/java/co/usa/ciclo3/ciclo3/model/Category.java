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
@Table(name="category")
@JsonPropertyOrder({"id","name","description","games"})
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="id_category", nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	@Column(name="name", nullable=false, length=45)
	private String name;
	@Column(name="description", nullable=true, length=250)
	private String description;
	
	@OneToMany(cascade= {CascadeType.PERSIST}, mappedBy="category")
	//@JsonIgnoreProperties("category")
	private List<Game> games;
	
	public Category() {
		games = new ArrayList<Game>();
	}

	public Category(Integer id, String name, String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", description=" + description + "]";
	}

	public List<Game> getGames() {
		return games;
	}

	/*public void setGames(List<Game> games) {
		this.games = games;
	}*/
	
	
	

}
