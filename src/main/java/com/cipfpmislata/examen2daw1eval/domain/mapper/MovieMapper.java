package com.cipfpmislata.examen2daw1eval.domain.mapper;

import com.cipfpmislata.examen2daw1eval.domain.dto.MovieDto;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;

public class MovieMapper {
    private final CrewMapper crewMapper = new CrewMapper();

    public Movie toModel(MovieDto dto) {
        return new Movie(
                dto.id(),
                dto.title(),
                dto.year(),
                dto.runtime(),
                dto.description(),
                crewMapper.toModel(dto.publisher()),
                dto.actors().stream().map(crewMapper::toModel).toList()
        );
    }

    public MovieDto toDto(Movie movie) {
        return new MovieDto(
                movie.getId(),
                movie.getTitle(),
                movie.getYear(),
                movie.getRuntime(),
                movie.getDescription(),
                crewMapper.toDto(movie.getDirector()),
                movie.getActors().stream().map(crewMapper::toDto).toList()
        );
    }
}
