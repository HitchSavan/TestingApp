package com.hitchsavan.testapp.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class TestQuestion {
    
    @EmbeddedId
    @Getter @Setter private TestQuestionKey id;

    @ManyToOne
    @MapsId("testId")
    @JoinColumn(name = "test_id")
    @Getter @Setter private Test test;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @Getter @Setter private Question question;

    @Getter @Setter private int number;

    public TestQuestion() {}

    public TestQuestion(int number) {
        this.number = number;
    }
}
