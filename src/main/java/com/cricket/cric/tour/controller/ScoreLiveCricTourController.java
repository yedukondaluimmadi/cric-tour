package com.cricket.cric.tour.controller;


import com.cricket.cric.tour.model.CricTourRegisterModel;
import com.cricket.cric.tour.model.ScoreLive;
import com.cricket.cric.tour.service.CricTourService;
import com.cricket.cric.tour.service.ScoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class ScoreLiveCricTourController {

    @Autowired
    public CricTourService cricTourService;
   @Autowired
   public ScoreService scoreService;

    @PostMapping("/register")
    public String registerTeam(@RequestBody CricTourRegisterModel cricTourRegisterModel) {

        return cricTourService.registerTeam(cricTourRegisterModel);
    }
    @GetMapping("/health")
    public String health(){
        return "health is UP";
    }

    @PostMapping("/score/live")
    public ScoreLive getLiveScore(@RequestBody ScoreLive scoreLive) {
        return scoreService.scorelive(scoreLive);
    }

}