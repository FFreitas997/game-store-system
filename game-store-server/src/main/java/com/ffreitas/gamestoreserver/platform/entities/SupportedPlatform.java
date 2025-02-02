package com.ffreitas.gamestoreserver.platform.entities;

import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.game.entities.Game;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "supported_platform")
public class SupportedPlatform extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @Column(name = "website")
    private String website;

    @Column(name = "logo")
    private String logo;

    @ManyToMany(mappedBy = "supportedPlatforms")
    private List<Game> games;
}
