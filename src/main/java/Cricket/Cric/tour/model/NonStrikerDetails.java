package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NonStrikerDetails {
    private int id;
    private String name;
    private int runs;
    private int balls;
    private int fours;
    private int sixes;
    private String strikeRate;
}


