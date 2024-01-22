package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegistrationModel {
    private String fullName;
    private String email;
    private String course;
    private String mobile;
}