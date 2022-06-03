package com.upm.miw.tfm.eatitauth.web.dto;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
@Builder
public class AuthenticationDTO {

    @NotBlank
    private final String username;

    @NotBlank
    private final String password;
}
