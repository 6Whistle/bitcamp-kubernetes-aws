package com.erichgamma.api.schedule.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Log4j2
@Builder
public class ScheduleDto {

    private Long id;
    private String sch_date;
    private String gubun;
    private String hometeam_id;
    private String awayteam_id;
    private int home_score;
    private int away_score;

}
