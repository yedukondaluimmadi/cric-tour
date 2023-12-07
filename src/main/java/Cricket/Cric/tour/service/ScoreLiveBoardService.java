package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.BowlerDetails;
import Cricket.Cric.tour.model.NonStrikerDetails;
import Cricket.Cric.tour.model.ScoreLiveBoard;
import Cricket.Cric.tour.model.StrikerDetails;
import org.springframework.stereotype.Service;

// ScoreLiveBoardService.java
@Service
public class ScoreLiveBoardService {

    public ScoreLiveBoard getLiveScore(int id) {
        ScoreLiveBoard score = new ScoreLiveBoard();
        score.setId(id);

        score.setStriker(new StrikerDetails("Rohit", 35, 55, 5, 4));
        score.setNonStriker(new NonStrikerDetails("King", 55, 85, 8, 8));
        score.setBowler(new BowlerDetails(10, 2, 30));

        return score;
    }
}
