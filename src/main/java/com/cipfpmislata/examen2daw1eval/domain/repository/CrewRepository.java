package com.cipfpmislata.examen2daw1eval.domain.repository;

import com.cipfpmislata.examen2daw1eval.domain.model.Crew;

import java.util.List;

public interface CrewRepository {
    Crew findDirector(Long id);
    Crew findActor(Long id);
    List<Crew> findActors(List<Long> ids);
    List<Crew> findAllActors();
    List<Crew> findAllDirectors();
}
