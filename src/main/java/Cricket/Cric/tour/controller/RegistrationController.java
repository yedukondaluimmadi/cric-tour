package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.RegistrationModel;
import Cricket.Cric.tour.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody RegistrationModel registrationDetails) {
        ResponseEntity<String> responseEntity = registrationService.registerUser(registrationDetails);
        return new ResponseEntity<>(responseEntity.getBody(), responseEntity.getStatusCode());
    }

    @GetMapping("/user/{mobile}")
    public ResponseEntity<?> getUserByMobile(@PathVariable String mobile) {
        return registrationService.getUserByMobile(mobile);
    }
}
