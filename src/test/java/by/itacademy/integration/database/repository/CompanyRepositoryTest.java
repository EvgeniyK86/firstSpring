package by.itacademy.integration.database.repository;

import by.itacademy.annotation.IT;
import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.repository.CompanyRepository;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;


@IT
@RequiredArgsConstructor
@Transactional
public class CompanyRepositoryTest {

    private final EntityManager entityManager;
    private final CompanyRepository companyRepository;
    private final static Integer APPLE_ID = 5;
    /*private final TransactionTemplate transactionTemplate;        //Мануальное управление транзакцией

    @Test
    void findById() {
        transactionTemplate.executeWithoutResult(tx -> {
            var company = entityManager.find(Company.class, 1);
            assertNotNull(company);
            assertThat(company.getLocales()).hasSize(2);
        });
    }

    @Test
    void save() {
        var company = Company.builder()
                .name("Apple1")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }*/

    @Test
    void findAllByNameContainingIgnoreCase(){
        var companies = companyRepository.findAllByNameContainingIgnoreCase("A");
        assertThat(companies).hasSize(3);
    }

    /*@Test
    void updateById(){
        var company = companyRepository.findById(5);
        company.
    }*/
    @Test
    void delete(){
        var maybeCompany = companyRepository.findById(APPLE_ID);
        assertTrue(maybeCompany.isPresent());
       // maybeCompany.isPresent(companyRepository::delete);
        entityManager.flush();
        assertTrue(companyRepository.findById(APPLE_ID).isEmpty());
    }


    @Test
    void findById() {
        var company = entityManager.find(Company.class, 1l);
        assertNotNull(company);
        assertThat(company.getLocales()).hasSize(2);
    }

    @Test
    void findByNameTest() {
        var company = companyRepository.findByName("Google");
        assertTrue(company.isPresent());
        company.ifPresent(c -> assertEquals("Google", c.getName()));
    }

    @Commit
    @Test
    void save() {
        var company = Company.builder()
                .name("Apple1")
                .locales(Map.of(
                        "ru", "Apple описание",
                        "en", "Apple description"
                ))
                .build();
        entityManager.persist(company);
        assertNotNull(company.getId());
    }

}
