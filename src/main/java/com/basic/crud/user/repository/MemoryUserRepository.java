package com.basic.crud.user.repository;

import com.basic.crud.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class MemoryUserRepository implements UserRepository {

    private static final Map<Integer, User> store = new ConcurrentHashMap<>();
    private static final AtomicInteger id = new AtomicInteger(0);

    @Override
    public User save(User user) {
        user.setId(id.getAndIncrement());
        store.put(user.getId(), user);
        return user;
    }
}
