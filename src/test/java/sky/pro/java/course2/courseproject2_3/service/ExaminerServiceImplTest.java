package sky.pro.java.course2.courseproject2_3.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import sky.pro.java.course2.courseproject2_3.data.Question;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static sky.pro.java.course2.courseproject2_3.constants.QuestionServiceTestConstants.JAVA_QUESTIONS_TEST;
import static sky.pro.java.course2.courseproject2_3.constants.QuestionServiceTestConstants.MATH_QUESTIONS_TEST;

@ExtendWith(MockitoExtension.class)
class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionService javaQuestionServiceMock;

    @Mock
    private MathQuestionService mathQuestionServiceMock;

    private ExaminerServiceImpl out;

    @BeforeEach
    private void setUp() {
        out = new ExaminerServiceImpl(javaQuestionServiceMock, mathQuestionServiceMock);
    }

    @Test
    public void checkQuantityOfQuestions() {
        when(javaQuestionServiceMock.getAll()).thenReturn(JAVA_QUESTIONS_TEST);
        List<Question> questionList = new ArrayList<>();
        questionList.addAll(JAVA_QUESTIONS_TEST);
        questionList.addAll(MATH_QUESTIONS_TEST);
        when(javaQuestionServiceMock.getRandomQuestion()).thenReturn(questionList.get(0)).
                thenReturn(questionList.get(1)).thenReturn(questionList.get(2)).
                thenReturn(questionList.get(3)).thenReturn(questionList.get(4));
        when(mathQuestionServiceMock.getRandomQuestion()).thenReturn(questionList.get(5)).
                thenReturn(questionList.get(6)).thenReturn(questionList.get(7)).
                thenReturn(questionList.get(8)).thenReturn(questionList.get(9));
        assertEquals(8, out.getQuestions(8).size());
    }
}
