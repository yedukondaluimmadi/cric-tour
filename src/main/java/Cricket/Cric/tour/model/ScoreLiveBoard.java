package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScoreLiveBoard {
    private int id;
    private StrikerDetails striker;
    private NonStrikerDetails nonStriker;
    private BowlerDetails bowler;

}
