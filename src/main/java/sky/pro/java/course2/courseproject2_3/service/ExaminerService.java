package sky.pro.java.course2.courseproject2_3.service;

import sky.pro.java.course2.courseproject2_3.data.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
