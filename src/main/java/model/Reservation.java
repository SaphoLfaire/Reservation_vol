package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.validator.constraints.NotBlank;

@Entity

public class Reservation {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotBlank
	private String nom;
	
	@Column
	@NotBlank
	private String prenom;
	
	@Column
	@NotBlank
	private String age;

	@Column
	@NotBlank
	private String numRes;

	@ManyToOne
	private Vol vol;

	public Reservation() {

	}

	public String getNom() {
		return nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public String getAge() {
		return age;
	}

	public long getId() {
		return id;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Vol getVol() {
		return vol;
	}

	public void setNumVol(Vol numVol) {
		this.vol = numVol;
	}

	public String getNumRes() {
		return numRes;
	}

	public void setNumRes(String numRes) {
		this.numRes = numRes;
	}

	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", id=" + id + "]";
	}

}
