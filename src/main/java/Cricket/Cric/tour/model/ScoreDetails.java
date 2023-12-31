package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreDetails {
    private int id;
    private int teamId ;
    private String teamName;
    private String location;
    private String currentBall;
    private String previousBall;
    private String[] previousOver;
    private String[] currentOver;
    private String striker ;
    private String nonStriker;
    private BowlerDetails bowlerDetails;
}
