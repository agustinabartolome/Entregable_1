package Services;
import java.time.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import model.Company;
import model.VueloDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import configuration.VueloConfiguration;
import model.Dolar;
import model.Vuelo;
import repository.CompanyRepository;
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
	CompanyRepository companyRepository;

	/*
	public List<Vuelo> getAllVuelos() {
		
		return vueloRepository.findAll();
	}
	*/

	public List<VueloDto> getAllVuelos() {

	double precio = getDolarPrecio();
	List <Vuelo> vuelos = vueloRepository.findAll();

		return vueloUtils.vueloMapper(vuelos, precio);
	}
	
	public void crearVuelo(Vuelo vuelo) {
		vueloRepository.save(vuelo);
	}

	/* Esta es una de las opciones de uso, utilizando .orElse(null) o se aplica directamente optional.
	
	public Vuelo findVueloById(Long Id) {
		
		return vueloRepository.findById(Id).orElse(null);
	}

	*/
	
	public Optional <Vuelo> findById (Long Id) {
		
		return vueloRepository.findById(Id);
	}
	
	
	public void deleteVueloById(Long Id) {
		
		vueloRepository.deleteById(Id);
	
	}

	/* Esta es una de las opciones de uso, utilizando .orElse(null) o se aplica directamente optional.

	public Vuelo actualizarVuelo(Vuelo vuelo) {
	
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

		return vueloConfiguration.fetchDolar();
	}

	*/
	
	public double getDolarPrecio() {

		Dolar dolar = vueloUtils.fetchDolar();
		return dolar.getPromedio();
	}


	public Optional<Vuelo> crearVueloConCompania(Long idCompany, Vuelo vuelo) {
		return companyRepository.findByIdCompanyAndId(idCompany, vuelo);

	}


}
