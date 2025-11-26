package com.cipfpmislata.examen2daw1eval.persistence.repository.impl;

import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.domain.repository.MovieRepository;
import com.cipfpmislata.examen2daw1eval.persistence.dao.ActorDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.DirectorDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.MovieDao;
import com.cipfpmislata.examen2daw1eval.persistence.repository.mapper.MovieMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDao movieDao;
    private final DirectorDao directorDao;
    private final ActorDao actorDao;
    private final MovieMapper movieMapper;

    public MovieRepositoryImpl(MovieDao movieDao, DirectorDao directorDao, ActorDao actorDao, MovieMapper movieMapper) {
        this.movieDao = movieDao;
        this.directorDao = directorDao;
        this.actorDao = actorDao;
        this.movieMapper = movieMapper;
    }

    @Override
    public Page<Movie> findAll(int page, int size) {
        org.springframework.data.domain.Page<com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.MovieJpaEntity> result = movieDao.findAll(PageRequest.of(page - 1, size));
        return new Page<>(result.getContent().stream().map(movieMapper::toDomain).toList(), page, size, result.getTotalElements());
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieDao.findById(id).map(movieMapper::toDomain);
    }

    @Override
    public Movie save(Movie movie) {
        var director = directorDao.findById(movie.getDirector().getId())
                .orElseThrow(() -> new ResourceNotFoundException("Director not found"));
        var actors = actorDao.findAllById(movie.getActors().stream().map(a -> a.getId()).toList());
        var entity = movieMapper.toEntity(movie, director, actors);
        return movieMapper.toDomain(movieDao.save(entity));
    }

    @Override
    public void deleteById(Long id) {
        if (!movieDao.existsById(id)) {
            throw new ResourceNotFoundException("Movie not found");
        }
        movieDao.deleteById(id);
    }
}
