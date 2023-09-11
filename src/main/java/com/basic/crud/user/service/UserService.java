package com.basic.crud.user.service;

import com.basic.crud.user.entity.User;
import com.basic.crud.user.repository.MemoryUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final MemoryUserRepository repository;

    public List<User> userList() {
        return repository.findAll();
    }

    public User addUser(User user) {
        return repository.save(user);
    }

    public User getUserById(Integer id) {
        return repository.findById(id)
                .orElseGet(() -> new User("unknown", 9999));
    }

    public User updateUser(User originUser) {
        return repository.update(originUser);
    }

    public void deleteUser(User user) {
        repository.delete(user);
    }
}
