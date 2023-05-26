package by.itacademy.spring.mapper;

import by.itacademy.spring.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@ToString
@Component
public class CreateUserMapper {
    private final CreateUserDto createUserDto;
}
