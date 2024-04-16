package model;

import lombok.Data;

@Data

public class VueloDto {

	private Long id;
	
	private String origen;
	
	private String destino;
	
	private String fechaHoraDeSalida;
	
	private String fechaHoraLlegada;
	
	private double converterPrecio;
	
	private String frecuencia;
	
	
	
}
