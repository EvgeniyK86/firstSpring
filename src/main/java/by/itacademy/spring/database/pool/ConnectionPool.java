package by.itacademy.spring.database.pool;

import jakarta.annotation.PostConstruct;

import lombok.ToString;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;


@ToString
@Component
@Scope(BeanDefinition.SCOPE_SINGLETON)
@Slf4j
public class ConnectionPool {
    private String username;
    private String password;
    private String url;
    private Integer poolSize;

    public ConnectionPool(@Value("${db.username}") String username,
                          @Value("${db.password}") String password,
                          @Value("${db.url}") String url,
                          @Value("${db.pool.size}") Integer poolSize) {
        this.username = username;
        this.password = password;
        this.url = url;
        this.poolSize = poolSize;
    }

    @PostConstruct
    private void init() {
        log.info("Init pool");
    }

    private void destroy() {
        log.info("Destroy pool");
    }
}
