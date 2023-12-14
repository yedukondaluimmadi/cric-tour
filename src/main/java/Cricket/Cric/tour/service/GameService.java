package Cricket.Cric.tour.service;


import Cricket.Cric.tour.model.GameStartModel;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    public String startGame(GameStartModel gameStartModel) {
        if (gameStartModel.getIsTeam1Batting()) {
            return gameStartModel.getTeam1() + " team Batting first";
        } else {
            return gameStartModel.getTeam2() + " team Batting first";
        }
    }
}




