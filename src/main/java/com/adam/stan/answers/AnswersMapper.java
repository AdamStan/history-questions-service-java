package com.adam.stan.answers;

import com.adam.stan.domain.AnswerDto;
import com.adam.stan.model.Answer;

public interface AnswersMapper {
   AnswerDto answerToDto(Answer answer);
}
