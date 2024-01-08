package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.QuestionModel;
import Cricket.Cric.tour.model.SubmitAnswersModel;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuestionService {
    private final List<SubmitAnswersModel> submittedAnswers = new ArrayList<>();


    public List<SubmitAnswersModel> submitAnswers(SubmitAnswersModel submitAnswersModel) {

        submittedAnswers.add(submitAnswersModel);
        return submittedAnswers; // Return the list of submitted answers
    }

    // Method to retrieve answers by candidateId
    public SubmitAnswersModel getAnswersByCandidateId(int candidateId) {
        if( !ObjectUtils.isEmpty(submittedAnswers)){
           List<SubmitAnswersModel> candidateAnswers =  submittedAnswers.stream().filter(submitAnswersModel -> candidateId == submitAnswersModel.getCandidateId()).collect(Collectors.toList());
           return ObjectUtils.isEmpty(candidateAnswers) ? null : candidateAnswers.get(0);

        }
        return null;
    }

    public String deleteAnswersBySecurityId(int securityId) {

        if(securityId == 6565){
            submittedAnswers.clear();
            return "Submitted Successfully";
        }
        return "Entered PIN WRONG";
    }
}
