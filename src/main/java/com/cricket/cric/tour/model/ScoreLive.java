package com.cricket.cric.tour.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreLive {
    private String striker;
    private String strikerId;
    private String nonStriker;
    private String nonStrikerId;
    private String bowler;
    private String bowlerId;
}
