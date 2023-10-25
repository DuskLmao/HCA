package com.hca.security.dto;

import com.hca.model.AppVersion;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AppVersionResponse {
    public AppVersion appVersion;
}
