package com.hitchsavan.testapp.payload.request;

import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

public class LoginRequest {
    @NotBlank
    @Getter @Setter private String username;

    @NotBlank
    @Getter @Setter private String email;

    @NotBlank
    @Getter @Setter private String password;
}
