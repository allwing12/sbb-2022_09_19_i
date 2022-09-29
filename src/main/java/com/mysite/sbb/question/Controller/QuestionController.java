package com.mysite.sbb.question.Controller;

import com.mysite.sbb.question.Service.QuestionService;
import com.mysite.sbb.question.domain.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping("/question")
@Controller
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionService questionService;

    @RequestMapping("")
    public String index() {
        return "redirect:/question/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {

        List<Question> questionList = questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }
    @RequestMapping("/detail/{id}")
    public String detail(Model model, @PathVariable Integer id) {
        Question question = questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "Question_Detail";
    }
}