package controller;

import java.util.List;
import java.util.Optional;

import model.VueloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Services.VueloService;
import model.Dolar;
import model.Vuelo;


@RestController
@RequestMapping("/vuelos")


public class VueloController {

	@Autowired
	VueloService vueloService;

	@CrossOrigin

	/*
	Vamos a modificar esto para mostrar los VuelosDto
	@GetMapping(" ")
	public List<Vuelo> getAllVuelos() {
		
		return vueloService.getAllVuelos();
	}
	*/

	@GetMapping(" ")
	public List<VueloDto> getAllVuelos() {

		return vueloService.getAllVuelos();
	}

	/*
	@GetMapping("/{id}")
	public  Vuelo findVueloById(@PathVariable Long id) {
		
		return vueloService.findVueloById(id);
		
	}
	*/
	
	@GetMapping("/{id}")
	public  Optional <Vuelo> findVueloById(@PathVariable Long id) {
		
		return vueloService.findById(id);
		
	}

	@GetMapping("/ofertas")
	public List<Vuelo> getOfertas(@RequestParam Integer precioOferta){

		return vueloService.getOfertas(precioOferta);
	}


	@GetMapping ("/origen")
	public List<Vuelo> getVueloByLocalizaciones (@RequestParam String origen) {

		return vueloService.getVueloByOrigen (origen);
	}


	@GetMapping ("/localizaciones")
	public List<Vuelo> getVueloByAmbasLocalizaciones (@RequestParam String origen, @RequestParam String destino) {

		return vueloService.getVueloByOrigenAndDestino (origen, destino);
	}

	/*
	@GetMapping("/dolar-precio")
	public Dolar getDolar() {
		return vueloService.getDolarPrecio();
	}
	*/

	@GetMapping("/precio-dolar")
	public double getDolar() {
		return vueloService.getDolarPrecio();
	}


	@PostMapping("/agregar")
	public void createVuelo(@RequestBody Vuelo vuelo) {

		vueloService.crearVuelo(vuelo);
	}



	@PostMapping("/agregar/{idCompany}")
	public Optional <Vuelo> createVueloSumandoCompania(@RequestParam Long idCompany, @RequestBody Vuelo vuelo) {

		return vueloService.crearVueloConCompania(idCompany,vuelo);
	}

	
	/* En esta opción en si no utilizamos Optional
	@PutMapping("/actualizar") 
	public Vuelo updateVuelo (@RequestBody Vuelo vuelo) {
	
		return vueloService.actualizarVuelo(vuelo);
	
	}
	*/
	
	@PutMapping("/actualizar") 
	public Optional <Vuelo> updateVuelo (@RequestBody Vuelo vuelo) {
		
		return vueloService.actualizarVuelo(vuelo);
		}

	@DeleteMapping("/eleiminar/{id}")
	public void deleteVuelo(@PathVariable Long id) {

		vueloService.deleteVueloById(id);

	}
}
