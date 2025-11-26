package com.cipfpmislata.examen2daw1eval.domain.service;

import com.cipfpmislata.examen2daw1eval.domain.dto.MovieDto;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;

public interface MovieService {
    Page<MovieDto> findAll(Integer page, Integer size);
    MovieDto findById(Long id);
    MovieDto create(MovieDto movieDto);
    void delete(Long id);
}
