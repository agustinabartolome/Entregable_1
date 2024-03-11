package repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

@Repository
public interface VueloRepository extends JPARepository<Vuelo, Long>{
	
	

}
