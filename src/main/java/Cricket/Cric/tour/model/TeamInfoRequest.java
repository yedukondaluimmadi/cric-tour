package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TeamInfoRequest {

    private String name;

    private String teamName;

    private String dist;

    private Integer aadhar;

    private Boolean isCaptain;

    private Boolean isViceCaptain;
}
