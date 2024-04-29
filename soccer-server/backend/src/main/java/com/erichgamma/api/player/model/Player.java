package com.erichgamma.api.player.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "player")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
public class Player {
    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
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
//    CONSTRAINT player_pk PRIMARY KEY (player_id),
//    CONSTRAINT player_fk FOREIGN KEY (team_id) REFERENCES team(team_id)

}
