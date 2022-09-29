package com.mysite.sbb.answer.controller;

import com.mysite.sbb.answer.Service.AnswerService;
import com.mysite.sbb.question.Service.QuestionService;
import com.mysite.sbb.question.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequestMapping("/answer")
@RequiredArgsConstructor
@Controller
public class AnswerController {
    private final QuestionService questionService;
    private final AnswerService answerService;

    @PostMapping("/create/{id}")
    public String createAnswer(Model model, @PathVariable("id") Integer id, @RequestParam String content){
        Question question = questionService.getQuestion(id);
        answerService.create(question, content);
        // 할 일 : 답변 생성
        return String.format("redirect:/question/detail/%s", id);
    }
}
