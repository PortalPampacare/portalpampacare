package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.portal.entity.Usuario;
import com.portal.repository.UserRepository;

@RestController
@CrossOrigin
@RequestMapping("/portal")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @PostMapping("/inserir")
    public void addUser(@RequestBody Usuario user){
        repository.save(user);
    }

    @GetMapping("/listar")
    public List<Usuario> listUser(){
    //   repository.findAll().stream().forEach(e->{System.out.println(e.toString());});
      return repository.findAll();
    }
}
