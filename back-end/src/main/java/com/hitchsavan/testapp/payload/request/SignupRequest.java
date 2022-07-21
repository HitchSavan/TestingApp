package com.hitchsavan.testapp.payload.request;

import java.util.Set;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

public class SignupRequest {
    @NotBlank
    @Size(min = 3, max = 50)
    @Getter @Setter private String username;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String email;

    @Getter @Setter private Set<String> role;

    @NotBlank
    @Size(min = 6, max = 50)
    @Getter @Setter private String password;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String firstName;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String lastName;
}
