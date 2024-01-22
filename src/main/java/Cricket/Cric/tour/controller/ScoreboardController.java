package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.ScoreboardModel;
import Cricket.Cric.tour.service.ScoreboardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/scoreboard")
public class ScoreboardController {

    @Autowired
    private ScoreboardService scoreboardService;

    @GetMapping
    public ResponseEntity<ScoreboardModel> getScoreBoard() {
        ScoreboardModel scoreboard = scoreboardService.getScoreboardDetails();
        return ResponseEntity.ok(scoreboard);
    }
}
