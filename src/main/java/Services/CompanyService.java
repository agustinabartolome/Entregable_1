package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import model.Company;
import repository.CompanyRepository;

public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public List<Company> getAllCompany() {
		// TODO Auto-generated method stub
		return companyRepository.findAll();
	}

	public Optional<Company> findCompanyByAdmitenMascotas(String admitenMascotas) {
		// TODO Auto-generated method stub
		return companyRepository.findOne(admitenMascotas);
	}

	public void createCompany(Company company) {
		// TODO Auto-generated method stub
		companyRepository.save(company);
	}

	public Optional<Company> findByCompanyId(Long idCompany) {
		// TODO Auto-generated method stub
		return companyRepository.findById(idCompany);
	}

	public void deleteVueloByCompanyId(Long idCompany) {
		// TODO Auto-generated method stub
		companyRepository.deleteById(idCompany);
	}

	
	
	
	
}
