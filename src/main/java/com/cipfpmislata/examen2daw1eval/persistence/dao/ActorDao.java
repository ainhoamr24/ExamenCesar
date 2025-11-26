package com.cipfpmislata.examen2daw1eval.persistence.dao;

import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.ActorJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActorDao extends JpaRepository<ActorJpaEntity, Long> {
}
