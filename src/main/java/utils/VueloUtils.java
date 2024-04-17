package utils;

import java.util.ArrayList;
import java.util.List;

import model.Dolar;
import model.Vuelo;
import model.VueloDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class VueloUtils {
	
public List<Vuelo> detectedOfertas( List <Vuelo> vuelos,double preciosOfertas){
		
		
		List <Vuelo> ofertasVuelos = new ArrayList<>();
		
		for (Vuelo vuelo : vuelos) {
			
			if (vuelo.getPrecio() < preciosOfertas) {
				
				ofertasVuelos.add(vuelo);
			}
			
		}
		
		return ofertasVuelos;
	}

	public List <VueloDto> vueloMapper (List <Vuelo> vuelos, double precio){

	List <VueloDto> vueloDto = new ArrayList<>();
	for ( Vuelo vuelo:vuelos){
	vueloDto.add(new VueloDto(
			vuelo.getId(),
			vuelo.getOrigen(),
			vuelo.getDestino(),
			vuelo.getFechaHoraSalida(),
			vuelo.getFechaHoraLlegada(),
			vuelo.getPrecio() * precio,

			vuelo.getFrecuencia()));
	}
return vueloDto;
	}

	@Bean

	public RestTemplate restTemplate() {

		return new RestTemplate();
	}


	public Dolar fetchDolar() {

		RestTemplate restTemplate = restTemplate();

		String apiUrl = "https://dolarapi.com/v1/dolares/tarjeta";

		return restTemplate.getForObject(apiUrl, Dolar.class);
	}


}
