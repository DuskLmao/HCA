package com.hca.security.service;

import com.hca.security.dto.*;
import com.hca.service.UserValidationService;
import com.hca.model.User;
import com.hca.model.UserRole;
import com.hca.security.mapper.UserMapper;
import com.hca.utils.GeneralMessageAccessor;
import com.hca.repository.UserRepository;
import com.hca.utils.Utils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

	private static final String REGISTRATION_SUCCESSFUL = "registration_successful";

	private final UserRepository userRepository;

	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	private final UserValidationService userValidationService;

	private final GeneralMessageAccessor generalMessageAccessor;

	@Override
	public User findByUsername(String username) {

		return userRepository.findByUsername(username);
	}

	@Override
	public RegistrationResponse registration(RegistrationRequest registrationRequest) {

		userValidationService.validateUser(registrationRequest);

		final User user = UserMapper.INSTANCE.convertToUser(registrationRequest);
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setUserRole(UserRole.USER);

		userRepository.save(user);

		final String username = registrationRequest.getUsername();
		final String registrationSuccessMessage = generalMessageAccessor.getMessage(null, REGISTRATION_SUCCESSFUL, username);

		log.info("{} registered successfully!", username);

		return new RegistrationResponse(registrationSuccessMessage);
	}

	@Override
	public ResetPasswordResponse resetPassword(ResetPasswordRequest resetPasswordRequest) {
		ResetPasswordResponse res = new ResetPasswordResponse();
		String email = resetPasswordRequest.getEmail();

		User user = userRepository.findByEmail(email);
		if (user == null) {
			res.setMessage("Email không tồn tại");
			res.setSuccess(false);
		} else {
			String randomPassword = Utils.generatePassword(6);
			user.setPassword(bCryptPasswordEncoder.encode(randomPassword));
			userRepository.save(user);
			res.setMessage("Một email chứa mật khẩu đã được gửi đến bạn.");
			res.setSuccess(true);

			// TODO: Lâm: Send email
		}
		return res;
	}

	@Override
	public AuthenticatedUserDto findAuthenticatedUserByUsername(String username) {

		final User user = findByUsername(username);

		return UserMapper.INSTANCE.convertToAuthenticatedUserDto(user);
	}
}
