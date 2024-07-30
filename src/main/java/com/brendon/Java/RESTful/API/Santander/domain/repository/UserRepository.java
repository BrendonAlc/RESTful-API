package com.brendon.Java.RESTful.API.Santander.domain.repository;

import com.brendon.Java.RESTful.API.Santander.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existByAccountNumber(String accountNumber);
}
