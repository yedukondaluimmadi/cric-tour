package Cricket.Cric.tour.controller;


import Cricket.Cric.tour.model.*;

import Cricket.Cric.tour.service.CricTourService;
import Cricket.Cric.tour.service.GameService;
import Cricket.Cric.tour.service.LiveTeamsService;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/teams")
public class CricTourController {

    @Autowired
    public CricTourService cricTourService;

    @Autowired
    private GameService gameService;

    @Autowired
    private LiveTeamsService liveTeamsService;







    @PostMapping("/register")
    public String registerTeam(@RequestBody CricTourRegisterModel cricTourRegisterModel) {

        return cricTourService.registerTeam(cricTourRegisterModel);
    }
    @GetMapping("/health")
    public String health(){
        return "health is UP";
    }

    @PostMapping("/game/start/{id}")
    public ResponseEntity<String> startGame(@PathVariable("id") int id, @RequestBody GameStartModel gameStartModel) {
        String result = gameService.startGame(gameStartModel);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
    @GetMapping("/score/live/teams")
    public ResponseEntity<TeamsLiveModel> getTeamsLiveModel() {
        TeamsLiveModel teamsLiveModel = liveTeamsService.getTeamsLiveModel();
        return new ResponseEntity<>(teamsLiveModel, HttpStatus.OK);
    }

}
