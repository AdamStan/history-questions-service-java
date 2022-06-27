package com.adam.stan.answers;

import com.adam.stan.domain.AnswerDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/answers")
@RequiredArgsConstructor
public class AnswersController {
    private final AnswersService service;

    @GetMapping("/all")
    public List<AnswerDto> allAnswers() {
        return service.getAllAnswers();
    }
}
