package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.QuestionModel;
import Cricket.Cric.tour.model.QuizDetails;
import Cricket.Cric.tour.model.SubmitAnswersModel;
import Cricket.Cric.tour.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/question")
public class QuestionController {
    @Autowired
    private QuestionService questionService;

    // Endpoint to submit answers
    @PostMapping("/submit")
    public ResponseEntity<List<SubmitAnswersModel>> addQuiz(@RequestBody SubmitAnswersModel submitAnswersModel) {
        List<SubmitAnswersModel> submittedAnswers = questionService.submitAnswers(submitAnswersModel);
        return new ResponseEntity<>(submittedAnswers, HttpStatus.OK);
    }

    // Endpoint to get answers by candidateId
    @GetMapping("/answers/{candidateId}")
    public ResponseEntity<SubmitAnswersModel> getAnswersByCandidateId(@PathVariable int candidateId) {
        SubmitAnswersModel answer = questionService.getAnswersByCandidateId(candidateId);
        return new ResponseEntity<>(answer, HttpStatus.OK);
    }

    @DeleteMapping("/answers/all/{securityId}")
    public ResponseEntity<String> deleteAnswersBySecurityId(@PathVariable int securityId) {
        String resp = questionService.deleteAnswersBySecurityId(securityId);
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

}
