package com.adam.stan.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity
@Table(name = "answers")
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String answer;
    @Enumerated(EnumType.STRING)
    private AnswerType type;
    @OneToMany(mappedBy = "answer", fetch = FetchType.LAZY)
    private List<Question> questions;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "column_id", nullable = false)
    private Category category;
}
