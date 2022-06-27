package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionsService service;

    @GetMapping("/all")
    public List<QuestionDto> allQuestions() {
        return service.getAllQuestions();
    }

}
