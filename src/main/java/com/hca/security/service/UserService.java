package com.hca.security.service;

import com.hca.model.User;
import com.hca.security.dto.AuthenticatedUserDto;
import com.hca.security.dto.RegistrationRequest;
import com.hca.security.dto.RegistrationResponse;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
public interface UserService {

	User findByUsername(String username);

	RegistrationResponse registration(RegistrationRequest registrationRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
