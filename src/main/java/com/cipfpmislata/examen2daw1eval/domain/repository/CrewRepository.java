package com.cipfpmislata.examen2daw1eval.domain.repository;

import com.cipfpmislata.examen2daw1eval.domain.model.Crew;

import java.util.Optional;

public interface CrewRepository {
    Optional<Crew> findActorById(Long id);

    Optional<Crew> findDirectorById(Long id);
}
