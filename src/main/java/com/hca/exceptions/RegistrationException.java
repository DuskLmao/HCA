package com.hca.exceptions;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@Getter
@RequiredArgsConstructor
public class RegistrationException extends RuntimeException {

	private final String errorMessage;

}
