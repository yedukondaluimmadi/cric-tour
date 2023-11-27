package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.TeamInfoRequest;
import org.springframework.stereotype.Service;

@Service
public class CricTourService {

    public String registerTeam(TeamInfoRequest teamInfoRequest){

        return "Succssfully created "+ teamInfoRequest.getTeamName()+ " Team";
    }

}
