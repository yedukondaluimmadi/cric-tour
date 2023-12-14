package com.cricket.cric.tour.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameStartModel {
    private int id;
    private String team1;
    private String team2;
    private int overs;
    private boolean isTeam1Batting;
    private boolean isTeam2Batting;

    // getters and setters
}
