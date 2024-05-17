package model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Optional;

@AllArgsConstructor
//@NoArgsConstructor
@Data
@Builder
@Entity

public class Flight {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String origen;
	
	private String destino;
	
	private String fechaHoraSalida;
	
	private String fechaHoraLlegada;
	
	private double precio;
	
	private String frecuencia;

	@ManyToOne
	@JoinColumn (name = "id_company")

	private Company company;


	public Flight(String origen, String destino, String fechaHoraSalida,
				  String fechaHoraLlegada, double precio, String frecuencia) {

		this.origen = origen;
		this.destino = destino;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.precio = precio;
		this.frecuencia = frecuencia;

	}

	public Flight() {

	}


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getOrigen() {
		return origen;
	}


	public void setOrigen(String origen) {
		this.origen = origen;
	}


	public String getDestino() {
		return destino;
	}


	public void setDestino(String destino) {
		this.destino = destino;
	}


	public String getFechaHoraSalida() {
		return fechaHoraSalida;
	}


	public void setFechaHoraSalida(String fechaHoraSalida) {
		this.fechaHoraSalida = fechaHoraSalida;
	}


	public String getFechaHoraLlegada() {
		return fechaHoraLlegada;
	}


	public void setFechaHoraLlegada(String fechaHoraLlegada) {
		this.fechaHoraLlegada = fechaHoraLlegada;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double precio) {
		this.precio = precio;
	}


	public String getFrecuencia() {
		return frecuencia;
	}


	public void setFrecuencia(String frecuencia) {
		this.frecuencia = frecuencia;
	}


	public void setCompany(Optional<Company> company) {

	}

}
