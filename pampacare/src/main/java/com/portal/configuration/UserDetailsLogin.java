package com.portal.configuration;

import org.springframework.security.core.userdetails.UserDetails;

import com.portal.entity.Login;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import java.util.Collection;
import java.util.Collections;

public class UserDetailsLogin implements UserDetails{ 
    
    private Login login;

    public UserDetailsLogin(Login login) {
        super();
        this.login = login;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(new SimpleGrantedAuthority(login.getRole()));
    }

    @Override
    public String getPassword() {
        return this.login.getPassword();
    }

    @Override
    public String getUsername() {
        return this.login.getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
