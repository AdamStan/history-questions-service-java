package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;
import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import com.adam.stan.model.Question;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuestionsMapperImplTest {
    QuestionsMapper mapper = new QuestionsMapperImpl();

    @Test
    void questionToDtoTest_AnswerNull() {
        Question question = Question.builder()
                .id(24L)
                .question("Are you sure?")
                .answer(null)
                .build();
        QuestionDto dto = mapper.questionToDto(question);
        assertAll(
                () -> assertEquals(question.getId(), dto.getId()),
                () -> assertEquals(question.getQuestion(), dto.getQuestion())
        );
    }

    @Test
    void questionToDtoTest_AnswerNotNull() {
        Answer answer = Answer.builder()
                .id(2354L)
                .answer("YES")
                .type(AnswerType.PERSON)
                .build();
        Question question = Question.builder()
                .id(24L)
                .question("Are you sure?")
                .answer(answer)
                .build();
        QuestionDto dto = mapper.questionToDto(question);
        assertAll(
                () -> assertEquals(question.getId(), dto.getId()),
                () -> assertEquals(question.getQuestion(), dto.getQuestion()),
                () -> assertEquals(question.getAnswer().getAnswer(), dto.getAnswer()),
                () -> assertEquals(question.getAnswer().getType().name(), dto.getAnswerType())
        );
    }

}