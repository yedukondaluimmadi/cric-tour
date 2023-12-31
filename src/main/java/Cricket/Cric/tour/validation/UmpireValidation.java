package Cricket.Cric.tour.validation;

import Cricket.Cric.tour.model.UmpireDetails;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Component
public class UmpireValidation {

    String panCardPattern = "[A-Z]{5}[0-9]{4}[A-Z]{1}";
    String phoneNumberPattern = "[0-9]{10}";

    String namePattern="[a-zA-Z]{1,12}";

    String emailAddressPattern= "[a-zA-Z0-9]+@(gmail\\.com|outlook\\.com|outlook\\.in)" ;

    String aadharPattern ="[0-9]{12}";
    public void validateUmpire(UmpireDetails umpireDetails) throws Exception {
        Pattern pattern = Pattern.compile(panCardPattern);
        if (umpireDetails.getPan() == null) {
            throw new Exception("Please Check input Pan Number");
        }
        Matcher matcher = pattern.matcher(umpireDetails.getPan());

        if (!matcher.matches()) {
            throw new Exception("Please Check input pan Number");
        }
        Pattern pattern1 = Pattern.compile(phoneNumberPattern);
            if (umpireDetails.getPhoneNumber()== null){
                throw  new Exception("Please check input phone Number");
            }
            Matcher matcher1 = pattern1.matcher(umpireDetails.getPhoneNumber());
            if (!matcher1.matches()) {
                throw new Exception("Please check input phone Number");
            }
            Pattern pattern2 = Pattern.compile(namePattern);
    if (umpireDetails.getName()==null){
         throw new Exception("please check input name");
     }
     Matcher matcher2 = pattern2.matcher(umpireDetails.getName());
     if (!matcher2.matches()){
         throw new Exception("please check input name");
     }
Pattern pattern3 = Pattern.compile(emailAddressPattern);
     if (umpireDetails.getEmailAddress()==null){
         throw new Exception("please check input emailAddress");
     }

        String emailDetails = Optional.of(umpireDetails.getEmailAddress()).orElse("").replace("\\","");
     Matcher matcher3 = pattern3.matcher(emailDetails);
     if (!matcher3.matches()){
         throw new Exception("please check input emailAddress");
     }
     Pattern pattern4 = Pattern.compile(aadharPattern);
     if (umpireDetails.getAadhar()==null){
         throw new Exception("please check input AadharNumber");
     }
     Matcher matcher4 = pattern4.matcher(umpireDetails.getAadhar());
     if (!matcher4.matches()){
         throw new Exception("please check input AadharNumber");
     }
    }
}
