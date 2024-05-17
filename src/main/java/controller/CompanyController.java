package controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import Services.CompanyService;
import model.Company;

@RestController
@RequestMapping("/companies")

public class CompanyController {

	@Autowired
	CompanyService companyService;

	//Listamos todas las compañias
	@GetMapping("")
	public List<Company> allCompanies() {
		
		return companyService.getAllCompanies();
	}

	//Buscamos compañía por el id
	@GetMapping("/{idCompany}")
	public  Optional <Company> findCompanyByCompanyId(@PathVariable Long idCompany) {

		return companyService.findByCompanyId(idCompany);

	}

	//Buscamos compañía  que sea petfriendly
	@GetMapping("/petFriendly")
	public Optional <Company> findCompanyPetFriendly(@PathVariable String admitenMascotas) {
		
		return companyService.findCompanyByAdmitenMascotas(admitenMascotas);
	}

	//Añadimos una compañia
	@PostMapping("/add")
	public void createCompany(@RequestBody Company company) {
		
		companyService.createCompany(company);
	}

	//Eliminamos una compañia por el id
	@DeleteMapping("/delete/{idCompany}")
	public void deleteCompany(@PathVariable Long idCompany) {

		companyService.deleteByCompanyId(idCompany);
		
	}

	//Actualizamos una compañia
	@PutMapping("/update")
	public Optional<Company> updateCompany(@RequestBody Company company){
		return companyService.updateCompany(company);
	}
}
