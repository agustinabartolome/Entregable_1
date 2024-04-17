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

    public Long getIdCompany;
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

	/*
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



	@Override
	public String toString() {
		return "Company [idCompany=" + idCompany + ", nombre=" + nombre + ", banner=" + banner + ", admitenMascotas="
				+ admitenMascotas + "]";
	}
	*/
	
}
