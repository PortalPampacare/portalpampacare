package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portal.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByEmail(String email);
}
