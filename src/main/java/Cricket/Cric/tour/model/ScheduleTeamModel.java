package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScheduleTeamModel {
    private int gameId;
    private String location;
    private String dist;
    private String date;
    private List<ElevenTeamModel> team;
}