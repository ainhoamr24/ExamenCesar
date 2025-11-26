package com.cipfpmislata.examen2daw1eval.persistence.dao.impl;

import com.cipfpmislata.examen2daw1eval.persistence.dao.ActorDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.ActorJpaEntity;
import jakarta.persistence.EntityManager;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly = true)
public class ActorDaoJpa extends SimpleJpaRepository<ActorJpaEntity, Long> implements ActorDao {

    public ActorDaoJpa(EntityManager entityManager) {
        super(ActorJpaEntity.class, entityManager);
    }
}
