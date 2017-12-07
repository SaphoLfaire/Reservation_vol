package model;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;


public enum TypeAvion {
	A330 ("A330"), A340 ("A340"), A380 ("A380"), B747 ("B747");
	
	private String typeAvion = "";
	
	TypeAvion (String typeAvion){
		this.typeAvion = typeAvion;
	}

}
