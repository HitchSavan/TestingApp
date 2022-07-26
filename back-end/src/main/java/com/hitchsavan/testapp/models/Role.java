package com.hitchsavan.testapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    @Getter @Setter private ERole name;

    @OneToMany(mappedBy = "role")
    @Setter Set<User> user = new HashSet<>();

    public Role() {}

    public Role(ERole name) {
        this.name = name;
    }
}
