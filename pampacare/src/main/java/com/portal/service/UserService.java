package com.portal.service;

import java.util.List;

import org.apache.catalina.User;
import org.aspectj.weaver.ast.Instanceof;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.portal.dto.LoginUserDTO;
import com.portal.entity.Login;
import com.portal.entity.Usuario;
import com.portal.repository.LoginRepository;
import com.portal.repository.UserRepository;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private LoginRepository loginRepository;
    private PasswordEncoder passEncoder;
    @Autowired
    private ModelMapper modelMapper;

    public ResponseEntity<String> inserirUsuario(LoginUserDTO dto) {
        try {
            Usuario usr = (Usuario) converterDtoToEntity(dto, Usuario.class);
            userRepository.save(usr);
            // loginRepository.save(createLogin(dto, usr));
            return new ResponseEntity<String>("Cadastrado com sucesso!", HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>("Erro ao realizar o cadastro", HttpStatus.BAD_REQUEST);
        }
    }

    public Login createLogin(LoginUserDTO dto, Usuario usr) {
        Login l = (Login) converterDtoToEntity(dto, Login.class);
        passEncoder = new BCryptPasswordEncoder();
        l.setUser(usr);
        l.setRole(usr.getFuncao());
        l.setPassword(this.passEncoder.encode(l.getPassword()));
        return l;
    }

    public ResponseEntity<String> updateUserInfo(LoginUserDTO user) {
        try{
            // System.out.println();
            Login log = (Login) converterDtoToEntity(user, Login.class);
            Usuario usuario = (Usuario) converterDtoToEntity(user, Usuario.class);
            userRepository.save(usuario);
            // loginRepository.save(log);
            return new ResponseEntity<String>("Cadastro atualizado com sucesso!", HttpStatus.OK);
        }catch(Error e){
            return new ResponseEntity<String>("Erro ao realizar a atualização do cadastro", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Usuario> listAllUsers() {
        return userRepository.findAll();
    }

    public Usuario findByUserEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUsers(Usuario usr) {
        Login log = loginRepository.findByEmail(usr.getEmail());
        loginRepository.delete(log);
        Usuario user = userRepository.findByEmail(usr.getEmail());
        userRepository.delete(user);
    }

    private Object converterDtoToEntity(LoginUserDTO dto, Class name) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Object obj = modelMapper.map(dto, name);
        System.out.println("aqui foi modificado " + obj);
        return obj;
    }
}
