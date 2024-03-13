package Services;
import java.time.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import model.Vuelo;
import repository.VueloRepository;
import controller.VueloController;

@Service

public class VueloService {
	
	@Autowired
	VueloRepository vueloRepository;
	
	
	
	public Vuelo getVuelo(){
		
		
		return null;
	}

	
	

	
	public List<Vuelo> getAllVuelos() {
		// TODO Auto-generated method stub
		
		return null;
	}
	
	
	
	public void crearVuelo(Vuelo vuelo) {
		vueloRepository.save(vuelo);
	}

	
	public Vuelo findVueloPorId(Long Id) {
		// TODO Auto-generated method stub
		
		return vueloRepository.findById(Id).orElse(null);
	}


	public void deleteVueloPorId(Long Id) {
		// TODO Auto-generated method stub
		
		vueloRepository.deleteById(Id);
	
	}






	




	
	
	

}
