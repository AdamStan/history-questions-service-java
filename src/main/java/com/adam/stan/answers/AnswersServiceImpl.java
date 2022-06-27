package com.adam.stan.answers;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.adam.stan.domain.AnswerDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AnswersServiceImpl implements AnswersService {

    private final AnswersRepository repository;
    private final AnswersMapper mapper;

    @Override
    @Cacheable(value = "allAnswers")
    public List<AnswerDto> getAllAnswers() {
        return repository.findAll().stream().map(mapper::answerToDto).collect(Collectors.toList());
    }

}
