package Services;
import java.time.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import model.Vuelo;
import controller.VueloController;

@Service

public class VueloService {
	
	public List<Vuelo> listarVuelos = new ArrayList<Vuelo>(); 
	
	Vuelo vuelo1 = new Vuelo(1L, "San Juan", "Corrientes", 2024-02-20T12:30:00, 2024-02-20T17:30:00, 7900.00, "semanal");
	
	Vuelo vuelo2 = new Vuelo(2L, "Corrientes", "San Juan", 2024-02-20T12:30:00, 2024-02-20T17:30:00, 7900.00, "semanal");
	
	Vuelo vuelo3 = new Vuelo(3L, "Jujuy", "Corrientes", 2024-02-20T12:30:00, 2024-02-20T17:30:00, 8900.00, "diario");
	
	Vuelo vuelo4 = new Vuelo(4L, "Buenos Aires", "Chubut", 2024-02-20T14:30:00, 2024-02-20T18:30:00, 9900.00, "mensual");
	
	
public void addVuelo() {
		
		listarVuelos.add(vuelo1);
		listarVuelos.add(vuelo2);
		listarVuelos.add(vuelo3);
		listarVuelos.add(vuelo4);
	}


	
	
	public Vuelo getVuelo(){
		
		addVuelo();
		
		return listarVuelos.get(1);
	}

	
	

	
	public List<Vuelo> getAllVuelos() {
		// TODO Auto-generated method stub
		//return null;
		//addVuelo();
		return listarVuelos;
	}
	
	
	
	public void crearVuelo() {
		addVuelo();
		listarVuelos.add(new Vuelo(5L, "Buenos Aires", "Reconquista", 2024-02-20T14:30:00, 2024-02-20T18:30:00, 10900.00, "mensual"));
	}

	
	public Vuelo findVueloPorId(Long Id) {
		// TODO Auto-generated method stub
		addVuelo();
		for (int i = 0; i < listarVuelos.size(); i++) {
			if(listarVuelos.get(i).getId() == id) {
				return listarVuelos.get(i);
			}
		}
		return null;
	}


	public void deleteVueloPorId(Long Id) {
		// TODO Auto-generated method stub
		
		Vuelo vueloABorrar = findVueloPorId(id);
		listarVuelos.remove(vueloABorrar);
	
	}




	




	
	
	

}
