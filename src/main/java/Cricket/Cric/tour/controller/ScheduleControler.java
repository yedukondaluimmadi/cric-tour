package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.ScheduleTeamModel;
import Cricket.Cric.tour.service.ScheduleService;
import java.util.List;
import Cricket.Cric.tour.validation.ValidationSchedule;
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
    @Autowired
    private ValidationSchedule validationSchedule;

    @PostMapping
    public ResponseEntity<?> createSchedule(@RequestBody ScheduleTeamModel team) {
        List<String> validationErrors = validationSchedule.validateTeam(team);
        if (!validationErrors.isEmpty()) {
            // If validation errors exist, return a bad request response with the error messages
            return ResponseEntity.badRequest().body(validationErrors);
        }
        // If validation passes, proceed with scheduling
        return new ResponseEntity<>(scheduleService.scheduleATeam(team), HttpStatus.OK);
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
