package com.portal.service;

import java.util.List;

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
            Login l = (Login)converterDtoToEntity(dto, Login.class);
            Usuario usr = (Usuario)converterDtoToEntity(dto, Usuario.class);
            passEncoder = new BCryptPasswordEncoder();
            l.setPassword(this.passEncoder.encode(l.getPassword()));
            l.setUsr(usr);
            userRepository.save(usr);
            loginRepository.save(l);
            return new ResponseEntity<String>("Cadastrado com sucesso", HttpStatus.OK);
        } catch (Error e) {
            return new ResponseEntity<String>("Erro ao realizar o cadastro", HttpStatus.BAD_REQUEST);
        }
    }

    public List<Usuario> listarUsuario() {
        return userRepository.findAll();
    }

    public Usuario procurarEmail(String email) {
        System.out.println(email);
        return userRepository.findByEmail(email);
    }

    public void deletarUsuario(Usuario usr) {
        userRepository.delete(usr);
    }

    private Object converterDtoToEntity(LoginUserDTO dto, Class name) {
        modelMapper.getConfiguration()
                .setMatchingStrategy(MatchingStrategies.LOOSE);
        Object obj = modelMapper.map(dto, name);
        if( obj instanceof Usuario){
        return (Usuario) obj;}
        else if( obj instanceof Login){
        return (Login) obj;
        }
        System.out.println("aqui foi modificado "+ obj);
    return obj;
    }
}
