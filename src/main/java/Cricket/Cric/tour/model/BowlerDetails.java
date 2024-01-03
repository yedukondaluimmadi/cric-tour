package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BowlerDetails {
    private int id;
    private int teamId;
    private String oppositeTeam;
    private int overNumber;
    private int previousBall;
    private int currentBall;
    private String[] currentOverDetails;
    private List<String[]> previousOverDetails;

}
