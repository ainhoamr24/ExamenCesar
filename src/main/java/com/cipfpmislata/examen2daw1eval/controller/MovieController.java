package com.cipfpmislata.examen2daw1eval.controller;

import com.cipfpmislata.examen2daw1eval.controller.mapper.MovieMapper;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.request.MovieRequest;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieDetailResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.MovieSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.exception.ValidationException;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.domain.service.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<Map<String, List<MovieSummaryResponse>>> findAll(
            @RequestParam(defaultValue = "1") Integer page,
            @RequestParam(defaultValue = "20") Integer size) {
        Page<Movie> moviePage = movieService.findAll(page, size);
        List<MovieSummaryResponse> responseList = moviePage.data().stream()
                .map(MovieMapper::toSummaryResponse)
                .toList();
        return ResponseEntity.ok(Map.of("data", responseList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDetailResponse> findById(@PathVariable Long id) {
        Movie movie = movieService.findById(id);
        return ResponseEntity.ok(MovieMapper.toDetailResponse(movie));
    }


    @PostMapping
public ResponseEntity<MovieDetailResponse> create(@RequestBody MovieRequest request) {

    Movie movie = MovieMapper.toDomain(request);

    movieService.create(movie);

    Movie created = movieService.findById(movie.getId());

    MovieDetailResponse response = MovieMapper.toDetailResponse(created);

    return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
}




    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        movieService.delete(id);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Void> handleNotFound() {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<Void> handleValidation() {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
}
