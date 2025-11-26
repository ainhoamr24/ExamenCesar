package com.cipfpmislata.examen2daw1eval.persistence.repository.impl;

import com.cipfpmislata.examen2daw1eval.domain.repository.MovieRepository;

import com.cipfpmislata.examen2daw1eval.domain.model.Movie;
import com.cipfpmislata.examen2daw1eval.domain.model.Page;
import com.cipfpmislata.examen2daw1eval.persistence.dao.MovieDao;
import com.cipfpmislata.examen2daw1eval.persistence.repository.mapper.MovieMapper;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    private final MovieDao movieDao;

    public MovieRepositoryImpl(MovieDao movieDao) {
        this.movieDao = movieDao;
    }

    @Override
    public Page<Movie> findAll(Integer page, Integer size) {
        Pageable pageable = PageRequest.of(page - 1, size);
        org.springframework.data.domain.Page<com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.MovieJpaEntity> moviePage = movieDao
                .findAll(pageable);
        return new Page<>(
                moviePage.getContent().stream().map(MovieMapper::toDomain).toList(),
                moviePage.getNumber() + 1,
                moviePage.getSize(),
                moviePage.getTotalElements());
    }

    @Override
    public Optional<Movie> findById(Long id) {
        return movieDao.findById(id).map(MovieMapper::toDomain);
    }

    @Override
    public void save(Movie movie) {
        movieDao.save(MovieMapper.toEntity(movie));
    }

    @Override
    public void delete(Long id) {
        movieDao.deleteById(id);
    }
}
