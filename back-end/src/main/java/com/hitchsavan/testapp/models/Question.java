package com.hitchsavan.testapp.models;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "question")
public class Question {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Size(max = 120)
    @Getter @Setter private String body;

    @NotBlank
    @Getter @Setter private int type;

    @NotBlank
    @Getter @Setter private Date date;

    @ManyToMany
    @JoinTable(
        name = "tagsquestion",
        joinColumns = @JoinColumn(name = "question_id"),
        inverseJoinColumns = @JoinColumn(name = "tag_id"))
    @Getter @Setter Set<Tag> questionTags = new HashSet<>();

    @OneToMany(mappedBy = "question")
    @Getter @Setter Set<TestQuestion> questionsTest = new HashSet<>();

    @OneToMany(mappedBy = "question")
    @Getter @Setter Set<AnswersQuestion> questionAnswers = new HashSet<>();

    @OneToMany(mappedBy = "question")
    @Getter @Setter Set<ReportAnswers> reportAnswers = new HashSet<>();

    @OneToMany(mappedBy = "question")
    @Getter @Setter Set<DetailedAnswers> detailedAnswers = new HashSet<>();

    public Question() {}

    public Question(String body, int type, Date date) {
        this.body = body;
        this.type = type;
        this.date = date;
    }
}
