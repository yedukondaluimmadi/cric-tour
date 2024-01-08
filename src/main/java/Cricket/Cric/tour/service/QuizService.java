package Cricket.Cric.tour.service;
import Cricket.Cric.tour.model.QuizDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

@Service
public class QuizService {
    private final List<QuizDetails> quizList = new ArrayList<>(); // For demo purposes (data storage)
    public QuizDetails addQuiz(QuizDetails quiz) {
        quizList.add(quiz);
        return quiz;
    }

    public List<QuizDetails> getAllQuizzes() {

        // Shuffle the list using Collections.shuffle and a random seed
        long seed = System.nanoTime();
        Collections.shuffle(quizList, new Random(seed));

        // Return the first 10 questions (or fewer if there are less than 10 questions)
        return quizList.subList(0, Math.min(10, quizList.size()));
    }

}