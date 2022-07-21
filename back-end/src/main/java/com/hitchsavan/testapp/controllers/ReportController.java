package com.hitchsavan.testapp.controllers;

import java.sql.Date;
import java.sql.Time;
import java.util.List;
import java.util.Objects;

import com.hitchsavan.testapp.models.Report;
import com.hitchsavan.testapp.repository.ReportRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reports")
public class ReportController {

    private final ReportRepository reportRepository;

    public ReportController(ReportRepository reportRepository) {
        this.reportRepository = reportRepository;
    }

    @GetMapping
    public List<Report> getReports() {
        return (List<Report>) reportRepository.findAll();
    }

    @PostMapping
    void addReport(@RequestBody Report report) {
        reportRepository.save(report);
    }

    @DeleteMapping(path = "{id}")
    void deleteReport(@PathVariable("id") Long id) {
        if(!reportRepository.existsById(id)) {
            throw new IllegalStateException(
                "Report with " + id + "does not exist"
            );
        }
        reportRepository.deleteById(id);
    }

    @PutMapping(path = "{id}")
    void updateProduct( @PathVariable("id") Long id,
                        @RequestParam(required = false) float interimAssessment,
                        @RequestParam(required = false) Date date,
                        @RequestParam(required = false) Time length,
                        @RequestParam(required = false) boolean status) {
        Report report = reportRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "Report with " + id + "does not exist"
            ));
        
        if(interimAssessment > 0 &&
            !Objects.equals(report.getInterimAssessment(), interimAssessment)) {
                report.setInterimAssessment(interimAssessment);
            }

        if(date != null &&
            !Objects.equals(report.getDate(), date)) {
            report.setDate(date);
            }

        if(length != null &&
            !Objects.equals(report.getLength(), length)) {
                report.setLength(length);
            }

        if(!Objects.equals(report.isStatus(), status)) {
                report.setStatus(status);
            }
    }
}
