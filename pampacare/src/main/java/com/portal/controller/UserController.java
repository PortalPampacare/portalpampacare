package com.portal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import javax.validation.Valid;
import com.portal.dto.LoginUserDTO;
import com.portal.entity.Usuario;
import com.portal.service.UserService;

@RestController
@CrossOrigin
@RequestMapping("/portal")
public class UserController {

  @Autowired
  private UserService service;

  @PostMapping("/inserir")
  public ResponseEntity<String> addUser(@RequestBody LoginUserDTO user) {
    return service.inserirUsuario(user);
  }
  
  @GetMapping("/procurar/{email}")
  public Usuario searchUser(@PathVariable String email) {
    return service.findByUserEmail(email);
  }
  
  @PostMapping("/editar/usuario")
  public void updateUser(Usuario user){
    service.updateUserInfo(user);
  }

  @GetMapping("/listar")
  public List<Usuario> listUser() {
    return service.listAllUsers();
  }

  @PostMapping("/excluir")
  public void excluirUser(@RequestBody Usuario user) {
    service.deleteUsers(user);
  }
}
