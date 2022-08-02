package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Login findByEmail(String email);
}
