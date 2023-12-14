package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.TeamsDetails;
import Cricket.Cric.tour.model.TeamsLiveModel;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LiveTeamsService {

    public TeamsLiveModel getTeamsLiveModel() {
        TeamsDetails teamsDetails = new TeamsDetails("Thiru", "1", "Sr Nagar", "1999-05-23");
        return new TeamsLiveModel("1999-05-23", "KPHP", teamsDetails);
    }

    }







