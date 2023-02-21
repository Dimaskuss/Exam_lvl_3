package pro.sky.exam.service;

import pro.sky.exam.model.Question;

import java.util.Collection;
import java.util.Collections;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
