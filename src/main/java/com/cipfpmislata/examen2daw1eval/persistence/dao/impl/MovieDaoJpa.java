package com.cipfpmislata.examen2daw1eval.persistence.dao.impl;

import com.cipfpmislata.examen2daw1eval.persistence.dao.MovieDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.MovieJpaEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class MovieDaoJpa extends SimpleJpaRepository<MovieJpaEntity, Long> implements MovieDao {

    public MovieDaoJpa(EntityManager entityManager) {
        super(MovieJpaEntity.class, entityManager);
    }
}
