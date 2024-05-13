package repository;

import java.util.List;
import java.util.Optional;

import model.Vuelo;
import org.springframework.data.jpa.repository.JpaRepository;

import model.Company;

public interface CompanyRepository extends JpaRepository< Company, Long> {

	//Optional<Company> findOne(String admitenMascotas);

    Optional<Company> findCompanyByAdmitenMascotas(String admitenMascotas);


    //Optional<Vuelo> findByIdCompanyAndId(Long idCompany, Vuelo vuelo);
}
