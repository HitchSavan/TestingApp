package com.hitchsavan.testapp.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class AnswersQuestionKey implements Serializable{

    @Column(name = "answer_id")
    @Getter @Setter Long answerId;

    @Column(name = "question_id")
    @Getter @Setter	Long questionId;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof AnswersQuestionKey)) {
            return false;
        }
        AnswersQuestionKey answersQuestionKey = (AnswersQuestionKey) o;
        return Objects.equals(answerId, answersQuestionKey.answerId) && Objects.equals(questionId, answersQuestionKey.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(answerId, questionId);
    }

}
