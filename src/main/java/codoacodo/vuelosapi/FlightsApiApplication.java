package codoacodo.vuelosapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication

@EnableDiscoveryClient
//Ejemplo 1 de práctica: Entregable 1

public class FlightsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightsApiApplication.class, args);}
		
	
	
	}


