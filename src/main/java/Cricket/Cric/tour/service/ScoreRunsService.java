package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.*;
import org.springframework.stereotype.Service;

@Service
public class ScoreRunsService {

    public ScoreBoardsResponse getLiveScore(int id, ScoreRunsModel scoreRunsModel) {

        ScoreBoardsResponse scoreBoardsResponse = new ScoreBoardsResponse();
        scoreBoardsResponse.setId(id);
        scoreBoardsResponse.setBowlerDetails(scoreRunsModel.getBowlerDetails());
        scoreBoardsResponse.setStrikerDetails(scoreRunsModel.getStrikerDetails());
        scoreBoardsResponse.setNonStrikerDetails(scoreRunsModel.getNonStrikerDetails());

        return scoreBoardsResponse;


    }
}
