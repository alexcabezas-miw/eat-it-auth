package com.upm.miw.tfm.eatitauth.web;

import com.upm.miw.tfm.eatitauth.service.AuthService;
import com.upm.miw.tfm.eatitauth.web.dto.AuthenticationDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(AuthController.AUTH_PATH)
public class AuthController {

    private final AuthService authService;

    public final static String AUTH_PATH = "/auth";

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping
    public ResponseEntity<?> authenticate(@RequestBody @Valid AuthenticationDTO authenticationDTO) {
        boolean authenticate = this.authService.authenticate(authenticationDTO.getUsername(), authenticationDTO.getPassword());
        return ResponseEntity.ok().body(authenticate);
    }
}
