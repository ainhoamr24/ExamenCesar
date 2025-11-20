package com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name= "movies")
public class MovieJpaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private Integer year;
    private String image;
    private Integer runtime;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "director_id")
    private DirectorJpaEntity director;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ActorMovieJpaEntity> actorMovie = new ArrayList<>();

    public MovieJpaEntity() {
    }

    public MovieJpaEntity(Long id, String title, Integer year, String image, Integer runtime, String description, DirectorJpaEntity director, List<ActorJpaEntity> actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.image = image;
        this.runtime = runtime;
        this.description = description;
        this.director = director;
        setActors(actors);
    }


    public List<ActorJpaEntity> getActors() {
        return actorMovie.stream().map(ActorMovieJpaEntity::getActor).collect(Collectors.toList());
    }

    public void setActors(List<ActorJpaEntity> actors) {
        this.actorMovie.clear();
        for (ActorJpaEntity actor : actors) {
            ActorMovieJpaEntity actorMovie = new ActorMovieJpaEntity(this, actor);
            this.actorMovie.add(actorMovie);
        }
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getImage() {
        return image;
    }

    public Integer getRuntime() {
        return runtime;
    }

    public String getDescription() {
        return description;
    }

    public DirectorJpaEntity getDirector() {
        return director;
    }

    public List<ActorMovieJpaEntity> getActorMovie() {
        return actorMovie;
    }
}
