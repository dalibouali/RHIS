package com.example.rhisdemo.controller;

import com.example.rhisdemo.Dto.AuthenticationRequest;
import com.example.rhisdemo.Dto.AuthenticationResponse;
import com.example.rhisdemo.entities.User;
import com.example.rhisdemo.security.JwtUtil;
import com.example.rhisdemo.services.AuthorizationSE;
import com.example.rhisdemo.services.ServiceImplementation;
import com.example.rhisdemo.services.ServiceInterface;

import io.jsonwebtoken.Claims;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.nio.file.attribute.UserPrincipal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    private final ServiceInterface userService;
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    private final ServiceImplementation userServiceImplementation;
    @Autowired
    private JwtUtil jwtUtil;
    @Autowired AuthorizationSE authorizationSE;

    public AuthController(ServiceInterface userService, AuthenticationManager authenticationManager, ServiceImplementation userServiceImplementation,AuthorizationSE authorizationSE) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.userServiceImplementation = userServiceImplementation;
        this.authorizationSE=authorizationSE;
    }



    @RequestMapping(value ="/signin", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthentificationToken(@RequestBody AuthenticationRequest request) throws Exception {


        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
            System.out.println("User authenticated successfully");
        }catch (BadCredentialsException e) {

            return ResponseEntity
                    .status(HttpStatus.FORBIDDEN)
                    .body("Username or password invalid");

        }


        final UserDetails userDetails = userServiceImplementation.loadUserByUsername(request.getUsername());
        String access_token= jwtUtil.generateToken(userDetails);



        return ResponseEntity.ok(new AuthenticationResponse(access_token));
    }
    @CrossOrigin(origins = "*")
    @PostMapping("/register")
    public ResponseEntity<User> saveUser(@RequestBody User user) {
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/register").toUriString());

        return ResponseEntity.created(uri).body(userService.addUser(user));
    }



    @GetMapping("/privileges/{username}")
    public ResponseEntity<?>getPrevileges(@PathVariable String username){
        return ResponseEntity.status(HttpStatus.OK).body(authorizationSE.getPrivileges(username));
    }
}
