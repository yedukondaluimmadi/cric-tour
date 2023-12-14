package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamsLiveModel {
    private String date ;
    private String matchLocation;
    private TeamsDetails teamsDetails ;
}

