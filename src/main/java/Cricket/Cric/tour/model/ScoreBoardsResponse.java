package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreBoardsResponse {
   private int id;
   private StrikerDetails strikerDetails;
   private NonStrikerDetails nonStrikerDetails;
   private BowlerDetails bowlerDetails;

}