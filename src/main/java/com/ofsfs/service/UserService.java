package com.ofsfs.service;

import com.ofsfs.domains.User;

public interface UserService {
    void addUser(User user);

    void confirm(String uuid);

    void update(User user);

    void delete(Long id);
}
