package com.hitchsavan.testapp.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table( name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @NotBlank
    @Size(max = 120)
    @Getter @Setter private String body;

    @OneToMany(mappedBy = "answer")
    @Getter @Setter Set<AnswersQuestion> answersQuestion = new HashSet<>();

    @OneToMany(mappedBy = "answer")
    @Getter @Setter Set<ReportAnswers> reportAnswers = new HashSet<>();

    @OneToMany(mappedBy = "answer")
    @Getter @Setter Set<DetailedAnswers> detailedAnswer = new HashSet<>();

    public Answer() {}

    public Answer(String body) {
        this.body = body;
    }
}
