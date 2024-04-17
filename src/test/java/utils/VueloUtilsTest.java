package utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.Dolar;
import model.VueloDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import model.Vuelo;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class VueloUtilsTest {

	@Autowired
	VueloUtils vueloUtils;
	
	@Test
	public void detectedOfertasTest() {
		
		List<Vuelo> vueloList = new ArrayList();

		vueloList.add( new Vuelo( "Iguazu", "Cordoba", "18:00", "22:00 ", 400.00, "Mensual"));
		vueloList.add( new Vuelo( "Salta", "Santa Cruz", "16:00", "22:00 ", 900.00, "Semanal"));
		vueloList.add( new Vuelo("Chile", "Mendoza", "18:00", "01:00 ", 600.00, "Diaria"));

		double valorOferta = 500.0;

		List <Vuelo> ofertas = vueloUtils.detectedOfertas(vueloList, valorOferta);

		assertEquals(4, valorOferta);
	}


	@Test
	void vueloMapperTest(){

		double precioDolar = 1020;

		List <Vuelo> vueloList = new ArrayList<>();

		List <VueloDto> vueloDtoList;

		Vuelo vuelo = new Vuelo();
		vuelo.setId(2L);
		vuelo.setOrigen("Formosa");
		vuelo.setDestino("San Rafael");
		vuelo.setFechaHoraSalida("Hora");
		vuelo.setFechaHoraLlegada("OtraHora");
		vuelo.setPrecio(900.0);
		vuelo.setFrecuencia("Mensual");

		vueloList.add(vuelo);

		vueloDtoList = vueloUtils.vueloMapper(vueloList, precioDolar);

		VueloDto vueloDto = vueloDtoList.get(0);

		assertEquals(1, vueloDto.getId());

		assertEquals(vuelo.getPrecio()*precioDolar, vueloDto.getConvertedPrecio());


	}

	@Test
	void fetchDolarTest(){

		VueloUtils mockedVueloUtils = mock(VueloUtils.class);

		Dolar dummyDolar = new Dolar();

		dummyDolar.setMoneda("USD");
		dummyDolar.setCasa("tarjeta");
		dummyDolar.setNombre("Tarjeta");
		dummyDolar.setVenta(1100.0);
		dummyDolar.setCompra(1300.00);

		when(mockedVueloUtils.fetchDolar()).thenReturn(dummyDolar);

		Dolar dolarComparacion = mockedVueloUtils.fetchDolar();

		assertEquals(1200.0, dolarComparacion.getPromedio());
	}


}
