package Cricket.Cric.tour.controller;


import Cricket.Cric.tour.model.CricTourRegisterModel;
import Cricket.Cric.tour.service.CricTourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/teams")
public class CricTourController {

    @Autowired
    public CricTourService cricTourService;

    @PostMapping("/register")
    public String registerTeam(@RequestBody CricTourRegisterModel cricTourRegisterModel) {

        return cricTourService.registerTeam(cricTourRegisterModel);
    }
    @GetMapping("/health")
    public String health(){
        return "health checkUp is UP";
    }

}