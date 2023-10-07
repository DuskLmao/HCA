package com.hca.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiExceptionResponse {

	private String message;

	private HttpStatus status;

	private LocalDateTime time;

}
