package com.portal.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import com.portal.entity.Login;
import com.portal.repository.LoginRepository;

@Service
public class UserAuthService implements UserDetailsService {

  @Autowired
  LoginRepository loginRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Login login = loginRepository.findByEmail(username);
    if (login == null) {
      throw new UsernameNotFoundException("Usuario não encontrado");
    }
    return new UserDetailsLogin(login); 
  }
  
}