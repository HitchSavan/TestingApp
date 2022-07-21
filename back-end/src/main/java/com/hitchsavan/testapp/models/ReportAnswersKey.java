package com.hitchsavan.testapp.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import lombok.Getter;
import lombok.Setter;

@Embeddable
public class ReportAnswersKey implements Serializable{

    @Column(name = "report_id")
    @Getter @Setter Long reportId;

    @Column(name = "question_id")
    @Getter @Setter Long questionId;

    @Column(name = "answer_id")
    @Getter @Setter Long answerId;

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof ReportAnswersKey)) {
            return false;
        }
        ReportAnswersKey reportAnswersKey = (ReportAnswersKey) o;
        return Objects.equals(reportId, reportAnswersKey.reportId)
            && Objects.equals(questionId, reportAnswersKey.questionId)
            && Objects.equals(answerId, reportAnswersKey.answerId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reportId, questionId, answerId);
    }

}
