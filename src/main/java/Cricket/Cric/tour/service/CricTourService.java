package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.CricTourRegisterModel;
import org.springframework.stereotype.Service;

@Service
public class CricTourService {

    public String registerTeam(CricTourRegisterModel cricTourRegisterModel){

        return "Succssfully created "+ cricTourRegisterModel.getTeamName()+ " Team";
    }

}
