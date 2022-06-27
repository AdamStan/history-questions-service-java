package com.adam.stan.answers;

import org.springframework.data.jpa.repository.JpaRepository;

import com.adam.stan.model.Answer;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswersRepository extends JpaRepository<Answer, Long> {

}
