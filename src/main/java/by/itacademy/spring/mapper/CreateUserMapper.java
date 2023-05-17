package by.itacademy.spring.mapper;

import by.itacademy.spring.dto.CreateUserDto;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class CreateUserMapper {
    private final CreateUserDto createUserDto;
}
