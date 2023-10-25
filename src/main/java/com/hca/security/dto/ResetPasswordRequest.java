package com.hca.security.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

/**
 * Created on Oct, 2023
 *
 * @author HCA
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
public class ResetPasswordRequest {

    @Email(message = "{registration_email_is_not_valid}")
    @NotEmpty(message = "{registration_email_not_empty}")
    private String email;

}
