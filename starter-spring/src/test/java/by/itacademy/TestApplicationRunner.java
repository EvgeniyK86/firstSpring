package by.itacademy;

import by.itacademy.spring.database.pool.ConnectionPool;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;

@TestConfiguration
public class TestApplicationRunner {
    @SpyBean(name = "connectionPool2")
    private ConnectionPool connectionPool;
}
