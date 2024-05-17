package repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import model.Flight;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;


@DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class FlightRepositoryTest {
	
	/*

	@Test
	void test() {
		fail("Not yet implemented");
	}

*/
	
	@Autowired
	private FlightRepository flightRepository;
	
	@Autowired
	private Flight flight;
	
	@BeforeEach
	void setUp() {
		
		flight = new Flight("Jujuy", "Salta", "23:00", "02:00", 400.50, "Semanal");
	}
	
	@Test
	void saveVueloTest() {
		
		//Pasos
			//1)Configuración previa --> en este caso en el SetUp
			//2)Llamar a la funcionalidad
		
		Flight flightBD = flightRepository.save(flight);
		
			//3)Verificar salidad o comportamiento
		
		assertThat(flightBD).isNotNull();
		
		assertThat(flightBD.getId()).isGreaterThan(0);

	}
	
	/*
	 * Tener en cuenta que uno puede modificar el test para que la respuesta sea incorrecta y 
	 * obtener un error, como en este caso
	 
	 @Test
	void saveVueloTest() {
		
		//Pasos
			//1)Configuración previa --> en este caso en el SetUp
			//2)Llamar a la funcionalidad
		
		Flight vueloBD = flightRepository.save(flight);
		
			//3)Verificar salidad o comportamiento
		
		assertThat(vueloBD).isNull();
		
		assertThat(vueloBD.getId()).isGreaterThan(0);

	}
	 
	 */
	
	@Test
	void vueloFindByIdTest() {
		
		//Pasos
				//1)Configuración previa 
		
		flightRepository.save(flight);
		
				//2)Llamar a la funcionalidad
		
		Flight flightBD = flightRepository.findById(flight.getId()).get();
		
			//3)Verificar salidad o comportamiento
		
				assertThat(flightBD).isNotNull();
	}

	
	@Test
	void vueloGetAllTest() {
		
		//Pasos
			//1)Configuración previa 

		Flight flight2 = new Flight("Asuncion", "Iguazu", "15:00", "18:00", 500.50, "Diaria");
		
		flightRepository.save(flight);
		
		flightRepository.save(flight2);

			//2)Llamar a la funcionalidad

		List <Flight> flightList = flightRepository.findAll();

			//3)Verificar salidad o comportamiento

		assertThat(flightList).isNotNull();
		assertThat(flightList.size()).isEqualTo(2);
		
	}
	
	/*

@Test
	void vueloFindAllTest() {
		
		//Pasos
			//1)Configuración previa 

		Flight vuelo2 = new Flight("Jujuy", "Formosa", "16:00", "19:30", 500.50, "Semanal");
		
		flightRepository.save(flight);
		
		flightRepository.save(vuelo2);

			//2)Llamar a la funcionalidad

		List <Flight> vueloList = flightRepository.findAll();

			//3)Verificar salidad o comportamiento

		assertThat(vueloList).isNotNull();
		assertThat(vueloList.size()).isEqualTo(2);
		
	}
	
	*/
	/*
	 * Tener en cuenta que uno puede modificar el test para que la respuesta sea incorrecta y 
	 * obtener un error, como en este caso
	 
	 @Test
	void vueloFindAllTest() {
		
		//Pasos
			//1)Configuración previa 

		Flight vuelo2 = new Flight("Buenos Aires", "Santiago de Chile", "10:00", "13:00", 500.50, "");
		
		flightRepository.save(flight);
		
		flightRepository.save(vuelo2);

			//2)Llamar a la funcionalidad

		List <Flight> vueloList = flightRepository.findAll();

			//3)Verificar salidad o comportamiento

		assertThat(vueloList).isNotNull();
		assertThat(vueloList.size()).isEqualTo(1);

	}
	 
	 */


	@Test
	void vueloFindDeleteById() {
		
		//Pasos
			//1)Configuración previa 


		flightRepository.save(flight);
		

			//2)Llamar a la funcionalidad

		flightRepository.deleteById(flight.getId());

			//3)Verificar salidad o comportamiento

		Optional <Flight> deletedVuelo = flightRepository.findById(flight.getId());
		
		assertThat(deletedVuelo).isEmpty();

	}


	@Test
	void vueloActualizarTest() {
		
		flightRepository.save(flight);
		
		Flight flightBD = flightRepository.findById(flight.getId()).get();
		
		flightBD.setOrigen("Asuncion");
		flightBD.setDestino("Iguazu");
		
		Flight flightUpdated = flightRepository.save(flightBD);
		
		assertThat(flightUpdated.getOrigen()).isEqualTo("Asuncion");
		assertThat(flightUpdated.getDestino()).isEqualTo("Iguazu");
		
		
		
	}




}

