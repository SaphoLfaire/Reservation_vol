package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = { "numVol" }))
public class Vol {

	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@NotBlank
	private String numVol;
	
	@Column
	@NotNull
	@Enumerated(EnumType.STRING)
	private TypeAvion typeAvion;
	
	@Column
	@NotBlank
	private String nmPlace;
	
	@Column
	@NotBlank
	private String villeDepart;
	
	@Column
	@NotBlank
	private String villeArrivee;
	
	@Column
	@NotNull
	private LocalDate dateDepart;

	@OneToMany (mappedBy = "vol")
	private List<Reservation> resList = new ArrayList<>();

	public Vol() {

	}

	public String getNumVol() {
		return numVol;
	}

	public TypeAvion getTypeAvion() {
		return typeAvion;
	}

	public String getNmPlace() {
		return nmPlace;
	}

	public String getVilleDepart() {
		return villeDepart;
	}

	public String getVilleArrivee() {
		return villeArrivee;
	}

	public LocalDate getDateDepart() {
		return dateDepart;
	}

	public void setNumVol(String numVol) {
		this.numVol = numVol;
	}

	public void setTypeAvion(TypeAvion typeAvion) {
		this.typeAvion = typeAvion;
	}

	public void setNmPlace(String nmPlace) {
		this.nmPlace = nmPlace;
	}

	public void setVilleDepart(String villeDepart) {
		this.villeDepart = villeDepart;
	}

	public void setVilleArrivee(String villeArrivee) {
		this.villeArrivee = villeArrivee;
	}

	public void setDateDepart(LocalDate dateDepart) {
		this.dateDepart = dateDepart;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Reservation> getResList() {
		return resList;
	}

	public void setResList(List<Reservation> resList) {
		this.resList = resList;
	}
	
	public void addResList (Reservation res) {
		resList.add(res);
	}

	@Override
	public String toString() {
		return numVol + "   |" + typeAvion + " |" +resList.size()+ "/"+ nmPlace + "       |"
				+ villeDepart + " |" + villeArrivee + " |" + dateDepart + "\n";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateDepart == null) ? 0 : dateDepart.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nmPlace == null) ? 0 : nmPlace.hashCode());
		result = prime * result + ((numVol == null) ? 0 : numVol.hashCode());
		result = prime * result + ((resList == null) ? 0 : resList.hashCode());
		result = prime * result + ((typeAvion == null) ? 0 : typeAvion.hashCode());
		result = prime * result + ((villeArrivee == null) ? 0 : villeArrivee.hashCode());
		result = prime * result + ((villeDepart == null) ? 0 : villeDepart.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Vol other = (Vol) obj;
		if (dateDepart == null) {
			if (other.dateDepart != null)
				return false;
		} else if (!dateDepart.equals(other.dateDepart))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nmPlace == null) {
			if (other.nmPlace != null)
				return false;
		} else if (!nmPlace.equals(other.nmPlace))
			return false;
		if (numVol == null) {
			if (other.numVol != null)
				return false;
		} else if (!numVol.equals(other.numVol))
			return false;
		if (resList == null) {
			if (other.resList != null)
				return false;
		} else if (!resList.equals(other.resList))
			return false;
		if (typeAvion != other.typeAvion)
			return false;
		if (villeArrivee == null) {
			if (other.villeArrivee != null)
				return false;
		} else if (!villeArrivee.equals(other.villeArrivee))
			return false;
		if (villeDepart == null) {
			if (other.villeDepart != null)
				return false;
		} else if (!villeDepart.equals(other.villeDepart))
			return false;
		return true;
	}

	
}
