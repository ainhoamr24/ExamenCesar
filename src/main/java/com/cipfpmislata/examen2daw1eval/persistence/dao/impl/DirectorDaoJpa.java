package com.cipfpmislata.examen2daw1eval.persistence.dao.impl;

import com.cipfpmislata.examen2daw1eval.persistence.dao.DirectorDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.DirectorJpaEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class DirectorDaoJpa extends SimpleJpaRepository<DirectorJpaEntity, Long> implements DirectorDao {

    public DirectorDaoJpa(EntityManager entityManager) {
        super(DirectorJpaEntity.class, entityManager);
    }
}
