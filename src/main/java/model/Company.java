package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Company {

    @Id

	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long idCompany;
	
	private String nombre;
	
	private String banner;
	
	private String admitenMascotas;


	public 	Company(String nombre, String banner, String admitenMascotas){

		this.nombre = nombre;
		this.banner = banner;
		this.admitenMascotas =admitenMascotas;
	}

	public Long getIdCompany() {
		return idCompany;
	}

	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}

	
}
