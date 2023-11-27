package Cricket.Cric.tour.controller;


import Cricket.Cric.tour.service.CricTourService;
import Cricket.Cric.tour.model.TeamInfoRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/teams")
public class CricTourController {

    @Autowired
    public CricTourService cricTourService;

    @PostMapping("/register")
    public String registerTeam(@RequestBody TeamInfoRequest teamInfoRequest) {

        return cricTourService.registerTeam(teamInfoRequest);
    }

}