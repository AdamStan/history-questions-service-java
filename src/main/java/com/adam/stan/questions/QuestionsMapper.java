package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;
import com.adam.stan.model.Question;

public interface QuestionsMapper {
    QuestionDto questionToDto(Question question);
}
