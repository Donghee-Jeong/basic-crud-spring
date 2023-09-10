package com.basic.crud.user;

import com.basic.crud.user.entity.User;
import com.basic.crud.user.repository.MemoryUserRepository;
import com.basic.crud.user.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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

    @Test
    void findAll() {
        //given
        User user1 = new User("user1", 20);
        User user2 = new User("user2", 21);
        repository.save(user1);
        repository.save(user2);

        //when
        List<User> userList = repository.findAll();

        //then
        assertThat(userList.size()).isEqualTo(2);
    }

    @Test
    @DisplayName("존재하던 User 업데이트")
    void update() {
        //given
        User user = new User("templates", 20);
        User savedUser = repository.save(user);

        //when
        savedUser.update("templates", 21);
        User updatedUser = repository.update(user);

        //then
        assertThat(user).isEqualTo(updatedUser);
    }

    @Test
    @DisplayName("존재하지 않던 User 업데이트")
    void updateNewUser() {
        //given
        User user = new User("templates", 20);

        //when
        User updatedNewUser = repository.update(user);

        //then
        assertThat(user).isEqualTo(updatedNewUser);
    }

    @Test
    void delete() {
        //given
        User user = new User("templates", 20);
        User savedUser = repository.save(user);

        //when
        repository.delete(savedUser);

        //then
        assertThat(repository.size()).isEqualTo(0);
    }
}
