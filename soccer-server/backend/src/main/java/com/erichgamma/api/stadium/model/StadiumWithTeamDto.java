package com.erichgamma.api.stadium.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class StadiumWithTeamDto {
    //stadium
    private String stadiumName;

    // team
    private String regionName;

}
