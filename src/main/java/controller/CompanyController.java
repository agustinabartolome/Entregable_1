package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Services.CompanyService;
import model.Company;
import model.Vuelo;

@RestController
@RequestMapping("/empresas")

public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping(" ")
	public List<Company> allCompany() {
		
		return companyService.getAllCompany();
	}
	
	@GetMapping("/mascotas")
	public Optional <Company> findCompanyPetFriendly(@PathVariable String admitenMascotas) {
		
		return companyService.findCompanyByAdmitenMascotas(admitenMascotas);
	}
	
	@PostMapping("/sumar")
	public void createCompany(@RequestBody Company company) {
		
		companyService.createCompany(company);
	}
	
	
	@GetMapping("/{id}")
	public  Optional <Company> findCompanyByCompanyId(@PathVariable Long idCompany) {
		
		return companyService.findByCompanyId(idCompany);
		
	}
	
	@DeleteMapping("/eleiminar/{id}")
	public void deleteCompany(@PathVariable Long idCompany) {
		
	
		
		companyService.deleteVueloByCompanyId(idCompany);
		
		
	}
}
