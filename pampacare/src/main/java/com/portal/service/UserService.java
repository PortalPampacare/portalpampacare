package com.portal.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.portal.entity.Usuario;
import com.portal.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public ResponseEntity<String> inserirUsuario(Usuario user){
        try{
        repository.save(user);
        return new ResponseEntity<String>("Cadastrado com sucesso", HttpStatus.OK);
        }catch(Error e){
        return new ResponseEntity<String>("Erro ao realizar o cadastro", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Usuario> listarUsuario() {
        return repository.findAll();
    }

     public Usuario procurarUsuario(Usuario usr) {
        Integer id = usr.getId();
        return repository.getReferenceById(id);
    }

    public void deletarUsuario(Usuario usr) {
        repository.delete(usr);
    }
}
