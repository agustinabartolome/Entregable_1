package controller;

import java.util.List;
import java.util.Optional;

import exceptions.ResourceNotFoundException;
import model.Flight;
import model.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Services.FlightService;
import utils.FlightUtils;


@RestController

@RequestMapping("/flights")

public class FlightController {

	@Autowired

	FlightService flightService;

	@Autowired
	FlightUtils flightUtils;

	@CrossOrigin

	/*
	Vamos a modificar esto para mostrar los VuelosDto
	@GetMapping(" ")
	public List<Flight> getAllVuelos() {
		
		return flightService.getAllVuelos();
	}
	*/

	@GetMapping("")

	public List<FlightDto> getAllVuelos() {

		return flightService.getAllVuelos();
	}

	/*
	@GetMapping("/{id}")
	public  Flight findVueloById(@PathVariable Long id) {
		
		return flightService.findVueloById(id);
		
	}
	*/

	//Buscamos un vuelo por id
	@GetMapping("/{id}")

	public  Optional <FlightDto> findVueloById(@PathVariable Long id) {
		
		return flightService.findVueloById(id);
		
	}

	@GetMapping("/details/{id}")

	public FlightDto getFlightDetails(@PathVariable Long id) {

		return flightService.getFlightDetails(id);

	}

	//Buscamos los precios en ofertas
	@GetMapping("/offers")

	public List<Flight> getOfertas(@RequestParam Integer precioOferta){

		return flightService.getOfertas(precioOferta);
	}

	//Buscamos vuelo por destino de origen
	@GetMapping ("/origin")

	public List<Flight> getVueloByLocalizaciones (@RequestParam String origen) {

		return flightService.getVueloByOrigen (origen);
	}


	//Buscamos vuelo por ambas localizaciones
	@GetMapping ("/locations")

	public List<Flight> getVueloByAmbasLocalizaciones (@RequestParam String origen, @RequestParam String destino) {

		return flightService.getVueloByOrigenAndDestino (origen, destino);
	}

	/*
	@GetMapping("/dolar-precio")
	public Dolar getDolar() {
		return flightService.getDolarPrecio();
	}
	*/

	@GetMapping("/precio-dolar")

	public double getDolar() {

		return flightService.getDolarPrecio();
	}

	//Agregamos un nuevo vuelo
	@PostMapping("/add")

	public void createVuelo(@RequestBody Flight flight) {

		flightService.crearVuelo(flight);
	}

	/*
	@PostMapping("/add/{idCompany}")
	public Flight createVueloSumandoCompania( @RequestParam Long idCompany, @RequestBody Flight flight) {

		return flightService.crearVueloConCompania(idCompany, flight);
	}
	*/

	//Agregamos vuelo con compañía
	@PostMapping("/add/{idCompany}")

	public Optional <Flight> createVueloSumandoCompania(@RequestParam Long idCompany, @RequestBody Flight flight) {

		return flightService.crearVueloConCompania(idCompany, flight);
	}

	
	/* En esta opción en si no utilizamos Optional
	@PutMapping("/actualizar") 
	public Flight updateVuelo (@RequestBody Flight vuelo) {
	
		return flightService.actualizarVuelo(vuelo);
	
	}
	*/

	//Actualizamos un vuelo
	@PutMapping("/update")

	public Optional <Flight> updateVuelo (@RequestBody Flight flight) {
		
		return flightService.actualizarVuelo(flight);

		}

	//Eliminamos un vuelo por id
	@DeleteMapping("/delete/{id}")

	public String deleteVuelo(@PathVariable Long id) {

		try {
			flightService.deleteVueloById(id);
			return "El vuelo de identificación " + id + " se eliminó correctamente";
		} catch (ResourceNotFoundException e){
			System.out.println(e.getMessage());
			return "No se encontró ningún vuelo con esa identificación";
		}

	}
}
