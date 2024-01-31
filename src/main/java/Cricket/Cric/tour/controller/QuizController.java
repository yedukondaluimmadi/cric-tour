package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.QuizDetails;
import Cricket.Cric.tour.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    /*@GetMapping("/all/{candidateId}")
    public ResponseEntity<String> getQuizzesByCandidateId(@PathVariable String candidateId) {
        String quizzes = quizService.getQuizzesByCandidateId(candidateId);
        return new ResponseEntity<>(quizzes, HttpStatus.OK);
    }*/
    @GetMapping("all/{testStack}")
    public ResponseEntity<List<QuizDetails>> getQuizzesByTestStack(@PathVariable String testStack) {
        List<QuizDetails> quizzes = quizService.getTestStack(testStack);
        if (!quizzes.isEmpty()) {
            return new ResponseEntity<>(quizzes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

}