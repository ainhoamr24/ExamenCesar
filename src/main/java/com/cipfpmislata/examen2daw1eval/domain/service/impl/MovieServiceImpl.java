package com.cipfpmislata.examen2daw1eval.domain.service.impl;

import com.cipfpmislata.examen2daw1eval.domain.dto.MovieDto;
import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.mapper.MovieMapper;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.domain.repository.MovieRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.MovieService;
import com.cipfpmislata.examen2daw1eval.domain.validation.DtoValidator;
import org.springframework.stereotype.Service;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper = new MovieMapper();

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Page<MovieDto> findAll(Integer page, Integer size) {
        int pageNumber = page == null ? 1 : page;
        int pageSize = size == null ? 20 : size;
        Page<Movie> movies = movieRepository.findAll(pageNumber, pageSize);
        return new Page<>(
                movies.data().stream().map(movieMapper::toDto).toList(),
                movies.pageNumber(),
                movies.pageSize(),
                movies.totalElements()
        );
    }

    @Override
    public MovieDto findById(Long id) {
        return movieRepository.findById(id)
                .map(movieMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    @Override
    public MovieDto create(MovieDto movieDto) {
        DtoValidator.validate(movieDto);
        Movie movie = movieMapper.toModel(movieDto);
        movie = movieRepository.save(movie);
        return movieMapper.toDto(movie);
    }

    @Override
    public void delete(Long id) {
        movieRepository.deleteById(id);
    }
}
