package com.hitchsavan.testapp.models;

import java.sql.Time;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "report")
public class Report {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter private long id;

    @Getter @Setter private float interimAssessment;

    @Getter @Setter private Date date;

    @Getter @Setter private Time length;

    @Getter @Setter private boolean status;

    @OneToMany(mappedBy = "report")
    @Setter Set<ReportAnswers> reportAnswers = new HashSet<>();

    @OneToMany(mappedBy = "report")
    @Setter Set<DetailedAnswers> detailedAnswers = new HashSet<>();

    public Report() {}

    public Report(float interimAssessment, Date date, Time length, boolean status) {
        this.interimAssessment = interimAssessment;
        this.date = date;
        this.length = length;
        this.status = status;
    }    
}
