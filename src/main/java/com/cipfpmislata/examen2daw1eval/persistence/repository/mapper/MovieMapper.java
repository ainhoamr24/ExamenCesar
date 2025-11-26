package com.cipfpmislata.examen2daw1eval.persistence.repository.mapper;

import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.ActorJpaEntity;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.DirectorJpaEntity;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.MovieJpaEntity;

import java.util.List;

public class MovieMapper {
    private final CrewMapper crewMapper = new CrewMapper();

    public Movie toDomain(MovieJpaEntity entity) {
        return new Movie(
                entity.getId(),
                entity.getTitle(),
                entity.getYear(),
                entity.getRuntime(),
                entity.getDescription(),
                crewMapper.toDomain(entity.getDirector()),
                entity.getActors().stream().map(crewMapper::toDomain).toList()
        );
    }

    public MovieJpaEntity toEntity(Movie movie, DirectorJpaEntity director, List<ActorJpaEntity> actors) {
        return new MovieJpaEntity(
                movie.getId(),
                movie.getTitle(),
                movie.getYear(),
                null,
                movie.getRuntime(),
                movie.getDescription(),
                director,
                actors
        );
    }
}
