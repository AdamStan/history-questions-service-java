package com.adam.stan.answers;

import com.adam.stan.domain.AnswerDto;
import com.adam.stan.model.AnswerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AnswersControllerTest {
    @LocalServerPort
    int port;

    @Autowired
    TestRestTemplate restTemplate;

    @MockBean
    AnswersService service;

    @BeforeEach
    public void setUp() {
        when(service.getAllAnswers()).thenReturn(List.of(
                AnswerDto.builder().id(1L).answer("A1").type(AnswerType.CITY.name()).build(),
                AnswerDto.builder().id(2L).answer("23").type(AnswerType.YEAR.name()).build()
        ));
    }

    @Test
    public void getAllAnswersTests() {
        AnswerDto[] answers = restTemplate.getForObject("http://localhost:" + port + "/answers/all", AnswerDto[].class);
        assertAll(
                () -> assertEquals("A1", answers[0].getAnswer()),
                () -> assertEquals("23", answers[1].getAnswer()),
                () -> assertEquals(AnswerType.CITY.name(), answers[0].getType()),
                () -> assertEquals(AnswerType.YEAR.name(), answers[1].getType())
        );
    }
}