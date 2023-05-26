package by.itacademy.integration;

import by.itacademy.annotation.IT;
import by.itacademy.spring.service.UserService;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

@IT
@RequiredArgsConstructor
public class UserServiceIT {

    private final UserService userService;

    @Test
    void test(){
        System.out.println("test");
    }
}
