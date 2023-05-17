package by.itacademy.spring.database.repository;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;

import java.util.List;
import java.util.Map;
import java.util.Objects;

@ToString
@RequiredArgsConstructor
public class UserRepository {
    private  final String username;
    private  final String url;
    private  final Integer poolSize;
    private  final List<Object> args;
    private  final Map<String, Object> properties;
    @PostConstruct
    private void init() {
        System.out.println("init repo");
    }
    @PreDestroy
    private void destroy() {
        System.out.println("destroy repo");
    }
}
