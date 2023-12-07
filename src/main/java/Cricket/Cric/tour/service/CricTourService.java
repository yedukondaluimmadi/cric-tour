package Cricket.Cric.tour.service;
import Cricket.Cric.tour.model.CricTourRegisterModel;
import Cricket.Cric.tour.model.TeamMembers;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CricTourService {

    private final Map<String, CricTourRegisterModel> teams = new HashMap<>();

    public String registerTeam(CricTourRegisterModel cricTourRegisterModel){

        return "Successfully Registered "+ cricTourRegisterModel.getTeamName()+ " Team";
    }
    public  CricTourRegisterModel updateTeamDetails(String teamId, CricTourRegisterModel updatedTeam) {


        List<TeamMembers> teamMembers = new ArrayList<>();

        TeamMembers teamMembers1 = new TeamMembers();

        teamMembers1.setName("Sateesh");
        teamMembers1.setAadhar("1244");
        teamMembers1.setIsCaptain(true);
        teamMembers1.setIsViceCaptain(false);

        TeamMembers teamMembers2 = new TeamMembers();
        teamMembers2.setName("konda");
        teamMembers2.setAadhar("1344");
        teamMembers2.setIsCaptain(false);
        teamMembers2.setIsViceCaptain(true);


        teamMembers.add(teamMembers1);
        teamMembers.add(teamMembers2);

        CricTourRegisterModel currentTeamDetails = new CricTourRegisterModel();
        currentTeamDetails.setTeamId("1235");


        if (updatedTeam.getDist() != null && !updatedTeam.getDist().isEmpty()) {
            currentTeamDetails.setDist(updatedTeam.getDist());
        }
        currentTeamDetails.setTeamMembers(teamMembers);

        updatedTeam.setTeamName(currentTeamDetails.getTeamName());

        List<TeamMembers> updatedTeamMembers = updatedTeam.getTeamMembers();
        if (updatedTeamMembers != null && !updatedTeamMembers.isEmpty()) {
            List<TeamMembers> currentTeamMembers = currentTeamDetails.getTeamMembers();

            // Update name and aadhar for each team member
            for (int i = 0; i < updatedTeamMembers.size(); i++) {
                TeamMembers updatedMember = updatedTeamMembers.get(i);
                TeamMembers currentMember = currentTeamMembers.get(i);

                updatedMember.setName(updatedMember.getName());
                currentMember.setAadhar(updatedMember.getAadhar());
                // Optionally update other fields
                currentMember.setIsCaptain(updatedMember.getIsCaptain());
                currentMember.setIsViceCaptain(updatedMember.getIsViceCaptain());
            }
        }

        // Optionally perform additional operations

        // Save or return updated team details
        // For example, you can save it in a repository or return it directly
        return currentTeamDetails;
    }


}