package com.adam.stan.answers;

import org.springframework.stereotype.Component;

import com.adam.stan.domain.AnswerDto;
import com.adam.stan.model.Answer;

@Component
public class AnswersMapperImpl implements AnswersMapper {
    @Override
    public AnswerDto answerToDto(Answer answer) {
        return AnswerDto.builder()
                .id(answer.getId())
                .answer(answer.getAnswer())
                .type(answer.getType().name())
                .build();
    }

}
