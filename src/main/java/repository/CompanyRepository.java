package repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import model.Company;

public interface CompanyRepository extends JpaRepository< Company, Long> {

	Optional<Company> findOne(String admitenMascotas);

}
