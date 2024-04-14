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

public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String origen;
	
	private String destino;
	
	private String fechaHoraSalida;
	
	private String fechaHoraLlegada;
	
	private double precio;
	
	private String frecuencia;
	
	
	private Integer preciosOfertas;
	
	public Vuelo() {
		
	}

	public Vuelo(long id,  String origen, String destino, String fechaHoraSalida, 
			String fechaHoraLlegada, double precio, String frecuencia) {
		
		this.id = id;
		this.origen = origen;
		this.destino = destino;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.precio = precio;
		this.frecuencia = frecuencia;
				
	}
	
	public Vuelo( String origen, String destino, String fechaHoraSalida, 
			String fechaHoraLlegada, double precio, String frecuencia) {
		
		this.origen = origen;
		this.destino = destino;
		this.fechaHoraSalida = fechaHoraSalida;
		this.fechaHoraLlegada = fechaHoraLlegada;
		this.precio = precio;
		this.frecuencia = frecuencia;
				
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

	@Override
	public String toString() {
		return "Vuelo [id=" + id + ", origen=" + origen + ", destino=" + destino + ", fechaHoraSalida="
				+ fechaHoraSalida + ", fechaHoraLlegada=" + fechaHoraLlegada + ", precio=" + precio + ", frecuencia="
				+ frecuencia + "]";
	}

	public Integer getPreciosOfertas() {
		return preciosOfertas;
	}

	public void setPreciosOfertas(Integer preciosOfertas) {
		this.preciosOfertas = preciosOfertas;
	}

	
	
	
	
}
