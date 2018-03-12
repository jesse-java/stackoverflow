package com.naldojesse.stackoverflow.repositories;

import com.naldojesse.stackoverflow.models.Question;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface QuestionRepository extends CrudRepository<Question, Long>{
    List<Question> findAll();
}
