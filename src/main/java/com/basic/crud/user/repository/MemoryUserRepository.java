package com.basic.crud.user.repository;

import com.basic.crud.user.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
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

    @Override
    public Optional<User> findById(Integer id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public User update(User user) {
        User findUser = store.get(user.getId());

        if (findUser == null) {
            store.put(id.getAndIncrement(), user);
        } else {
            store.put(user.getId(), user);
        }

        return user;
    }
}
