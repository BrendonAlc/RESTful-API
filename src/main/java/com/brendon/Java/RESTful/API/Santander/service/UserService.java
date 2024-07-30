package com.brendon.Java.RESTful.API.Santander.service;

import com.brendon.Java.RESTful.API.Santander.domain.model.User;

public interface UserService {
    User findById(Long id);
    User created(User userToCreate);

    User create(User userToCreate);
}
