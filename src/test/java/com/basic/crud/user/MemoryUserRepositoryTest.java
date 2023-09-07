package com.basic.crud.user;

import com.basic.crud.user.entity.User;
import com.basic.crud.user.repository.MemoryUserRepository;
import com.basic.crud.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryUserRepositoryTest {
    UserRepository repository;

    @BeforeEach
    void newRepository() {
        repository = new MemoryUserRepository();
    }

    @Test
    void save() {
        //given
        User user = new User("김민수", 17);

        //when
        User savedUser = repository.save(user);

        //then
        assertThat(savedUser).isEqualTo(user);
    }

    @Test
    void findById() {
        //given
        User user = new User("김민수", 17);
        User savedUser = repository.save(user);

        //when
        User findUser = repository.findById(savedUser.getId()).get();

        //then
        assertThat(findUser).isEqualTo(savedUser);
    }
}
