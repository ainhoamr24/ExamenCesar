package com.cipfpmislata.examen2daw1eval.domain.model;

public class Crew {

    private final Long id;
    private final String name;
    private final Integer birthYear;
    private final Integer deathYear;


    public Crew(Long id, String name, Integer birthYear, Integer deathYear) {
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
