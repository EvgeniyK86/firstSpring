package by.itacademy.spring.database.repository;


import by.itacademy.spring.database.entity.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;


import java.util.Collections;
import java.util.List;
import java.util.Optional;


public interface CompanyRepository extends JpaRepository<Company, Integer> {

    @Query("select c from Company  c " +
            "join fetch c.locales c1 " +
            "where c.name = :name2")
    Optional<Company> findByName(@Param(("name2")) String name);

    List<Company> findAllByNameContainingIgnoreCase(String fragment);




}
