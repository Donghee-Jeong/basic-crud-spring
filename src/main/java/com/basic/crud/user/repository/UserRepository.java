package com.basic.crud.user.repository;

import com.basic.crud.user.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Integer id);
    List<User> findAll();
    User update(User user);
}
