package com.cipfpmislata.examen2daw1eval.domain.model;

import java.util.List;

public class Movie {

    private final Long id;
    private final String title;
    private final Integer year;
    private final Integer runtime;
    private final String description;
    private final Crew director;
    private final List<Crew> actors;


    public Movie(Long id, String title, Integer year, Integer runtime, String description, Crew director, List<Crew> actors) {
        this.id = id;
        this.title = title;
        this.year = year;
        this.runtime = runtime;
        this.description = description;
        this.director = director;
        this.actors = actors;
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

    public Integer getRuntime() {
        return runtime;
    }

    public String getDescription() {
        return description;
    }

    public Crew getDirector() {
        return director;
    }

    public List<Crew> getActors() {
        return actors;
    }
}
