package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MatchModel {
    private String team1;
    private String team2;
    private List<PlayerModel> team1Players;
    private List<PlayerModel> team2Players;
    private int maxOver;
}
