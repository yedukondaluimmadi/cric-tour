package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartModel {
    private int id;
    private String team1;
    private String team2;
    private int overs;
    private Boolean isTeam1Batting;
    private Boolean isTeam2Batting;
}

