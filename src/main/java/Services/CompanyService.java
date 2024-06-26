package Services;

import java.util.List;
import java.util.Optional;

import exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

import model.Company;
import org.springframework.stereotype.Service;
import repository.CompanyRepository;

@Service
public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public List<Company> getAllCompanies() {

		return companyRepository.findAll();
	}

	public Optional<Company> findCompanyByAdmitenMascotas(String admitenMascotas) {

		return companyRepository.findCompanyByAdmitenMascotas(admitenMascotas);
	}

	public void createCompany(Company company) {

		companyRepository.save(company);
	}

	public Optional<Company> findByCompanyId(Long idCompany) {

		return companyRepository.findById(idCompany);
	}

	public void deleteByCompanyId(Long idCompany)  throws ResourceNotFoundException{
		Company company = companyRepository.findById(idCompany).orElseThrow(() ->
						new ResourceNotFoundException("No se encontró la compañía con identificación " + idCompany));
		companyRepository.deleteById(company.getIdCompany());
	}

	public Optional<Company> updateCompany(Company company) {
		companyRepository.save(company);
		return companyRepository.findById(company.getIdCompany());


	}
}
