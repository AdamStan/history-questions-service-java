package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionsService {
    private final QuestionsRepository repository;
    private final QuestionsMapper mapper;

    @Override
    public List<QuestionDto> getAllQuestions() {
        return repository.findAll().stream().map(mapper::questionToDto).collect(Collectors.toList());
    }
}
