package model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class VueloDto {

	private Long id;
	
	private String origen;
	
	private String destino;
	
	private String fechaHoraSalida;
	
	private String fechaHoraLlegada;

	private double convertedPrecio;
	
	private String frecuencia;

	private Company company;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getConvertedPrecio() {
		return convertedPrecio;
	}

	public void setConvertedPrecio(double convertedPrecio) {
		this.convertedPrecio = convertedPrecio;
	}

	public VueloDto(Long id, String origen, String destino, String fechaHoraSalida, String fechaHoraLlegada, double convertedPrecio, String frecuencia) {
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.convertedPrecio = convertedPrecio;
		this.frecuencia = frecuencia;
	}

}
