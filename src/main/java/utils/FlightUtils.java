package utils;

import java.util.ArrayList;
import java.util.List;

import model.Dolar;
import model.Flight;
import model.FlightDto;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class FlightUtils {
	
public List<Flight> detectedOfertas(List <Flight> flights, double preciosOfertas){
		
		
		List <Flight> ofertasFlights = new ArrayList<>();
		
		for (Flight flight : flights) {
			
			if (flight.getPrecio() < preciosOfertas) {
				
				ofertasFlights.add(flight);
			}
			
		}
		
		return ofertasFlights;
	}

	public List <FlightDto> vueloMapper (List <Flight> flights, double precio){

	List <FlightDto> flightDto = new ArrayList<>();
	for ( Flight flight : flights){
	flightDto.add(new FlightDto(
			flight.getId(),
			flight.getOrigen(),
			flight.getDestino(),
			flight.getFechaHoraSalida(),
			flight.getFechaHoraLlegada(),
			flight.getPrecio() * precio,

			flight.getFrecuencia()));
	}
return flightDto;
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
