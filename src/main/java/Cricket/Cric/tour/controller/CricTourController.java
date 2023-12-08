package Cricket.Cric.tour.controller;


import Cricket.Cric.tour.model.BowlerDetails;
import Cricket.Cric.tour.model.CricTourRegisterModel;
import Cricket.Cric.tour.model.ScoreBoardsResponse;
import Cricket.Cric.tour.model.ScoreRunsModel;
import Cricket.Cric.tour.service.CricTourService;
import Cricket.Cric.tour.service.ScoreRunsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class CricTourController {

    @Autowired
    private CricTourService cricTourService;

    @Autowired
    private ScoreRunsService scoreRunsService;

    @PostMapping("/register")
    public String registerTeam(@RequestBody CricTourRegisterModel cricTourRegisterModel) {

        return cricTourService.registerTeam(cricTourRegisterModel);
    }
    @GetMapping("/health")
    public String health(){
        return "health is UP";
    }

    @PostMapping("/start/score/live/{id}")
    public ResponseEntity<ScoreBoardsResponse> getLiveScore(@PathVariable int id, @RequestBody ScoreRunsModel scoreRunsModel) {
        ScoreBoardsResponse scoreBoardsResponse = scoreRunsService.getLiveScore(id, scoreRunsModel);
        return new ResponseEntity<>(scoreBoardsResponse, HttpStatus.OK);
    }
    @PostMapping("/update/bowler/{id}")
    public ResponseEntity<BowlerDetails> updateBowlerDetails(@PathVariable int id, @RequestBody BowlerDetails bowlerDetails) {
        BowlerDetails updatedBowlerDetails = scoreRunsService.convertBowlerDetails(id, bowlerDetails.getName(), bowlerDetails.getBallNumber(), bowlerDetails.getOverNumber(), bowlerDetails.getScore());
        return new ResponseEntity<>(updatedBowlerDetails, HttpStatus.OK);
    }

}