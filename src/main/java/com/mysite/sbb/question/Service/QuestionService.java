package com.mysite.sbb.question.Service;

import com.mysite.sbb.question.dao.QuestionRepository;
import com.mysite.sbb.question.domain.Question;
import com.mysite.sbb.util.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionService {
    private final QuestionRepository questionRepository;

    public List<Question> getList() {
        return questionRepository.findAll();
    }
    public Question getQuestion(Integer id) {
//        Optional<Question> questionOptional = questionRepository.findById(id);
//        if(questionOptional.isPresent()) {
//            return questionOptional.get();
//        } else {
//            throw new DataNotFoundException("question not found");
//        }
        return questionRepository.findById(id).orElseThrow(() -> new DataNotFoundException("question not found"));
    }
}