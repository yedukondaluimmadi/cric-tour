package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.BowlerDetails;
import Cricket.Cric.tour.model.ScoreBoardsResponse;
import Cricket.Cric.tour.model.ScoreDetails;

import Cricket.Cric.tour.model.ScoreRunsModel;
import org.springframework.stereotype.Service;

@Service
public class ScoreDetailsService {

    public ScoreDetails updateScore(int id, ScoreDetails scoreDetails) {
        scoreDetails.setId(id);

        if(scoreDetails.getBowlerDetails().getOverNumber() !=5){
            return null;
        }
        return scoreDetails;

    }

}

