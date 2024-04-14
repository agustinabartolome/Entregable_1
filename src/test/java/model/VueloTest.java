package model;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.fasterxml.jackson.databind.Module.SetupContext;

class VueloTest {
	
	/*

	@Test
	void test() {
		fail("Not yet implemented");
	}
	 */
	
	private static Vuelo vuelo;
	
	/*
	
	@Test
	public void SetAnGetOrigenTest() {
		
		String testedOrigen = "";
		
		vuelo.setOrigen(testedOrigen);
		System.out.println("Le asignamos el origen: " + testedOrigen);
		AssertThat(vuelo.getOrigen().equals(testedOrigen));
	}
	*/
	
	@Test
	public void SetAndGetOrigenTest() {
		
		String testedOrigen = "";
		
		vuelo.setOrigen(testedOrigen);
		vuelo.setOrigen("");
		System.out.println("Le asignamos el origen: " + testedOrigen);
		Assertions.assertEquals(vuelo.getOrigen(),testedOrigen);
	}
	
	
	public void SetAndDestinoTest() {
		
		String testedDestino = "";
		
		vuelo.setDestino(testedDestino);
		
		Assertions.assertEquals(vuelo.getDestino(), testedDestino);
	}
	
	
	@BeforeAll
	public static void setUp() {
		System.out.println("Creacion del vuelo");
		vuelo = new Vuelo();
	}
	
	
	
	
}
