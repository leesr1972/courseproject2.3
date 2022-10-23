package sky.pro.java.course2.courseproject2_3.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.courseproject2_3.data.Question;
import sky.pro.java.course2.courseproject2_3.exceptions.MethodNotAllowedException;

import java.util.Collection;
import java.util.Random;

@Service
public class MathQuestionService implements QuestionService{
//    private final QuestionRepository mathQuestionRepository;
    private Random random = new Random();

//    public MathQuestionService(QuestionRepository mathQuestionRepository) {
//        this.mathQuestionRepository = mathQuestionRepository;
//    }

    public void setRandom() {
        this.random = random;
    }

    @Override
    public Question add(String question, String answer) {
        throw new MethodNotAllowedException("Метод не найден.");
    }

    @Override
    public Question remove(String question) {
        throw new MethodNotAllowedException("Метод не найден.");
    }

    @Override
    public Collection<Question> getAll() {
        throw new MethodNotAllowedException("Метод не найден.");
    }

    @Override
    public Question getRandomQuestion() {
        int num1 = random.nextInt(100);
        int num2 = random.nextInt(100);
        int sign = random.nextInt(4);
        return switch (sign) {
            case 0 -> new Question(num1 + " + "
                    + num2 + " = ", String.valueOf(num1 + num2));
            case 1 -> new Question(num1 + " - "
                    + num2 + " = ", String.valueOf(num1 - num2));
            case 2 -> new Question(num1 + " * "
                    + num2 + " = ", String.valueOf(num1 * num2));
            case 3 -> new Question(num1 + " / "
                    + num2 + " = ", String.valueOf(num1 / num2));
            default -> null;
        };
    }
}
