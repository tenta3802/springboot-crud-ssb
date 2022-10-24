package com.site.ssb.controller;

import com.site.ssb.Repository.QuestionRepository;
import com.site.ssb.entity.Question;
import com.site.ssb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "/question")
@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    @RequestMapping(value = "/list")
    public String list(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    @RequestMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }
}
