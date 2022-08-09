package com.adam.stan.answers;

import com.adam.stan.config.CacheConfig;
import com.adam.stan.domain.AnswerDto;
import com.adam.stan.model.Answer;
import com.adam.stan.model.AnswerType;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.cache.CacheAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Import;
import redis.embedded.RedisServer;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.List;

import static org.mockito.Mockito.*;

@Import({ CacheConfig.class })
@SpringBootTest
@EnableCaching
@ImportAutoConfiguration(classes = {
        CacheAutoConfiguration.class,
        RedisAutoConfiguration.class
})
class AnswersServiceIntegrationTest {

    @MockBean
    AnswersRepository answersRepository;

    @Autowired
    AnswersService answersService;

    @Test
    void testCache_getAllAnswers() {
        Answer anItem = Answer.builder().id(234L).answer("AA!").type(AnswerType.CITY).build();
        when(answersRepository.findAll()).thenReturn(List.of(anItem));

        List<AnswerDto> answersL1 = answersService.getAllAnswers();
        List<AnswerDto> answersL2 = answersService.getAllAnswers();
        List<AnswerDto> answersL3 = answersService.getAllAnswers();

        verify(answersRepository, times(1)).findAll();
    }

    @TestConfiguration
    static class EmbeddedRedisConfiguration {

        private final RedisServer redisServer;

        public EmbeddedRedisConfiguration() throws IOException {
            this.redisServer = new RedisServer(6379);
        }

        @PostConstruct
        public void startRedis() {
            redisServer.start();
        }

        @PreDestroy
        public void stopRedis() {
            this.redisServer.stop();
        }
    }
}