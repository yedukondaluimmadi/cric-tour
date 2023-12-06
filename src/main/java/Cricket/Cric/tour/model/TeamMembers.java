package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamMembers {

    private String name;

    private String aadhar;

    private Boolean isCaptain;

    private Boolean isViceCaptain;
}
