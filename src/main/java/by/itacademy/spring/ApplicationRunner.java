package by.itacademy.spring;

import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.dto.CreateUserDto;
import by.itacademy.spring.ioc.Container;
import by.itacademy.spring.mapper.CreateUserMapper;
import by.itacademy.spring.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {
    public static void main(String[] args) {
        var contex = new ClassPathXmlApplicationContext("application.xml");
        var userRepository = contex.getBean("userRepo1", UserRepository.class);
        System.out.println(userRepository);
        contex.close();

    }
}
