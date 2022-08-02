package com.portal.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.entity.Usuario;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Integer> {

   public List<Usuario> findAll();
   public Usuario getById(Integer id);
   public void delete(Usuario usr);
   Usuario findByEmail(String email);
}