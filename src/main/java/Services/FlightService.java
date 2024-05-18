package Services;
import java.util.List;
import java.util.Optional;

import exceptions.ResourceNotFoundException;
import model.Company;
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


	public List<FlightDto> getAllVuelos() {

	double precio = getDolarPrecio();
	List <Flight> flights = flightRepository.findAll();

		return flightUtils.vueloMapper(flights, precio);
	}
	
	public void crearVuelo(Flight flight) {
		flightRepository.save(flight);
	}

	
	public Optional<FlightDto> findVueloById (Long Id) {

		return flightRepository.findVueloById(Id);
	}
	
	
	public void deleteVueloById(Long id) throws ResourceNotFoundException {
		Flight flight = flightRepository.findById(id).orElseThrow(() ->
				new ResourceNotFoundException("No se encontró el vuelo con identificación " + id));
		flightRepository.deleteById(flight.getId());
	
	}
	
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
	
	public List<Flight> getOfertas(Integer preciosOfertas){
		
		List<Flight> flights = flightRepository.findAll();
		
		return flightUtils.detectedOfertas(flights, preciosOfertas);
		
	}


	public double getDolarPrecio() {

		Dolar dolar = flightUtils.fetchDolar();
		return dolar.getPromedio();
	}

	public Optional <Flight> crearVueloConCompania(Long idCompany, Flight flight) {

		Optional<Company> company = companyRepository.findById(idCompany);

		flight.setCompany(company);
		return Optional.of(flightRepository.save(flight));
	}

	public FlightDto getFlightDetails(Long id) {
		return flightRepository.getFlightDetailsById(id);
	}


}
