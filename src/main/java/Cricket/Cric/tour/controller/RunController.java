package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.PlayerModel;
import Cricket.Cric.tour.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/runs")
public class RunController {

    @Autowired
    private PlayerService playerService;
    @PostMapping
    public ResponseEntity<String> recordRun(@RequestBody PlayerModel playerModel) {
        String response = playerService.recordRun(playerModel);
        return ResponseEntity.ok(response);
    }


}


