package com.hca.controller;

import com.hca.model.User;
import com.hca.repository.UserRepository;
import com.hca.security.dto.UserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@RestController
public class UserController {

	@Autowired
	private UserRepository userRepository;
	@GetMapping("/me")
	public ResponseEntity<User> getUser() {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		String username = authentication.getName();
		User loggedInUser = userRepository.findByUsername(username);

		return ResponseEntity.ok(loggedInUser);
	}
}