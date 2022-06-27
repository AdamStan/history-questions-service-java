package com.adam.stan.questions;

import com.adam.stan.domain.QuestionDto;
import com.adam.stan.model.AnswerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
class QuestionsControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    QuestionsService questionsService;

    @BeforeEach
    void setUp() {
        when(questionsService.getAllQuestions()).thenReturn(List.of(
                QuestionDto.builder().id(1L).question("a?").answer("a!").answerType(AnswerType.TEXT.name()).build(),
                QuestionDto.builder().id(2L).question("s?").answer("s!").answerType(AnswerType.TEXT.name()).build()
        ));
    }

    @Test
    void testAllQuestions() throws Exception {
        mockMvc.perform(get("/questions/all")).andDo(print()).andExpect(content().json("[{\"id\":1,\"question\":\"a?\",\"answer\":\"a!\",\"answerType\":\"TEXT\"},{\"id\":2,\"question\":\"s?\",\"answer\":\"s!\",\"answerType\":\"TEXT\"}]"));
    }
}
