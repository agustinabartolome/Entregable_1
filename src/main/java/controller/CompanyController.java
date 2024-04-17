package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Services.CompanyService;
import model.Company;
import model.Vuelo;

@RestController
@RequestMapping("/empresas")

public class CompanyController {

	@Autowired
	CompanyService companyService;
	
	@GetMapping(" ")
	public List<Company> allCompanies() {
		
		return companyService.getAllCompanies();
	}

	@GetMapping("/{id}")
	public  Optional <Company> findCompanyByCompanyId(@PathVariable Long idCompany) {

		return companyService.findByCompanyId(idCompany);

	}
	
	@GetMapping("/mascotas")
	public Optional <Company> findCompanyPetFriendly(@PathVariable String admitenMascotas) {
		
		return companyService.findCompanyByAdmitenMascotas(admitenMascotas);
	}
	
	@PostMapping("/sumar")
	public void createCompany(@RequestBody Company company) {
		
		companyService.createCompany(company);
	}

	
	@DeleteMapping("/eleiminar/{id}")
	public void deleteCompany(@PathVariable Long idCompany) {

		companyService.deleteByCompanyId(idCompany);
		
	}

	@PutMapping("/actualizar")
	public Optional<Company> updateCompany(@RequestBody Company company){
		return companyService.updateCompany(company);
	}
}
