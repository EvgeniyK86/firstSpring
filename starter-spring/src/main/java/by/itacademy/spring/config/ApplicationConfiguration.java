package by.itacademy.spring.config;


import by.itacademy.spring.database.pool.ConnectionPool;
import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.web.config.WebConfiguration;
import org.springframework.context.annotation.*;

@Configuration
@Import(WebConfiguration.class)
public class ApplicationConfiguration {

    @Bean("connectionPool2")
    public ConnectionPool connectionPool2 (){
        return new ConnectionPool("postgres", "1234" ,"url" ,20);
    }
    @Bean
    @Profile("prod&web")
    public UserRepository userRepository(ConnectionPool connectionPool2){
        return new UserRepository(connectionPool2);
    }
}
