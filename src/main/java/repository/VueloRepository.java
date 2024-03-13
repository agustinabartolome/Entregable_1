package repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

import model.Vuelo;

@Repository
public interface VueloRepository extends JpaRepository<Vuelo, Long>{
	
	

}

