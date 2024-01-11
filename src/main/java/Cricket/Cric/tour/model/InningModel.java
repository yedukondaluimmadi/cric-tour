package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InningModel {
    private int runs;
    private int wickets;
    private double overs;
    private double runRate;
    private List<PlayerModel> batters;
    private List<BowlerModel> bowlers;
    private ExtraModel extras;
}
