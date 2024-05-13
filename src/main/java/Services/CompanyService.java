package Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import model.Company;
import repository.CompanyRepository;

public class CompanyService {

	@Autowired
	CompanyRepository companyRepository;

	public List<Company> getAllCompanies() {

		return companyRepository.findAll();
	}

	public Optional<Company> findCompanyByAdmitenMascotas(String admitenMascotas) {

		//return companyRepository.findOne(admitenMascotas);
		return companyRepository.findCompanyByAdmitenMascotas(admitenMascotas);
	}

	public void createCompany(Company company) {

		companyRepository.save(company);
	}

	public Optional<Company> findByCompanyId(Long idCompany) {

		return companyRepository.findById(idCompany);
	}

	public void deleteByCompanyId(Long idCompany) {

		companyRepository.deleteById(idCompany);
	}

	public Optional<Company> updateCompany(Company company) {
		companyRepository.save(company);
		return companyRepository.findById(company.getIdCompany());


	}
}
