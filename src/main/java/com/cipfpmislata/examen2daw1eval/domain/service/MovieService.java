package com.cipfpmislata.examen2daw1eval.domain.service;

import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;

public interface MovieService {
    Page<Movie> findAll(Integer page, Integer size);

    Movie findById(Long id);

    void create(Movie movie);

    void delete(Long id);
}
