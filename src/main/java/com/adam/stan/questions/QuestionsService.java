package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;

import java.util.List;

public interface QuestionsService {
    List<QuestionDto> getAllQuestions();
}
