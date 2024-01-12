package Cricket.Cric.tour.controller;


import Cricket.Cric.tour.service.InningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


    @RestController
    @RequestMapping("/api/inning")
    public class  InningController {

        @Autowired
        private InningService inningService;

        @PostMapping("/start")
        public ResponseEntity<String> startInning() {
            inningService.startInning();
            return ResponseEntity.ok("Inning started");
        }

        @PostMapping("/end")
        public ResponseEntity<String> endInning() {
            inningService.endInning();
            return ResponseEntity.ok("Inning ended");
        }
    }


