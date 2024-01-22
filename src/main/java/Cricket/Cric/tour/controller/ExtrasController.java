package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.ExtraModel;
import Cricket.Cric.tour.service.ExtrasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/extras")
public class ,,, {

    @Autowired
    private ExtrasService extrasService;
    @PostMapping
    public ResponseEntity<String> recordExtras(@RequestBody ExtraModel extraModel) {
        String response = String.valueOf(extrasService.recordExtras(extraModel));
        return ResponseEntity.ok("Extras recorded successfully");
    }
}
