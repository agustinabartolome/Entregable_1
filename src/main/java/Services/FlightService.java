package Services;
import java.util.List;
import java.util.Optional;

import model.Flight;
import model.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Dolar;
import repository.CompanyRepository;
import repository.FlightRepository;
import utils.FlightUtils;

@Service

public class FlightService {
	
	
	@Autowired
	FlightRepository flightRepository;

	
	@Autowired
	FlightUtils flightUtils;
	
	@Autowired
	CompanyRepository companyRepository;

	/*
	public List<Flight> getAllVuelos() {
		
		return flightRepository.findAll();
	}
	*/

	public List<FlightDto> getAllVuelos() {

	double precio = getDolarPrecio();
	List <Flight> flights = flightRepository.findAll();

		return flightUtils.vueloMapper(flights, precio);
	}
	
	public void crearVuelo(Flight flight) {
		flightRepository.save(flight);
	}

	/* Esta es una de las opciones de uso, utilizando .orElse(null) o se aplica directamente optional.
	
	public Flight findVueloById(Long Id) {
		
		return flightRepository.findById(Id).orElse(null);
	}

	*/
	
	public Optional <Flight> findById (Long Id) {
		
		return flightRepository.findById(Id);
	}
	
	
	public void deleteVueloById(Long Id) {
		
		flightRepository.deleteById(Id);
	
	}

	/* Esta es una de las opciones de uso, utilizando .orElse(null) o se aplica directamente optional.

	public Flight actualizarVuelo(Flight vuelo) {
	
		flightRepository.save(vuelo);
		return flightRepository.findById(vuelo.getId()).orElse(null);
	}

	 */
	
	public Optional <Flight> actualizarVuelo (Flight flight) {
		
		flightRepository.save(flight);
		
		return flightRepository.findById(flight.getId());
	}
	
	
	public List<Flight> getVueloByOrigen (String origen) {
		
		return flightRepository.findByOrigen(origen);
	}
	
	
	public List<Flight> getVueloByOrigenAndDestino (String origen, String destino) {
		
		return flightRepository.findByOrigenAndDestino(origen, destino);
	}

	/* Para que el código no sea repetitivo, trasladamos esta selección hacia el paquete utils. 
	 * Desde allí podrá utilizarse en todo el proyecto. 

	public List<Flight> getOfertas(Integer preciosOfertas){
		
		List<Flight> vuelos = flightRepository.findAll();
		
		List <Flight> ofertasVuelos = new ArrayList<>();
		
		for (Flight vuelo : vuelos) {
			
			if (vuelo.getPrecio() < preciosOfertas) {
				
				ofertasVuelos.add(vuelo);
			}
			
		}
		
		return ofertasVuelos;
	}
	
	*/
	
	
	public List<Flight> getOfertas(Integer preciosOfertas){
		
		List<Flight> flights = flightRepository.findAll();
		
		return flightUtils.detectedOfertas(flights, preciosOfertas);
		
	}


	/*
	public Dolar getDolar() {

		return vueloConfiguration.fetchDolar();
	}

	*/
	
	public double getDolarPrecio() {

		Dolar dolar = flightUtils.fetchDolar();
		return dolar.getPromedio();
	}

	public Optional<Flight> crearVueloConCompania(Long idCompany, Flight flight) {
		//return companyRepository.findByIdCompanyAndId(idCompany, flight);

		return flightRepository.findByIdCompanyAndId(idCompany, flight);
	}


	public FlightDto getFlightDetails(Long id) {
		return flightRepository.getFlightDetailsById(id);
	}


}
