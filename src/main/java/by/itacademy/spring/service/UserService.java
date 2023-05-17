package by.itacademy.spring.service;

import by.itacademy.spring.database.repository.UserRepository;
import by.itacademy.spring.mapper.CreateUserMapper;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@ToString
public class UserService {
    private final UserRepository userRepository;
    private final CreateUserMapper createUserMapper;
}