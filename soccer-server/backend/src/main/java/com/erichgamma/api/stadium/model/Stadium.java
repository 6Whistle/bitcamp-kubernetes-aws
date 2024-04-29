package com.erichgamma.api.stadium.model;


import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Entity(name = "stadium")
@ToString(exclude = {"id"})
public class Stadium {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String stadium_id;
    private String stadium_name;
    private String hometeam_id;
    private Integer seat_count;
    private String address;
    private String ddd;
    private String tel;
}
