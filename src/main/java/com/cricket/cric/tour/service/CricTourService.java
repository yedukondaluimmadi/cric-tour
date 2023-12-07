package com.cricket.cric.tour.service;

import com.cricket.cric.tour.model.CricTourRegisterModel;
import com.cricket.cric.tour.model.ScoreLive;
import org.springframework.stereotype.Service;

@Service
public class CricTourService {

    public String registerTeam(CricTourRegisterModel cricTourRegisterModel){

        return "Successfully Registered "+ cricTourRegisterModel.getTeamName()+ " Team";
    }

}
