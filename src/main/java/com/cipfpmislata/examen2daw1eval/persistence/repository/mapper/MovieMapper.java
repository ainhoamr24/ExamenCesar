package com.cipfpmislata.examen2daw1eval.persistence.repository.mapper;

import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.MovieJpaEntity;

public class MovieMapper {

    public static Movie toDomain(MovieJpaEntity entity) {
        if (entity == null)
            return null;
        return new Movie(
                entity.getId(),
                entity.getTitle(),
                entity.getYear(),
                entity.getRuntime(),
                entity.getDescription(),
                CrewMapper.toDomain(entity.getDirector()),
                entity.getActors().stream().map(CrewMapper::toDomain).toList());
    }

    public static MovieJpaEntity toEntity(Movie movie) {
        if (movie == null)
            return null;
        MovieJpaEntity entity = new MovieJpaEntity();
        entity.setId(movie.getId());
        entity.setTitle(movie.getTitle());
        entity.setYear(movie.getYear());
        entity.setRuntime(movie.getRuntime());
        entity.setDescription(movie.getDescription());
        entity.setDirector(CrewMapper.toDirectorEntity(movie.getDirector()));
        entity.setActors(movie.getActors().stream().map(CrewMapper::toActorEntity).toList());
        return entity;
    }
}
