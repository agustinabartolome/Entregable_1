package repository;

import java.util.List;
import java.util.Optional;

import model.Flight;
import model.FlightDto;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	List <Flight> findByOrigen(String origen);
	
	List <Flight> findByOrigenAndDestino(String origen, String destino);

	//List<Flight> findByIdCompanyAndId(Long idCompany, Long id);


	Optional<Flight> findByIdCompanyAndId(Long idCompany, Flight flight);

	FlightDto getFlightDetailsById(Long id);
}

