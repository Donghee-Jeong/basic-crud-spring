package com.basic.crud.user;

import com.basic.crud.user.entity.User;
import com.basic.crud.user.repository.MemoryUserRepository;
import com.basic.crud.user.repository.UserRepository;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class MemoryUserRepositoryTest {
    UserRepository repository = new MemoryUserRepository();

    @Test
    void save() {
        //given
        User user = new User("김민수", 17);

        //when
        User savedUser = repository.save(user);

        //then
        assertThat(savedUser).isEqualTo(user);
    }
}
