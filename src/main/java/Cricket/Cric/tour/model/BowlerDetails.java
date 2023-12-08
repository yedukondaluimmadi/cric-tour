package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BowlerDetails {
  private int id;
  private String name;
  private int ballNumber;
  private int overNumber;
  private int score;



  // Additional method to set ballNumber based on balls

}


