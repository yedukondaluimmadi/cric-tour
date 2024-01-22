package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.QuizDetails;
import Cricket.Cric.tour.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/quiz")
public class QuizController {

    @Autowired
    private QuizService quizService;
    @PostMapping("/add")
    public QuizDetails addQuiz(@RequestBody QuizDetails quiz) {
        return quizService.addQuiz(quiz);
    }

    @GetMapping("/all")
    public List<QuizDetails> getAllQuizzes() {
        return quizService.getAllQuizzes();

    }
}