package com.cipfpmislata.examen2daw1eval.controller.mapper;

import com.cipfpmislata.examen2daw1eval.controller.webmodel.request.MovieRequest;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieDetailResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import com.cipfpmislata.examen2daw1eval.domain.dto.MovieDto;

import java.util.List;

public class MovieMapper {
    private final CrewMapper crewMapper = new CrewMapper();

    public MovieDto toDto(MovieRequest request, CrewDto director, List<CrewDto> actors) {
        return new MovieDto(
                null,
                request.title(),
                request.year(),
                request.runtime(),
                request.description(),
                director,
                actors
        );
    }

    public MovieSummaryResponse toSummaryResponse(MovieDto movieDto) {
        return new MovieSummaryResponse(movieDto.id(), movieDto.title());
    }

    public MovieDetailResponse toDetailResponse(MovieDto movieDto) {
        return new MovieDetailResponse(
                movieDto.id(),
                movieDto.title(),
                movieDto.year(),
                movieDto.runtime(),
                movieDto.description(),
                crewMapper.toSummaryResponse(movieDto.publisher()),
                movieDto.actors().stream().map(crewMapper::toSummaryResponse).toList()
        );
    }
}
