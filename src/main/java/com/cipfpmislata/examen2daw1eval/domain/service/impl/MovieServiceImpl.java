package com.cipfpmislata.examen2daw1eval.domain.service.impl;

import com.cipfpmislata.examen2daw1eval.domain.service.MovieService;

import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.exception.ValidationException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.domain.repository.MovieRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.MovieService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;
    private final CrewRepository crewRepository;

    public MovieServiceImpl(MovieRepository movieRepository, CrewRepository crewRepository) {
        this.movieRepository = movieRepository;
        this.crewRepository = crewRepository;
    }

    @Override
    public Page<Movie> findAll(Integer page, Integer size) {
        return movieRepository.findAll(page, size);
    }

    @Override
    public Movie findById(Long id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Movie not found"));
    }

    @Override
    public void create(Movie movie) {
        validate(movie);
        movieRepository.save(movie);
    }

    @Override
    public void delete(Long id) {
        if (movieRepository.findById(id).isEmpty()) {
            throw new ResourceNotFoundException("Movie not found");
        }
        movieRepository.delete(id);
    }

    private void validate(Movie movie) {
        if (movie.getTitle() == null || movie.getTitle().isBlank()) {
            throw new ValidationException("Title cannot be empty");
        }
        if (movie.getYear() == null) {
            throw new ValidationException("Year cannot be null");
        }
        if (movie.getYear() < 1888) {
            throw new ValidationException("Year must be >= 1888");
        }
        if (movie.getRuntime() == null || movie.getRuntime() <= 0) {
            throw new ValidationException("Runtime must be > 0");
        }
        if (movie.getDirector() == null) {
            throw new ValidationException("Director cannot be null");
        }

        // Validate Director
        Crew director = crewRepository.findDirectorById(movie.getDirector().getId())
                .orElseThrow(() -> new ValidationException("Director not found"));

        if (director.getBirthYear() > movie.getYear()) {
            throw new ValidationException("Director birth year cannot be after movie year");
        }

        // Validate Actors
        if (movie.getActors() != null) {
            for (Crew actorRef : movie.getActors()) {
                Crew actor = crewRepository.findActorById(actorRef.getId())
                        .orElseThrow(() -> new ValidationException("Actor not found with id: " + actorRef.getId()));

                if (actor.getBirthYear() > movie.getYear()) {
                    throw new ValidationException("Actor birth year cannot be after movie year");
                }
            }
        }
    }
}
