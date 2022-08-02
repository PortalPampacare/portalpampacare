// package com.portal.controller;

// import org.slf4j.Logger;
// import org.slf4j.LoggerFactory;
// import org.codehaus.jettison.json.JSONException;
// import org.codehaus.jettison.json.JSONObject;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.MediaType;
// import org.springframework.http.ResponseEntity;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
// import org.springframework.security.core.Authentication;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.CrossOrigin;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;

// import com.portal.configuration.JwtTokenProvider;
// import com.portal.entity.Login;
// import com.portal.repository.LoginRepository;

// @Controller
// @RequestMapping("/auth")
// @CrossOrigin
// public class LoginController {
// 	private static Logger log = LoggerFactory.getLogger(LoginController.class);
//     @Autowired
//     private AuthenticationManager authenticationManager;
//     @Autowired
//     private JwtTokenProvider tokenProvider;
//     @Autowired
//     private LoginRepository loginRepository;

//     @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//     public ResponseEntity<String> authenticate(@RequestBody Login l) {
//         log.info("UserResourceImpl : authenticate");
//         JSONObject json = new JSONObject();
//         try {
//             Authentication auth = authenticationManager
//                     .authenticate(new UsernamePasswordAuthenticationToken(l.getEmail(), l.getPassword()));
//             if (auth.isAuthenticated()) {
//                 json.put("name", auth.getName());
//                 json.put("authorities", auth.getAuthorities());
//                 json.put("token", tokenProvider.creatToken(l.getEmail(), loginRepository.findByEmail(l.getEmail()).getRole()));
//                 return new ResponseEntity<>(json.toString(), HttpStatus.OK);
//             }

//         } catch (JSONException e) {
//             try {
//                 System.out.println("Aaaaaaaaaaa "+ l.toString());
//                 json.put("exception", e.getMessage());
//             } catch (JSONException e1) {
//                 e1.printStackTrace();
//             }
//             return new ResponseEntity<String>(json.toString(), HttpStatus.UNAUTHORIZED);
//         }
//         return null;
//     }

// }
