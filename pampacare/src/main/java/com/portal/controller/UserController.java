package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import com.portal.entity.Usuario;
import com.portal.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/portal")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/inserir")
  public void addUser(@RequestBody Usuario user) {
    service.inserirUsuario(user);
  }

  @GetMapping("/procurar")
  public Usuario searchUser(@Valid @RequestBody Usuario user) {
    return service.procurarUsuario(user);
  }

  @GetMapping("/listar")
  public List<Usuario> listUser() {
    return service.listarUsuario();
  }

  @PostMapping("/excluir")
  public void excluirUser(@RequestBody Usuario user) {
    service.deletarUsuario(user);
  }
}
