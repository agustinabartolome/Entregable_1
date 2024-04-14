package repository;

import java.util.List;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{
	
	List <Vuelo> findByOrigen(String origen);
	
	List <Vuelo> findByOrigenAndDestino(String origen, String destino);
	
	
	

}

