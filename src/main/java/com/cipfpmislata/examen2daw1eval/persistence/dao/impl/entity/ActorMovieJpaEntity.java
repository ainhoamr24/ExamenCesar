package com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "actors_movies")
public class ActorMovieJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "movie_id")
    private MovieJpaEntity movie;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "actor_id")
    private ActorJpaEntity actor;

    public ActorMovieJpaEntity() {

    }


    public ActorMovieJpaEntity(MovieJpaEntity movie, ActorJpaEntity actor) {
        this.movie = movie;
        this.actor = actor;
    }

    public Long getId() {
        return id;
    }

    public MovieJpaEntity getMovie() {
        return movie;
    }

    public ActorJpaEntity getActor() {
        return actor;
    }
}
