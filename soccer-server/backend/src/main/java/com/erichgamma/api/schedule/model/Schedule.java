package com.erichgamma.api.schedule.model;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
@Setter

public class Schedule {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String scheDate;
    private String guBun;
    private String homeTeamId;
    private String awayTeamId;
    private int homeScore;
    private int awayScore;


}
