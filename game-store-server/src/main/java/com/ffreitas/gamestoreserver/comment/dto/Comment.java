package com.ffreitas.gamestoreserver.comment.dto;

import com.ffreitas.gamestoreserver.game.dto.Game;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "comment")
@EntityListeners(AuditingEntityListener.class)
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;


    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne
    @JoinColumn(name = "game_id", nullable = false)
    private Game game;

}