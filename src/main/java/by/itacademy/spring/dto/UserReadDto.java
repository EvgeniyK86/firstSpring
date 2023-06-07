package by.itacademy.spring.dto;

import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.entity.Role;
import lombok.Value;

import java.time.LocalDate;

@Value
public class UserReadDto {
    Long id;
    String username;
    LocalDate birthDate;
    String firstName;
    String lastname;
    Role role;
    Company company;
}
