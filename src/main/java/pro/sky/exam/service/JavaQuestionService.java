package pro.sky.exam.service;

import org.springframework.stereotype.Service;
import pro.sky.exam.model.Question;

import java.util.*;

@Service
public class JavaQuestionService implements QuestionService {

    private final Set<Question> questionSet = new HashSet<>();


    @Override
    public Question questionAdd(String question, String answer) {
        if (question.isEmpty() || answer.isEmpty()
                || question.isBlank() || answer.isBlank()
        ) {
            return null;
        }
        Question question1 = new Question(question, answer);
        questionSet.add(question1);
        return question1;
    }

    @Override
    public Question questionAdd(Question question) {
        if (question.getQuestion() != null || question.getAnswer() != null
                || !question.getQuestion().isEmpty() || !question.getAnswer().isEmpty()
                || !question.getQuestion().isBlank() || !question.getAnswer().isBlank()
        ) {
            questionSet.add(question);
            return question;
        }
        return null;
    }

    @Override
    public boolean remove(Question question) {
        if (questionSet.contains(question)) {
            questionSet.remove(question);
            return true;
        }
        return false;
    }

    @Override
    public Collection<Question> getAll() {
        return new ArrayList<>(questionSet);
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int randomValue = random.nextInt(questionSet.size());
        int iteratorValue = 0;
        for (Question question : questionSet) {
            if (iteratorValue == randomValue) {
                return question;
            }
            iteratorValue++;

        }

        return null;
    }
}
