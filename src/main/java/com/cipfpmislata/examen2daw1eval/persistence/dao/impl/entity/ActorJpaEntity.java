package com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actors")
public class ActorJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(name="birth_year")
    private Integer birthYear;
    @Column(name="death_year")
    private Integer deathYear;


   public ActorJpaEntity(){

   }

    public ActorJpaEntity(Long id, String name, Integer birthYear, Integer deathYear) {
        this.id = id;
        this.name = name;
        this.birthYear = birthYear;
        this.deathYear = deathYear;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getBirthYear() {
        return birthYear;
    }

    public Integer getDeathYear() {
        return deathYear;
    }
}
