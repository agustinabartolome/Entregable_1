package model;

import java.time.LocalDate;

import lombok.Data;

@Data

public class Dolar {
	
	private String moneda;

	private String casa;
	
	private String nombre;
	
	private double compra;
	
	private double venta;
	
	private LocalDate fechaDeActualizacion;
	
	

	public double getCompra() {
		return compra;
	}

	public void setCompra(double compra) {
		this.compra = compra;
	}
	
	public double getVenta() {
		return venta;
	}

	public void setVenta(double venta) {
		this.venta = venta;
	}
	
	public double getPromedio() {
		
		return ((getCompra() + getVenta())/2);
	}
	
	
	
	
}
