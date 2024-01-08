package Cricket.Cric.tour.validation;

import org.springframework.stereotype.Component;

@Component
public class ValidationRequest {
    private String id;
    private String name;
    private String dist;
    private String phoneNumber;
    private String aadhar;
    private String pan;
    private String emailAddress;

    // Constructors, getters, and setters can be added here

    // Validation method
    public boolean isValid() {
        return isValidId(id) && isValidPhoneNumber(phoneNumber)
                && isValidAadhar(aadhar) && isValidPan(pan)
                && isValidEmailAddress(emailAddress);
    }

    private boolean isValidId(String id) {
        // Implement logic to validate the ID (6 digits)
        return id != null && id.matches("\\d{6}");
    }

    private boolean isValidPhoneNumber(String phoneNumber) {
        // Implement logic to validate the phone number (10 digits)
        return phoneNumber != null && phoneNumber.matches("\\d{10}");
    }

    private boolean isValidAadhar(String aadhar) {
        // Implement logic to validate the Aadhar number (12 digits)
        return aadhar != null && aadhar.matches("\\d{12}");
    }

    private boolean isValidPan(String pan) {
        // Implement logic to validate the PAN number (10 characters)
        return pan != null && pan.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}");
    }

    private boolean isValidEmailAddress(String emailAddress) {
        // Implement logic to validate the email address (basic check)
        return emailAddress != null && emailAddress.matches(".+@.+\\..+");
    }
}
