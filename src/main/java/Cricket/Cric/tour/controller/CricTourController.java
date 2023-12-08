package Cricket.Cric.tour.controller;



import Cricket.Cric.tour.model.CricTourRegisterModel;
import Cricket.Cric.tour.model.ScoreLiveBoard;
import Cricket.Cric.tour.service.CricTourService;
import Cricket.Cric.tour.service.ScoreLiveBoardService;
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
    private ScoreLiveBoardService scoreLiveBoardService;

    @PostMapping("/register")
    public String registerTeam(@RequestBody CricTourRegisterModel cricTourRegisterModel) {

        return cricTourService.registerTeam(cricTourRegisterModel);
    }

    @GetMapping("/health")
    public String health() {
        return "health is UP";
    }

    @GetMapping("/score/live/{id}")
    public ResponseEntity<ScoreLiveBoard> getLiveScore(@PathVariable int id) {
        return new ResponseEntity<>(scoreLiveBoardService.getLiveScore(id), HttpStatus.OK);
    }
}