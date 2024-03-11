package controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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
	
	
	@PostMapping
	public void createVuelo() {
		
		vueloService.crearVuelo();
	}
	
	@GetMapping
	public void findVueloPorId() {
		
		Long id = 1L;
		Vuelo vueloEncontrado = vueloService.findVueloPorId(id);
		return vueloEncontrado;
	}
	
	
	@DeleteMapping()
	public void deleteVuelo() {
		
		long id = 1L;
		
		vueloService.deleteVueloPorId(id);
		
		
	}
	
	
	
}
