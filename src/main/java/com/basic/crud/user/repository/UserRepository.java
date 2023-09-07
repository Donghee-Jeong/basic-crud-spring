package com.basic.crud.user.repository;

import com.basic.crud.user.entity.User;

public interface UserRepository {
    User save(User user);
}
