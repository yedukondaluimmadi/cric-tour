package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.ScheduleTeamModel;
import Cricket.Cric.tour.service.ScheduleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/schedule"})
public class ScheduleControler {
    @Autowired
    private ScheduleService scheduleService;

    @PostMapping
    public ResponseEntity<ScheduleTeamModel> createSchedule(@RequestBody ScheduleTeamModel team) {
        return new ResponseEntity<>(this.scheduleService.scheduleATeam(team), HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<ScheduleTeamModel>> getSchedules() {
        return new ResponseEntity<>(this.scheduleService.getSchedules(), HttpStatus.OK);
    }

    @GetMapping({"/{gameId}"})
    public ResponseEntity<ScheduleTeamModel> getSchedulesByGameId(@PathVariable int gameId) {
        return new ResponseEntity<>(this.scheduleService.getScheduleByGameId(gameId), HttpStatus.OK);
    }
}