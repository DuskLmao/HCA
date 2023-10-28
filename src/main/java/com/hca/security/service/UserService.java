package com.hca.security.service;

import com.hca.model.User;
import com.hca.security.dto.*;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
public interface UserService {

	User findByUsername(String username);

	Response<Object> registration(RegistrationRequest registrationRequest);

	Response<Object> resetPassword(ResetPasswordRequest resetPasswordRequest);

	AuthenticatedUserDto findAuthenticatedUserByUsername(String username);

}
