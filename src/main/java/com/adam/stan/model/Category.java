package com.adam.stan.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
@Entity(name = "categories")
public class Category {

    @Id
    private Integer id;
    private String period;
    private String country;
    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY)
    private List<Answer> answers;
}
