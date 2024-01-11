package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PlayerModel {
    private int id;
    private String name;
    private int run;
    private int ball;
    private int four;
    private int six;
    private double strikeRate;
}
