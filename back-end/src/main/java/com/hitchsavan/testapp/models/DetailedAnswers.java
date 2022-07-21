package com.hitchsavan.testapp.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class DetailedAnswers {
    
    @EmbeddedId
    @Getter @Setter private DetailedAnswersKey id;

    @ManyToOne
    @MapsId("reportId")
    @JoinColumn(name = "report_id")
    @Getter @Setter private Report report;

    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @Getter @Setter private Question question;

    @ManyToOne
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    @Getter @Setter private Answer answer;

    @Getter @Setter private String answered;

    public DetailedAnswers() {}

    public DetailedAnswers(String answered) {
        this.answered = answered;
    }
}
