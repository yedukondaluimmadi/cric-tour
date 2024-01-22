package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.ScoreboardModel;
import org.springframework.stereotype.Service;

@Service
public class ScoreboardService {

    public ScoreboardModel getScoreboardDetails() {
        // In a real-world scenario, you would fetch this information from a database or another data source
        // For the sake of this example, creating a dummy scoreboard
        ScoreboardModel scoreboard = new ScoreboardModel();
        scoreboard.setTeamAScore(150);
        scoreboard.setTeamBScore(120);
        // Set playerModelList if needed

        return scoreboard;
    }
}
