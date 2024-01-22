package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.PlayerModel;
import org.springframework.stereotype.Service;

@Service
public class PlayerService {


        public String recordRun(PlayerModel playerModel) {

            return  "Run recorded successfully for " + playerModel.getId()+ " team";//"Run recorded successfully";

        }

}


