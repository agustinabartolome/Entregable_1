package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Company;
import org.springframework.stereotype.Repository;

@Repository
public interface CompanyRepository extends JpaRepository< Company, Long> {

	//Optional<Company> findOne(String admitenMascotas);

    Optional<Company> findCompanyByAdmitenMascotas(String admitenMascotas);


    //Optional<Flight> findByIdCompanyAndId(Long idCompany, Flight vuelo);
}
