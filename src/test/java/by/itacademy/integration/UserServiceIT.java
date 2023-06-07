package by.itacademy.integration;

import by.itacademy.annotation.IT;
import by.itacademy.spring.database.pool.ConnectionPool;
import by.itacademy.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;

    @Test
    void test() {
        System.out.println("test");
    }
}
