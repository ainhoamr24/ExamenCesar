package com.cipfpmislata.examen2daw1eval.persistence.dao;

import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.DirectorJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorDao extends JpaRepository<DirectorJpaEntity, Long> {
}
