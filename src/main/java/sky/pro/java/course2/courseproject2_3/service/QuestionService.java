package sky.pro.java.course2.courseproject2_3.service;

import sky.pro.java.course2.courseproject2_3.data.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question);
    Collection<Question> getAll();
    Question getRandomQuestion();
}
