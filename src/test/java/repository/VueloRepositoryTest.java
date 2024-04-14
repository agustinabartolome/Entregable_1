package repository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import model.Vuelo;


@DataJpaTest

@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)

class VueloRepositoryTest {
	
	/*

	@Test
	void test() {
		fail("Not yet implemented");
	}

*/
	
	@Autowired
	private VueloRepository vueloRepository;
	
	@Autowired
	private Vuelo vuelo;
	
	@BeforeEach
	void setUp() {
		
		vuelo = new Vuelo("Jujuy", "Salta", "23:00", "02:00", 400.50, "Semanal");
	}
	
	@Test
	void saveVueloTest() {
		
		//Pasos
			//1)Configuración previa --> en este caso en el SetUp
			//2)Llamar a la funcionalidad
		
		Vuelo vueloBD = vueloRepository.save(vuelo);
		
			//3)Verificar salidad o comportamiento
		
		assertThat(vueloBD).isNotNull();
		
		assertThat(vueloBD.getId()).isGreaterThan(0);

	}
	
	/*
	 * Tener en cuenta que uno puede modificar el test para que la respuesta sea incorrecta y 
	 * obtener un error, como en este caso
	 
	 @Test
	void saveVueloTest() {
		
		//Pasos
			//1)Configuración previa --> en este caso en el SetUp
			//2)Llamar a la funcionalidad
		
		Vuelo vueloBD = vueloRepository.save(vuelo);
		
			//3)Verificar salidad o comportamiento
		
		assertThat(vueloBD).isNull();
		
		assertThat(vueloBD.getId()).isGreaterThan(0);

	}
	 
	 */
	
	@Test
	void vueloFindByIdTest() {
		
		//Pasos
				//1)Configuración previa 
		
		vueloRepository.save(vuelo);
		
				//2)Llamar a la funcionalidad
		
		Vuelo vueloBD = vueloRepository.findById(vuelo.getId()).get();
		
			//3)Verificar salidad o comportamiento
		
				assertThat(vueloBD).isNotNull();
	}

	
	@Test
	void vueloGetAllTest() {
		
		//Pasos
			//1)Configuración previa 

		Vuelo vuelo2 = new Vuelo("Asuncion", "Iguazu", "15:00", "18:00", 500.50, "Diaria");
		
		vueloRepository.save(vuelo);
		
		vueloRepository.save(vuelo2);

			//2)Llamar a la funcionalidad

		List <Vuelo> vueloList = vueloRepository.findAll();

			//3)Verificar salidad o comportamiento

		assertThat(vueloList).isNotNull();
		assertThat(vueloList.size()).isEqualTo(2);
		
	}
	
	/*

@Test
	void vueloFindAllTest() {
		
		//Pasos
			//1)Configuración previa 

		Vuelo vuelo2 = new Vuelo("", "", "", "", 500.50, "");
		
		vueloRepository.save(vuelo);
		
		vueloRepository.save(vuelo2);

			//2)Llamar a la funcionalidad

		List <Vuelo> vueloList = vueloRepository.findAll();

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

		Vuelo vuelo2 = new Vuelo("", "", "", "", 500.50, "");
		
		vueloRepository.save(vuelo);
		
		vueloRepository.save(vuelo2);

			//2)Llamar a la funcionalidad

		List <Vuelo> vueloList = vueloRepository.findAll();

			//3)Verificar salidad o comportamiento

		assertThat(vueloList).isNotNull();
		assertThat(vueloList.size()).isEqualTo(1);

	}
	 
	 */


	@Test
	void vueloFindDeleteById() {
		
		//Pasos
			//1)Configuración previa 


		vueloRepository.save(vuelo);
		

			//2)Llamar a la funcionalidad

		vueloRepository.deleteById(vuelo.getId());

			//3)Verificar salidad o comportamiento

		Optional <Vuelo> deletedVuelo = vueloRepository.findById(vuelo.getId());
		
		assertThat(deletedVuelo).isEmpty();

	}


	@Test
	void vueloActualizarTest() {
		
		vueloRepository.save(vuelo);
		
		Vuelo vueloBD = vueloRepository.findById(vuelo.getId()).get();
		
		vueloBD.setOrigen("Asuncion");
		vueloBD.setDestino("Iguazu");
		
		vuelo vueloUpdated = vueloRepository.save(vueloBD);
		
		assertThat(vueloUpdated.getOrigen().isEqualTo("");
		assertThat(vueloUpdated.getDestino().isEqualTo("");
		
		
		
	}




}

