package Cricket.Cric.tour.controller;


import Cricket.Cric.tour.model.*;

import Cricket.Cric.tour.service.*;
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

    @Autowired
    private UmpireService umpireService;

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
    @PostMapping("/score/live/teams")
    public ResponseEntity<TeamsLiveModel> getTeamsLiveModel(@RequestBody TeamsLiveModel teamsLiveModel) {
        TeamsLiveModel teamsLiveModels = liveTeamsService.getTeamsLiveModel();
        return new ResponseEntity<>(teamsLiveModels, HttpStatus.OK);
    }
    /*@PostMapping("/Quiz")
    public ResponseEntity<QuizModel> createQuiz(@RequestBody QuizModel quiz) {
        QuizModel createdQuiz = quizService.createQuiz(quiz);
        return new ResponseEntity<>(createdQuiz, HttpStatus.CREATED);
    }*/
    @PostMapping("/umpire/create")
    public ResponseEntity<String> registerUmpire(@RequestBody UmpireDetails umpireDetails) {
        String registrationMessage = umpireService.registerUmpire(umpireDetails);
        return new ResponseEntity<>(registrationMessage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UmpireDetails> getUmpireDetails(@PathVariable String id){

        return new ResponseEntity<>(umpireService.getUmpireDetailsById(id), HttpStatus.OK);
    }


}
