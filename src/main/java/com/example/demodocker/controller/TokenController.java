package com.example.demodocker.controller;

import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
@RequestMapping("/token")
@SecurityRequirement(name = "bearerAuth")
public class TokenController {

    @GetMapping
    public Jwt getToken(@AuthenticationPrincipal Jwt jwt){
        return jwt;
    }
}
