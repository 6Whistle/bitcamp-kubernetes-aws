package com.erichgamma.api.schedule.model;


import com.erichgamma.api.stadium.model.Stadium;

import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString(exclude = "id")
@Setter
@Entity
public class Schedule {

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String scheDate;
    private String gubun;
    private String hometeamId;
    private String awayteamId;
    private Integer homeScore;
    private Integer awayScore;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", nullable = true)
    private Stadium stadiumId;
}
