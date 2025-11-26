package com.cipfpmislata.examen2daw1eval.controller;

import com.cipfpmislata.examen2daw1eval.controller.mapper.MovieMapper;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.request.MovieRequest;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieDetailResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import com.cipfpmislata.examen2daw1eval.domain.dto.MovieDto;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;
    private final MovieMapper movieMapper = new MovieMapper();

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public Page<MovieSummaryResponse> findAll(@RequestParam(value = "page", required = false) Integer page,
                                              @RequestParam(value = "size", required = false) Integer size) {
        Page<MovieDto> movies = movieService.findAll(page, size);
        List<MovieSummaryResponse> responses = movies.data().stream().map(movieMapper::toSummaryResponse).toList();
        return new Page<>(responses, movies.pageNumber(), movies.pageSize(), movies.totalElements());
    }

    @GetMapping("/{id}")
    public MovieDetailResponse findById(@PathVariable Long id) {
        return movieMapper.toDetailResponse(movieService.findById(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MovieDetailResponse create(@RequestBody MovieRequest request) {
        MovieDto dto = movieService.create(new MovieDto(
                null,
                request.title(),
                request.year(),
                request.runtime(),
                request.description(),
                new CrewDto(request.directorId(), null, null, null),
                request.actorIds() == null ? List.of() : request.actorIds().stream().map(id -> new CrewDto(id, null, null, null)).toList()
        ));
        return movieMapper.toDetailResponse(dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        movieService.delete(id);
    }
}
