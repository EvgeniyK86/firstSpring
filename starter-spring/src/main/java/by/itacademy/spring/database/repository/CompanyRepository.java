package by.itacademy.spring.database.repository;

import by.itacademy.spring.bpp.InjectBean;
import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.annotation.Resource;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
@ToString
public class CompanyRepository {
    //   @InjectBean

    private ConnectionPool connectionPool;

//    @Value("${db.pool.size}")
    private Integer poolSize;

 //   @Autowired
    private List<ConnectionPool> pools;
    private String driver;


    public CompanyRepository(@Qualifier("connectionPool2") ConnectionPool connectionPool3,
                             @Value("${db.pool.size}") Integer poolSize,
                             List<ConnectionPool> pools,
                             @Value("${db.driver}") String driver) {
        this.connectionPool = connectionPool3;
        this.poolSize = poolSize;
        this.pools = pools;
        this.driver = driver;
    }

    public Optional<Company> findById(Integer id) {
        System.out.println("findById method...");
        return Optional.of(new Company(id));
    }

}
