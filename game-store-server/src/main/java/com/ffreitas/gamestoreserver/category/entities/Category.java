package com.ffreitas.gamestoreserver.category.entities;

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
@Table(name = "category")
public class Category extends BaseEntity {

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "description", length = 500)
    private String description;

    @ManyToMany(mappedBy = "categories")
    private List<Game> games;
}

/*
@NamedQuery(
        name = "Category.findByName",
        query = """
                SELECT c
                FROM Category c
                WHERE lower(c.name) like lower(:catName)
                ORDER BY c.name ASC
                """
)
//@NamedQueries()
//@NamedNativeQuery()

 */