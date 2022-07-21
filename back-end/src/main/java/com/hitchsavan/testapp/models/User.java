package com.hitchsavan.testapp.models;

import javax.persistence.*;
import javax.validation.constraints.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "users",
        uniqueConstraints = {
            @UniqueConstraint(columnNames = "username"),
            @UniqueConstraint(columnNames = "email")
        })
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String username;

    @NotBlank
    @Size(max = 50)
    @Email
    @Getter @Setter private String email;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String password;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String firstName;

    @NotBlank
    @Size(max = 50)
    @Getter @Setter private String lastName;

    @ManyToOne
    @JoinColumn(name = "role_id")
    @Getter @Setter private Role role;

    public User() {}

    public User(String username, String email, String password, String firstName, String lastName) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }
}