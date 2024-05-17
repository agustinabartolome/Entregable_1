package utils;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import model.Dolar;
import model.Flight;
import model.FlightDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest

class FlightUtilsTest {

	@Autowired
	FlightUtils flightUtils;
	
	@Test
	public void detectedOfertasTest() {
		
		List<Flight> flightList = new ArrayList();

		flightList.add( new Flight( "Iguazu", "Cordoba", "18:00", "22:00 ", 400.00, "Mensual"));
		flightList.add( new Flight( "Salta", "Santa Cruz", "16:00", "22:00 ", 900.00, "Semanal"));
		flightList.add( new Flight("Chile", "Mendoza", "18:00", "01:00 ", 600.00, "Diaria"));

		double valorOferta = 500.0;

		List <Flight> ofertas = flightUtils.detectedOfertas(flightList, valorOferta);

		assertEquals(4, valorOferta);

	}


	@Test
	void flightMapperTest(){

		double precioDolar = 1020;

		List <Flight> flightList = new ArrayList<>();

		List <FlightDto> flightDtoList;

		Flight flight = new Flight();
		flight.setId(2L);
		flight.setOrigen("Formosa");
		flight.setDestino("San Rafael");
		flight.setFechaHoraSalida("Hora");
		flight.setFechaHoraLlegada("OtraHora");
		flight.setPrecio(900.0);
		flight.setFrecuencia("Mensual");

		flightList.add(flight);

		flightDtoList = flightUtils.vueloMapper(flightList, precioDolar);

		FlightDto flightDto = flightDtoList.get(0);

		assertEquals(1, flightDto.getId());

		assertEquals(flight.getPrecio()*precioDolar, flightDto.getConvertedPrecio());


	}

	@Test
	void fetchDolarTest(){

		FlightUtils mockedFlightUtils = mock(FlightUtils.class);

		Dolar dummyDolar = new Dolar();

		dummyDolar.setMoneda("USD");
		dummyDolar.setCasa("tarjeta");
		dummyDolar.setNombre("Tarjeta");
		dummyDolar.setVenta(1100.00);
		dummyDolar.setCompra(1300.00);

		when(mockedFlightUtils.fetchDolar()).thenReturn(dummyDolar);

		Dolar dolarComparacion = mockedFlightUtils.fetchDolar();

		assertEquals(1200.00, dolarComparacion.getPromedio());
	}


}
