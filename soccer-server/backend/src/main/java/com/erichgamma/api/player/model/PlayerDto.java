package com.erichgamma.api.player.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Log4j2
public class PlayerDto {
    private Long id;
    private String name;
    private String team_id;
    private String e_player_name;
    private String nickname;
    private String join_yyyy ;
    private String POSITION ;
    private String back_no ;
    private String nation ;
    private String birth_date ;
    private String solar ;
    private String height ;
    private String weight ;
}
