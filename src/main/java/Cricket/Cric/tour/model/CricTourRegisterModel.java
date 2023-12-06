package Cricket.Cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CricTourRegisterModel {
    private String teamName;
    private String dist;
    private List<TeamMembers> teamMembers;

}
