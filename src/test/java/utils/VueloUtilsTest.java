package utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import model.Vuelo;

class VueloUtilsTest {

	/*
	@Test
	void test() {
		fail("Not yet implemented");
	}
	 */

	@Autowired
	VueloUtils vueloUtils;
	
	@Test
	public void detectedOfertasTest() {
		
		List<Vuelo> vueloList = new ArrayList();
		
		//Completar
		
		//Vuelo vuelo1 = new vuelo(1L, " ", " ", " ", " ", 400.00, " ");
	}

}
