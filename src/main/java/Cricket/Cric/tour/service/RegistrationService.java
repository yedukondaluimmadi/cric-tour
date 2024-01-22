
package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.RegistrationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class RegistrationService {
    private final Map<String, RegistrationModel> registration = new HashMap<>();

    public ResponseEntity<String> registerUser(RegistrationModel registrationDetails) {
        if (isAnyFieldEmpty(registrationDetails)) {
            return new ResponseEntity<>("All information should be filled", HttpStatus.BAD_REQUEST);
        }

        if (registration.containsKey(registrationDetails.getMobile())) {
            return new ResponseEntity<>("User with mobile number " + registrationDetails.getMobile() + " already exists", HttpStatus.CONFLICT);
        }

        registration.put(registrationDetails.getMobile(), registrationDetails);
        String successMessage = "Successfully registered with mobile number: " + registrationDetails.getMobile();
        return new ResponseEntity<>(successMessage, HttpStatus.OK);
    }

    public ResponseEntity<?> getUserByMobile(String mobile) {
        RegistrationModel userDetails = registration.get(mobile);

        if (userDetails != null) {
            return new ResponseEntity<>(userDetails, HttpStatus.OK);
        } else {
            return new ResponseEntity<>("User not found for mobile number: " + mobile, HttpStatus.NOT_FOUND);
        }
    }

    private boolean isAnyFieldEmpty(RegistrationModel registrationDetails) {
        return registrationDetails.getFullName() == null || registrationDetails.getFullName().isEmpty() ||
                registrationDetails.getEmail() == null || registrationDetails.getEmail().isEmpty() ||
                registrationDetails.getCourse() == null || registrationDetails.getCourse().isEmpty() ||
                registrationDetails.getMobile() == null || registrationDetails.getMobile().isEmpty();
    }
}


