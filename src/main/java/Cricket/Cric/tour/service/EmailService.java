package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.RegistrationModel;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Random;

@Service
public class EmailService {
    public void sendEmail(String to, RegistrationModel contactInfo) throws MessagingException, UnsupportedEncodingException {
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        String username = "admin@sloperateinc.com";
        String password = "kjcsjngqrgdiycrc";

        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress("admin@sloperateinc.com","Slope Rate Techno Private Limited"));

        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
        message.setSubject("Registered Successfully (" +generateRegistrationNumber(contactInfo.getCourse())+ ")");
      //  message.setText(getEmailBody(contactInfo.getFullName()));
        message.setContent(getEmailBody(contactInfo.getFullName()), "text/html");


        Transport.send(message);

    }
    public static String getEmailBody(String recipientName) {
        return "<html><body style='font-family: Arial, sans-serif;'>" +
                "<p>Hi " + recipientName + ",</p>" +
                "<p>Thank you for registering with Slope Rate Techno Private Limited. We are excited to have you onboard! Below are the details of your policy:</p>" +
                "<p><a href='https://slopeare-register-policy.tiiny.site'>Policy Details Link</a></p>" +
                "<p><b>Registration: A nominal fee of INR 500 is required to attend the first 4 days of sessions. </b></p>" +
                "<p>To proceed with the registration process, please use the following <b>UPI ID</b>:</p>" +
                "<p>UPI: <b><a href='upi://sloperatetechnoprivatelimited.8500298398.ibz@icici'>sloperatetechnoprivatelimited.8500298398.ibz@icici</a></b></p>" +
                "<p>Once you have completed the payment process, kindly revert to us with the UPI transaction ID details.</p>" +
                "<p>If you have any questions or need further assistance, please don't hesitate to contact us.</p>" +
                "<div style='display: flex; align-items: center;'>" + // Flex container for the two boxes
                "<div style='flex-grow: 1; padding-right: 20px; border-right: 1px solid #ccc;'>" + // First box for contact information
                "<p style='font-weight: bold;'>Thanks & Regards,<br/>Slope Rate Techno Private Limited<br/>" +
                "+91 6281 248 144<br/>" +
                "+91 8500 298 398</p>" +
                "https://sloperateinc.com "+
                "</div>" + // End of first box
                "<div style='flex-grow: 1; padding-left: 20px;'>" + // Second box for the image and address
                "<img src='https://i.ibb.co/7RfLr6C/Slope-Rate-Techno.jpg' alt='Slope Rate Techno' style='width: 200px;'>" +
                "<p style='font-weight: bold;'>Address:<br/>behind Suryaa News Paper HO, Ayyappa Society,<br/>Siddhi Vinayak Nagar, Madhapur,<br/>Hyderabad, Telangana 500081</p>" +
                "</div>" + // End of second box
                "</div>" + // End of flex container
                "</body></html>";
    }



    public static String generateRegistrationNumber( String techStack) {

        String techStackDigit = techStack.substring(0, 2);

        Random random = new Random();
        int randomDigits = random.nextInt(900000) + 100000;
        return techStackDigit.toUpperCase() + String.valueOf(randomDigits);
    }


}
