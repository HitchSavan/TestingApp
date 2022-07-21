package com.hitchsavan.testapp.controllers;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

import com.hitchsavan.testapp.models.Question;
import com.hitchsavan.testapp.repository.QuestionRepository;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth/questions")
public class QuestionController {
    
    private final QuestionRepository questionRepository;

    public QuestionController(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @GetMapping
    public List<Question> getQuestions() {
        return (List<Question>) questionRepository.findAll();
    }
    
    @PostMapping
    void addQuestion(@RequestBody Question question) {
        questionRepository.save(question);
    }

    @DeleteMapping(path = "{id}")
    void deleteTag(@PathVariable("id") Long id) {
        if(!questionRepository.existsById(id)) {
            throw new IllegalStateException(
                "Question with " + id + "does not exist"
            );
        }
        questionRepository.deleteById(id);
    }

    @PutMapping(path = "id")
    void updateQuestions(@PathVariable("id") long id,
                     @RequestParam(required = false) String body,
                     @RequestParam(required = false) int type,
                     @RequestParam(required = false) Date date) {
        Question question = questionRepository.findById(id)
            .orElseThrow(() -> new IllegalStateException(
                "ERROR: Question with this id not found."
            ));

        if(body != null &&
            !Objects.equals(question.getBody(), body)) {
                question.setBody(body);
            }

        if(!Objects.equals(question.getType(), type)) {
                question.setType(type);
            }

        if(date != null &&
            !Objects.equals(question.getDate(), date)) {
                question.setDate(date);
            }
    }
}