package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NonStrikerDetails {
    private String striker;
    private int balls;
    private int runs;
    private int fours;
    private int sixes;
}