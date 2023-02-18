package pro.sky.exam.service;

import pro.sky.exam.model.Question;

import java.util.Collection;

public interface QuestionService {

    Question questionAdd(String question, String answer);

    Question questionAdd(Question question);

    boolean remove(Question question);

    Collection<Question> getAll();

    Question getRandomQuestion();

}
