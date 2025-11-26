package com.cipfpmislata.examen2daw1eval.domain.mapper;

import com.cipfpmislata.examen2daw1eval.domain.dto.MovieDto;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;

import java.util.List;

public class MovieMapper {

    public static Movie toDomain(MovieDto dto) {
        if (dto == null)
            return null;
        return new Movie(
                dto.id(),
                dto.title(),
                dto.year(),
                dto.runtime(),
                dto.description(),
                CrewMapper.toDomain(dto.publisher()),
                dto.actors() != null ? dto.actors().stream().map(CrewMapper::toDomain).toList() : List.of());
    }

    public static MovieDto toDto(Movie movie) {
        if (movie == null)
            return null;
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getYear(),
                movie.getRuntime(),
                movie.getDescription(),
                CrewMapper.toDto(movie.getDirector()),
                movie.getActors() != null ? movie.getActors().stream().map(CrewMapper::toDto).toList() : List.of());
    }
}
