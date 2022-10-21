package com.site.ssb.controller;

import com.site.ssb.Repository.QuestionRepository;
import com.site.ssb.entity.Question;
import com.site.ssb.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;
    @GetMapping(value = "/question/list")
    public String list(Model model){
        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
}
