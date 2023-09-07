package com.basic.crud.user.repository;

import com.basic.crud.user.entity.User;

import java.util.Optional;

public interface UserRepository {
    User save(User user);
    Optional<User> findById(Integer id);
}
