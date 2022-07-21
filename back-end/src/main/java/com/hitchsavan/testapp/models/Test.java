package com.hitchsavan.testapp.models;

import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "test")
public class Test {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Getter @Setter private int type;

    @NotBlank
    @Getter @Setter private Time length;

    @ManyToMany
    @JoinTable(
        name = "tagstest",
        joinColumns = @JoinColumn(name = "test_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Getter @Setter Set<Tag> testTags = new HashSet<>();

    @OneToMany(mappedBy = "test")
    @Getter @Setter Set<TestQuestion> testQuestions = new HashSet<>();

    public Test() {}

    public Test(int type, Time length) {
        this.type = type;
        this.length = length;
    }
}
