package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import Services.VueloService;
import model.Vuelo;


@RestController
@RequestMapping("/vuelos")


public class VueloController {

	@Autowired
	VueloService vueloService;
	
	@GetMapping ("")
	
	public Vuelo getVuelo() {
		return vueloService.getVuelo();
	}
	
	@GetMapping("/todos")
	public List<Vuelo> getAllVuelos() {
		
		return vueloService.getAllVuelos();
	}
	
	
	@PostMapping("/agregar")
	public void createVuelo(@RequestBody Vuelo vuelo) {
		
		vueloService.crearVuelo(vuelo);
	}
	
	@GetMapping("/[id]")
	public Vuelo findVueloPorId(@PathVariable Long id) {
		
		return vueloService.findVueloPorId(id);
		
	}
	
	
	@DeleteMapping()
	public void deleteVuelo(@PathVariable Long id) {
		
	
		
		vueloService.deleteVueloPorId(id);
		
		
	}
	
	
	
}
