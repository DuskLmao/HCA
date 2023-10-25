package com.hca.controller;

import com.hca.security.dto.RegistrationRequest;
import com.hca.security.dto.RegistrationResponse;
import com.hca.security.dto.ResetPasswordRequest;
import com.hca.security.dto.ResetPasswordResponse;
import com.hca.security.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping("/reset-password")
public class ForgotPasswordController {
    private final UserService userService;

    @PostMapping
    public ResponseEntity<ResetPasswordResponse> resetPassword(@Valid @RequestBody ResetPasswordRequest resetPasswordRequest) {

        final ResetPasswordResponse resetPasswordResponse = userService.resetPassword(resetPasswordRequest);

        return ResponseEntity.status(HttpStatus.CREATED).body(resetPasswordResponse);
    }
}
