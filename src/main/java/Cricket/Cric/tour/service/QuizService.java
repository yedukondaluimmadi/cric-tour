package Cricket.Cric.tour.service;
import Cricket.Cric.tour.model.QuizDetails;
import Cricket.Cric.tour.model.SubmitAnswersModel;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class QuizService {

    private final List<SubmitAnswersModel> submittedAnswers = new ArrayList<>();
    private final List<QuizDetails> quizList = new ArrayList<>(); // For demo purposes (data storage)
    public QuizDetails addQuiz(QuizDetails quiz) {
        quizList.add(quiz);
        return quiz;
    }
    public List<QuizDetails> getAllQuizzes() {
        long seed = System.nanoTime();
        Collections.shuffle(quizList, new Random(seed));
        return quizList.subList(0, Math.min(10, quizList.size()));
    }
    public List<QuizDetails> getTestStack(String testStack) {
        return quizList.stream()
                .filter(quiz -> testStack.equals(quiz.getTestStack()))
                .collect(Collectors.toList());
    }
}