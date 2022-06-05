package sky.pro.java.course2.courseproject2_3.service;

import org.springframework.stereotype.Service;
import sky.pro.java.course2.courseproject2_3.data.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService{
    private final List<QuestionService> questionServices;
    private final List<Question> listOfQuestions = new ArrayList<>();

    public ExaminerServiceImpl(QuestionService javaQuestionService, QuestionService mathQuestionService) {
        this.questionServices = new ArrayList<>(List.of(javaQuestionService, mathQuestionService));
    }


    @Override
    public Collection<Question> getQuestions(int amount) {
//        if (amount > javaQuestionService.getAll().size() + mathQuestionService.getAll().size()) {
//            throw new BadRequestException("Запрошено слишком много вопросов.");
//        }
        int quantityOfJavaQuestions;
        Random random = new Random();
        if (amount <= questionServices.get(0).getAll().size()) {
            quantityOfJavaQuestions = random.nextInt(amount - 1) + 1;
        } else {
            quantityOfJavaQuestions = random.nextInt(questionServices.get(0).getAll().size()
                    - amount/2) + amount/2;
        }
        Question addedQuestion;
        while (listOfQuestions.size()<quantityOfJavaQuestions){
            addedQuestion = questionServices.get(0).getRandomQuestion();
            if (!(listOfQuestions.contains(addedQuestion))) {
                listOfQuestions.add(addedQuestion);
            }
        }
        while (listOfQuestions.size()<amount){
            addedQuestion = questionServices.get(1).getRandomQuestion();
            if (!(listOfQuestions.contains(addedQuestion))) {
                listOfQuestions.add(addedQuestion);
            }
        }
        return listOfQuestions;
    }
}
