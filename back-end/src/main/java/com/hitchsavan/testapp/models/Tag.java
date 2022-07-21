package com.hitchsavan.testapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "tags")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Size(max = 120)
    @Getter @Setter private String name;

    @ManyToMany(mappedBy = "testTags")
    @Setter Set<Test> tagsTest = new HashSet<>();

    @ManyToMany(mappedBy = "questionTags")
    @Setter Set<Question> tagsQuestion = new HashSet<>();

    public Tag() {}

    public Tag(String name) {
        this.name = name;
    }
}
