package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BowlerModel {
    private String name;
    private double over;
    private int maiden;
    private int run;
    private int wicket;
    private int noBall;
    private int wide;
    private double economy;
}
