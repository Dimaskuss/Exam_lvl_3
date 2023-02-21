package pro.sky.exam.service;

import org.springframework.stereotype.Service;
import pro.sky.exam.model.Question;

import java.util.*;

@Service

public class ExaminerServiceImpl implements ExaminerService {
    private final QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
        Collection<Question> collection = new HashSet<>();

        if (amount > questionService.getAll().size()) {
            return null;
        }
        do {

            collection.add(questionService.getRandomQuestion());

        }
        while (collection.size() < amount);

        return collection;


    }
}



