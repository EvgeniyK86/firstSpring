package by.itacademy.integration.database.repository;

import by.itacademy.annotation.IT;
import by.itacademy.spring.database.entity.Role;
import by.itacademy.spring.database.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@IT
@RequiredArgsConstructor
@Transactional
public class UserRepositoryTest {

    private final UserRepository userRepository;

    @Test
    void findByNameTest() {
        var user = userRepository.findByName("I", "I");
        assertTrue(!user.isEmpty());
        assertThat(user).hasSize(1);
    }

    @Test
    void updateRoleTest() {
        var admin = userRepository.findById(1l);
        assertEquals(Role.ADMIN, admin.get().getRole());
        var number = userRepository.updateRole(Role.USER, 1l, 5l);
        assertEquals(2, number);
        var sameAdmin = userRepository.findById(1l);
        assertEquals(Role.USER, sameAdmin.get().getRole());
    }

    @Test
    void findFirstByOrderByIdDescTest() {
        var users = userRepository.findFirstByOrderByIdDesc();
        assertTrue(users.get().getFirstname().equals("Kate"));
        var allUsers = userRepository.findAll();
        assertThat(allUsers).hasSize(5);
    }

    @Test
    void findFirst3ByOrderByIdDescTest() {
        var users = userRepository.findFirst3ByOrderByIdDesc();
        assertThat(users).hasSize(3);
        assertTrue(users.get(0).getFirstname().equals("Kate"));
    }

    @Test
    void findFirst3ByTest() {
        var users = userRepository.findFirst3By(Sort.by("firstname")
                .and(Sort.by("lastname")).descending());
        assertFalse(users.isEmpty());
        assertThat(users).hasSize(3);
    }

    @Test
    void checkPageable() {
        var pageable = PageRequest.of(1, 3, Sort.by("role"));
        var slice = userRepository.findAllBy(pageable);
        slice.forEach(u -> System.out.println(u.getId()));
        while (slice.hasNext()) {
            slice = userRepository.findAllBy(slice.nextPageable());
            slice.forEach(u -> System.out.println(u.getId()));
        }
        /*assertFalse(slice.isEmpty());
        assertThat(slice).hasSize(2);*/
    }

    @Test
    void findFirst4ByTest() {
        var pageable = PageRequest.of(0, 4, Sort.by("birthDate"));
        var pageable2 = PageRequest.of(0, 4, Sort.by("birthDate")
                .and(Sort.by("firstname"))
                .and(Sort.by("lastname")));
        var users = userRepository.findFirst4By(pageable);
        var users2 = userRepository.findFirst4By(pageable2);
        assertThat(users).hasSize(4);
        assertThat(users2).hasSize(4);

        assertTrue(users.get().findFirst().get().getFirstname().equals("Vlad"));
        assertTrue(users2.get().findFirst().get().getFirstname().equals("Kate"));

    }

    @Test
    void findAllByTest (){
        var pageable = PageRequest.of(1, 3, Sort.by("role"));
        var users = userRepository.findAllBy(pageable);
        assertThat(users).hasSize(5);
        List<String> names = new ArrayList<String>();
        names.add(0, "Ivan");
        names.add(1, "Kate");
        names.add(2, "Petr");
        names.add(3, "Sveta");
        names.add(4, "Vlad");
        //List<String> otherNames = users.stream().forEach(user -> user.getFirstname()).collect;
        int count;
        while (users.hasNext()) {
            users = userRepository.findAllBy(users.nextPageable());
            count = users.getTotalPages();
        }
        assertTrue(count = 2);
    }

}
