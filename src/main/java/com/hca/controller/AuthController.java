package com.hca.controller;

import com.hca.security.dto.*;
import com.hca.security.jwt.JwtTokenService;
import com.hca.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {
    private final JwtTokenService jwtTokenService;
    private final UserService userService;
    @PostMapping("/login")
    public ResponseEntity<Response<String>> loginRequest(@Valid @RequestBody LoginRequest loginRequest) {

        final Response<String> loginResponse = jwtTokenService.getLoginResponse(loginRequest);

        return ResponseEntity.ok(loginResponse);
    }

    @PostMapping("/register")
    public ResponseEntity<Response<Object>> registrationRequest(@Valid @RequestBody RegistrationRequest registrationRequest) {

        final Response<Object> registrationResponse = userService.registration(registrationRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(registrationResponse);
    }

    @PostMapping("/reset-password")
    public ResponseEntity<Response<Object>> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {

        final Response<Object> resetPasswordResponse = userService.resetPassword(resetPasswordRequest);

        return ResponseEntity.status(HttpStatus.OK).body(resetPasswordResponse);
    }

}
