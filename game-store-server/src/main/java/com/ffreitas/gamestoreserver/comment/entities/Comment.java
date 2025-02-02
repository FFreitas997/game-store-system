package com.ffreitas.gamestoreserver.comment.entities;

import com.ffreitas.gamestoreserver.common.BaseEntity;
import com.ffreitas.gamestoreserver.game.entities.Game;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@Entity
@Table(name = "comment")
public class Comment extends BaseEntity {

    @Column(name = "content", nullable = false, length = 1000)
    private String content;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

}