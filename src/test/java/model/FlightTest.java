package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class FlightTest {
	
	/*

	@Test
	void test() {
		fail("Not yet implemented");
	}
	 */
	
	private static Flight flight;
	
	/*
	
	@Test
	public void SetAnGetOrigenTest() {
		
		String testedOrigen = "";
		
		flight.setOrigen(testedOrigen);
		System.out.println("Le asignamos el origen: " + testedOrigen);
		AssertThat(flight.getOrigen().equals(testedOrigen));
	}
	*/
	
	@Test
	public void SetAndGetOrigenTest() {
		
		String testedOrigen = "";
		
		flight.setOrigen(testedOrigen);
		flight.setOrigen("");
		System.out.println("Le asignamos el origen: " + testedOrigen);
		Assertions.assertEquals(flight.getOrigen(),testedOrigen);
	}
	
	@Test
	public void SetAndGetDestinoTest() {
		
		String testedDestino = "";
		
		flight.setDestino(testedDestino);
		
		Assertions.assertEquals(flight.getDestino(), testedDestino);
	}
	
	/*
	@BeforeAll
	public static void setUp() {
		System.out.println("Creacion del flight");
		flight = new Flight();
	}
	
	*/
	
	
}
