package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;
import com.adam.stan.model.Question;
import org.springframework.stereotype.Component;

@Component
public class QuestionsMapperImpl implements QuestionsMapper {

    @Override
    public QuestionDto questionToDto(Question question) {
        return QuestionDto.builder()
                .id(question.getId())
                .question(question.getQuestion())
                .answer(question.getAnswer() != null ? question.getAnswer().getAnswer() : null)
                .answerType(question.getAnswer() != null ? question.getAnswer().getType().name(): null)
                .build();
    }
}
