package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@ToString
@Repository
public class UserRepository {

    public UserRepository(ConnectionPool connectionPool2) {
    }
}
