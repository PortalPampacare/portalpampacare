package com.portal.configuration;

import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

public class JwtConfiguration extends SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity> {
    
        private JwtTokenProvider tokenProvider;

        public JwtConfiguration(JwtTokenProvider token){
            this.tokenProvider = token;
        }

        @Override
        public void configure(HttpSecurity http) throws Exception{
            http.addFilterBefore(new JwtTokenFilter(tokenProvider), UsernamePasswordAuthenticationFilter.class);
        }
}
