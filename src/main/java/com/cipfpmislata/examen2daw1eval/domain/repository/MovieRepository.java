package com.cipfpmislata.examen2daw1eval.domain.repository;

import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;

import java.util.Optional;

public interface MovieRepository {
    Page<Movie> findAll(int page, int size);
    Optional<Movie> findById(Long id);
    Movie save(Movie movie);
    void deleteById(Long id);
}
