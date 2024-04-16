package Services;
import java.time.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import configuration.VueloConfiguration;
import model.Dolar;
import model.Vuelo;
import repository.VueloRepository;
import utils.VueloUtils;
import controller.VueloController;

@Service

public class VueloService {
	
	
	@Autowired
	VueloRepository vueloRepository;

	
	@Autowired
	VueloUtils vueloUtils;
	
	@Autowired
	VueloConfiguration vueloConfiguration;

	
	public List<Vuelo> getAllVuelos() {
		// TODO Auto-generated method stub
		
		return vueloRepository.findAll();
	}
	
	
	
	public void crearVuelo(Vuelo vuelo) {
		vueloRepository.save(vuelo);
	}

	/* Esta es una de las opciones de uso, utilizando .orElse(null) o se aplica directamente optional.
	
	public Vuelo findVueloById(Long Id) {
		// TODO Auto-generated method stub
		
		return vueloRepository.findById(Id).orElse(null);
	}

	*/
	
	public Optional <Vuelo> findById (Long Id) {
		
		return vueloRepository.findById(Id);
	}
	
	
	public void deleteVueloById(Long Id) {
		// TODO Auto-generated method stub
		
		vueloRepository.deleteById(Id);
	
	}

	/* Esta es una de las opciones de uso, utilizando .orElse(null) o se aplica directamente optional.

	public Vuelo actualizarVuelo(Vuelo vuelo) {
		// TODO Auto-generated method stub
	
		vueloRepository.save(vuelo);
		return vueloRepository.findById(vuelo.getId()).orElse(null);
	}

	 */
	
	public Optional <Vuelo> actualizarVuelo (Vuelo vuelo) {
		
		vueloRepository.save(vuelo);
		
		return vueloRepository.findById(vuelo.getId());
	}
	
	
	public List<Vuelo> getVueloByOrigen (String origen) {
		
		return vueloRepository.findByOrigen(origen);
	}
	
	
	public List<Vuelo> getVueloByOrigenAndDestino (String origen, String destino) {
		
		return vueloRepository.findByOrigenAndDestino(origen, destino);
	}

	/* Para que el código no sea repetitivo, trasladamos esta selección hacia el paquete utils. 
	 * Desde allí podrá utilizarse en todo el proyecto. 

	public List<Vuelo> getOfertas(Integer preciosOfertas){
		
		List<Vuelo> vuelos = vueloRepository.findAll();
		
		List <Vuelo> ofertasVuelos = new ArrayList<>();
		
		for (Vuelo vuelo : vuelos) {
			
			if (vuelo.getPrecio() < preciosOfertas) {
				
				ofertasVuelos.add(vuelo);
			}
			
		}
		
		return ofertasVuelos;
	}
	
	*/
	
	
	public List<Vuelo> getOfertas(Integer preciosOfertas){
		
		List<Vuelo> vuelos = vueloRepository.findAll();
		
		return vueloUtils.detectedOfertas(vuelos, preciosOfertas);
		
	}


	/*
	public Dolar getDolar() {
		// TODO Auto-generated method stub
		return vueloConfiguration.fetchDolar();
	}

	*/
	
	public double getDolarPrecio() {
		// TODO Auto-generated method stub
		return vueloConfiguration.fetchDolar().getPromedio();
	}
	
	
	
	
	
		
		
	}

	




	
	
	


