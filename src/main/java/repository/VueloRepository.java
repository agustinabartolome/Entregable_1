package repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{
	
	List <Vuelo> findByOrigen(String origen);
	
	List <Vuelo> findByOrigenAndDestino(String origen, String destino);

	//List<Vuelo> findByIdCompanyAndId(Long idCompany, Long id);


	Optional<Vuelo> findByIdCompanyAndId(Long idCompany, Vuelo vuelo);
}

