package com.hitchsavan.testapp.models;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
public class AnswersQuestion {
    
    @EmbeddedId
    @Getter @Setter private AnswersQuestionKey id;

    @ManyToOne
    @MapsId("answerId")
    @JoinColumn(name = "answer_id")
    @Getter @Setter private Answer answer;
    
    @ManyToOne
    @MapsId("questionId")
    @JoinColumn(name = "question_id")
    @Getter @Setter private Question question;

    @Getter @Setter private boolean isRight;

    public AnswersQuestion() {}

    public AnswersQuestion(boolean isRight) {
        this.isRight = isRight;
    }
}
