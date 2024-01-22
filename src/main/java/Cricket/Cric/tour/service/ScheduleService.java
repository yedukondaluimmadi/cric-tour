package Cricket.Cric.tour.service;

import Cricket.Cric.tour.model.ScheduleTeamModel;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Service;

@Service
public class ScheduleService {
    Map<Integer, ScheduleTeamModel> scheduleTeamModelMap = new HashMap<>();

    public ScheduleService() {
    }

    public ScheduleTeamModel scheduleATeam(ScheduleTeamModel team) {
        this.scheduleTeamModelMap.put(team.getGameId(), team);
        return team;
    }

    public List<ScheduleTeamModel> getSchedules() {
        return new ArrayList<>(this.scheduleTeamModelMap.values());
    }
    public ScheduleTeamModel getScheduleByGameId(int gameId) {
        return this.scheduleTeamModelMap.isEmpty() ? null : (ScheduleTeamModel)this.scheduleTeamModelMap.get(gameId);
    }
}
