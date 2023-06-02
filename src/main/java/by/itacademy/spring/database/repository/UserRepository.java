package by.itacademy.spring.database.repository;

import by.itacademy.spring.database.entity.Company;
import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.entity.User;
import by.itacademy.spring.database.pool.ConnectionPool;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.*;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;


public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User  u " +
            "where u.firstname like %:firstname%" +
            " and u.lastname like %:lastname%")
    List<User> findByName(String firstname, String lastname);

    @Query(value = "select u.* from users u " +
            "where u.firstname = :username",
            nativeQuery = true)
    List<User> findAllByName(String username);

    @Modifying(clearAutomatically = true)
    @Query("update User u set u.role = :role " +
            "where u.id in (:ids)")
    int updateRole(Role role, Long... ids);

    Optional<User> findFirstByOrderByIdDesc();

    List<User> findFirst3ByOrderByIdDesc();

    List<User> findFirst3By(Sort sort);

    Page<User> findAllBy(Pageable pageable);

    Page<User> findFirst4By(Pageable pageable);

}
