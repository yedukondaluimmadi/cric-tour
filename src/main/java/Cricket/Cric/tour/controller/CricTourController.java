package Cricket.Cric.tour.controller;
import Cricket.Cric.tour.model.*;
import Cricket.Cric.tour.service.CricTourService;
import Cricket.Cric.tour.service.ScoreDetailsService;
import Cricket.Cric.tour.service.ScoreRunsService;
import Cricket.Cric.tour.service.UmpireService;
import Cricket.Cric.tour.validation.UmpireValidation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;



@Slf4j
@RestController
@RequestMapping("/api/teams")
class CricTourController{

    @Autowired
    private CricTourService cricTourService;

    @Autowired
    private ScoreRunsService scoreRunsService;

    @Autowired
    private UmpireService umpireService;

    @Autowired
    private UmpireValidation umpireValidation;

    @Autowired
   private  ScoreDetailsService scoreDetailsService ;
    @PostMapping("/register")
    public String registerTeam(@RequestBody CricTourRegisterModel cricTourRegisterModel) {

        return cricTourService.registerTeam(cricTourRegisterModel);
    }

    @GetMapping("/health")
    public String health() {

        return "health is UP";
    }

    @PostMapping("/start/score/live/{id}")
    public ResponseEntity<ScoreBoardsResponse> getLiveScore(@PathVariable int id, @RequestBody ScoreRunsModel scoreRunsModel) {
        ScoreBoardsResponse scoreBoardsResponse = scoreRunsService.getLiveScore(id, scoreRunsModel);
        return new ResponseEntity<>(scoreBoardsResponse, HttpStatus.OK);
    }

    @PostMapping("/umpire/create")
    public ResponseEntity<String> registerUmpire(@RequestBody   UmpireDetails umpireDetails) throws Exception {
        try {
            umpireValidation.validateUmpire(umpireDetails);
            String registrationMessage = umpireService.registerUmpire(umpireDetails);
            return new ResponseEntity<>(registrationMessage, HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error during umpire registration", e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);

        }

      /*   @GetMapping("/{id}")
         public ResponseEntity<String> registerUmpire(@RequestBody UmpireDetails umpireDetails){
            String registrationMessage = umpireService.registerUmpire(umpireDetails);
            return new ResponseEntity<>(registrationMessage,HttpStatus.OK);
        }*/
    }

    @PostMapping("/live/score/{id}/update")
    public ResponseEntity<ScoreDetails> updateScore(@PathVariable int id, @RequestBody ScoreDetails scoreDetails) {
        ScoreDetails updatedScoreDetails = scoreDetailsService.updateScore(id, scoreDetails);
        return new ResponseEntity<>(updatedScoreDetails,HttpStatus.OK);
        }
    }





