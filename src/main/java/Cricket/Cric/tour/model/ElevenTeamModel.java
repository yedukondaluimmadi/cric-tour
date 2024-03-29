package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ElevenTeamModel {
    private  Integer teamId;
    private  String teamName;
    private  String dist;
    private  String captainName;
    private  String viceCaptainName;
    private  String[] teamMembers;

}
