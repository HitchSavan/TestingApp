package com.hitchsavan.testapp.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class TestQuestionKey implements Serializable{

    @Column(name = "test_id")
    @Getter @Setter Long testId;

    @Column(name = "question_id")
    @Getter @Setter Long questionId;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof TestQuestionKey)) {
            return false;
        }
        TestQuestionKey testQuestionKey = (TestQuestionKey) o;
        return Objects.equals(testId, testQuestionKey.testId) && Objects.equals(questionId, testQuestionKey.questionId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(testId, questionId);
    }

}
