package com.erichgamma.api.player.model;

import jakarta.persistence.*;
import lombok.*;

@Entity(name = "players")
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
    private String teamId;
    private String ePlayerName;
    private String nickname;
    private String joinYyyy ;
    private String position ;
    private String backNo ;
    private String nation ;
    private String birthDate ;
    private String solar ;
    private String height ;
    private String weight ;
//    CONSTRAINT player_pk PRIMARY KEY (player_id),
//    CONSTRAINT player_fk FOREIGN KEY (team_id) REFERENCES team(team_id)

}
