package com.site.ssb.service;

import com.site.ssb.DateNotFoundException;
import com.site.ssb.Repository.QuestionRepository;
import com.site.ssb.entity.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }

    public Question getQuestion(Integer id){
        Optional<Question> question = questionRepository.findById(id);
        if (question.isPresent()){
            return question.get();
        } else {
             throw new DateNotFoundException("question not found");
        }
    }

}
