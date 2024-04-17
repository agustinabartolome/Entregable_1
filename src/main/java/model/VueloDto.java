package model;

import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor

public class VueloDto {

	private Long id;
	
	private String origen;
	
	private String destino;
	
	private String fechaHoraDeSalida;
	
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
}
