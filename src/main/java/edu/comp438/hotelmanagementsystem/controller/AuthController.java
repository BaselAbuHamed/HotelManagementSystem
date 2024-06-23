package edu.comp438.hotelmanagementsystem.controller;

import edu.comp438.hotelmanagementsystem.config.PasswordEncoderConfig;
import edu.comp438.hotelmanagementsystem.dto.JwtRequest;
import edu.comp438.hotelmanagementsystem.dto.JwtResponse;
import edu.comp438.hotelmanagementsystem.entity.User;
import edu.comp438.hotelmanagementsystem.security.JwtTokenUtil;
import edu.comp438.hotelmanagementsystem.service.UserService;
import edu.comp438.hotelmanagementsystem.service.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final JwtTokenUtil jwtTokenUtil;
    private final UserDetailsServiceImpl userDetailsService;
    private final PasswordEncoderConfig passwordEncoderConfig;
    private final UserService userService;

    @Autowired
    public AuthController(AuthenticationManager authenticationManager,UserService userService,PasswordEncoderConfig passwordEncoderConfig, JwtTokenUtil jwtTokenUtil, UserDetailsServiceImpl userDetailsService) {
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.passwordEncoderConfig = passwordEncoderConfig;
        this.userService = userService;
    }

    @PostMapping("/authenticate")
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
//            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
            User user = userService.findByUsername(username);
            if (!passwordEncoderConfig.passwordEncoder().matches(password, user.getPassword())) {
                throw new UsernameNotFoundException("INVALID_CREDENTIALS");
            }
        } catch (Exception e) {

            throw new UsernameNotFoundException("INVALID_CREDENTIALS", e);
        }
    }
}
