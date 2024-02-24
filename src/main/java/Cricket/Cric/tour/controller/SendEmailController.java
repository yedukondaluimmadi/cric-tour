package Cricket.Cric.tour.controller;

import Cricket.Cric.tour.model.RegistrationModel;
import Cricket.Cric.tour.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/api")
public class SendEmailController {
    @Autowired
    private EmailService emailService;

    @PostMapping("/send-email/{to}")
    public ResponseEntity<String> sendEmail(
            @PathVariable String to,
            @RequestBody RegistrationModel contactInfo) {
        try {
            emailService.sendEmail(to, contactInfo);
            return ResponseEntity.ok("Email sent successfully!");
        } catch (MessagingException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");
        } catch (UnsupportedEncodingException e) {
           // throw new RuntimeException(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email.");

        }
    }

}
