package com.cipfpmislata.examen2daw1eval.persistence.dao;

import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.MovieJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieDao extends JpaRepository<MovieJpaEntity, Long> {
}
