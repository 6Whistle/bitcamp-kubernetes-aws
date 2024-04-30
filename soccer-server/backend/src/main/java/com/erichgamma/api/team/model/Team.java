package com.erichgamma.api.team.model;

import java.util.List;

import com.erichgamma.api.player.model.Player;
import com.erichgamma.api.stadium.model.Stadium;

import jakarta.persistence.Column;
import jakarta.persistence.ConstraintMode;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity(name = "team")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Team {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamId;
    private String regionName;
    private String teamName;
    private String eTeamName;
    private String origYyyy;
    private String zipCode1;
    private String zipCode2;
    private String address;
    private String ddd;
    private String tel;
    private String fax;
    private String homepage;
    private String owner;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id", nullable = true, referencedColumnName = "stadiumId", foreignKey = @ForeignKey(value = ConstraintMode.NO_CONSTRAINT))
    private Stadium stadiumId;

    @OneToMany(mappedBy = "teamId", fetch = FetchType.LAZY)
    private List<Player> players;
}
