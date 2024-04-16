package model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity

public class Company {
	
	private Long idCompany;
	
	private String nombre;
	
	private String banner;
	
	private String admitenMascotas;
	
	

	public Company () {
		
	}



	public Long getIdCompany() {
		return idCompany;
	}



	public void setIdCompany(Long idCompany) {
		this.idCompany = idCompany;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getBanner() {
		return banner;
	}



	public void setBanner(String banner) {
		this.banner = banner;
	}



	public String getAdmitenMascotas() {
		return admitenMascotas;
	}



	public void setAdmitenMascotas(String admitenMascotas) {
		this.admitenMascotas = admitenMascotas;
	}
}
