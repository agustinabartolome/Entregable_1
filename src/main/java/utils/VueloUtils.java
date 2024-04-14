package utils;

import java.util.ArrayList;
import java.util.List;

import model.Vuelo;

public class VueloUtils {
	
public List<Vuelo> detectedOfertas( List <Vuelo> vuelos,Integer preciosOfertas){
		
		
		List <Vuelo> ofertasVuelos = new ArrayList<>();
		
		for (Vuelo vuelo : vuelos) {
			
			if (vuelo.getPrecio() < preciosOfertas) {
				
				ofertasVuelos.add(vuelo);
			}
			
		}
		
		return ofertasVuelos;
	}

}
