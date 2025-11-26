package com.cipfpmislata.examen2daw1eval.controller.mapper;

import com.cipfpmislata.examen2daw1eval.controller.webmodel.request.MovieRequest;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewSummaryResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieDetailResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;

import java.util.List;

public class MovieMapper {

    public static Movie toDomain(MovieRequest request) {
        if (request == null)
            return null;
        Crew director = request.directorId() != null ? new Crew(request.directorId(), null, null, null) : null;
        List<Crew> actors = request.actorIds() != null ? request.actorIds().stream()
                .map(id -> new Crew(id, null, null, null))
                .toList() : List.of();
        return new Movie(null, request.title(), request.year(), request.runtime(), request.description(), director,
                actors);
    }

    public static MovieSummaryResponse toSummaryResponse(Movie movie) {
        return new MovieSummaryResponse(movie.getId(), movie.getTitle());
    }

    public static MovieDetailResponse toDetailResponse(Movie movie) {
        CrewSummaryResponse director = movie.getDirector() != null
                ? new CrewSummaryResponse(movie.getDirector().getId(), movie.getDirector().getName())
                : null;
        List<CrewSummaryResponse> actors = movie.getActors() != null ? movie.getActors().stream()
                .map(a -> new CrewSummaryResponse(a.getId(), a.getName()))
                .toList() : List.of();
        return new MovieDetailResponse(
                movie.getId(),
                movie.getTitle(),
                movie.getYear(),
                movie.getRuntime(),
                movie.getDescription(),
                director,
                actors);
    }
}
