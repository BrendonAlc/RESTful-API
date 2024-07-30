package com.brendon.Java.RESTful.API.Santander.service.implementa;

import com.brendon.Java.RESTful.API.Santander.domain.model.User;
import com.brendon.Java.RESTful.API.Santander.domain.repository.UserRepository;
import com.brendon.Java.RESTful.API.Santander.service.UserService;

import java.util.NoSuchElementException;

public class UserServiceImplementa implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementa(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User created(User userToCreate) {
        if(userRepository.existByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw  new IllegalArgumentException("This user ID already exists.");
        }
        return null;
    }

    @Override
    public User create(User userToCreate) {
        return null;
    }
}
