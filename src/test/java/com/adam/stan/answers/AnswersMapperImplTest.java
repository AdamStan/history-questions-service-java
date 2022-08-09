package com.adam.stan.answers;

import com.adam.stan.domain.AnswerDto;
import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

//TODO: Please parametrize it!
class AnswersMapperImplTest {

    @Test
    void answerToDtoTest() {
        AnswersMapperImpl mapper = new AnswersMapperImpl();
        Answer answer = Answer.builder()
                .id(23L)
                .answer("Answer1")
                .type(AnswerType.PERSON)
                .build();
        AnswerDto dto = mapper.answerToDto(answer);
        assertAll(
                () -> assertEquals(answer.getId(), dto.getId()),
                () -> assertEquals(answer.getAnswer(), dto.getAnswer()),
                () -> assertEquals(answer.getType().name(), dto.getType())
        );
    }

}