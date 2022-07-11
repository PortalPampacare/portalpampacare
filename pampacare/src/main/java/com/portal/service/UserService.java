package com.portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import com.portal.entity.Usuario;
import com.portal.repository.UserRepository;

public class UserService {
    @Autowired
    private UserRepository repository;

    public void inserirUsuario(Usuario user){
        repository.save(user);
    }

    public List<Usuario> listarUsuario(){
        return repository.findAll();
    }
}
