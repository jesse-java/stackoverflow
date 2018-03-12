package com.naldojesse.stackoverflow.services;

import com.naldojesse.stackoverflow.models.Question;
import com.naldojesse.stackoverflow.repositories.QuestionRepository;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class QuestionService {

    private QuestionRepository questionRepository;
    public QuestionService(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    public List<Question> findAll() {
        return questionRepository.findAll();
    }

    public void addQuestion(Question question){
            questionRepository.save(question);
    }

}
