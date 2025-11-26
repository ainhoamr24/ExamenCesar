package com.cipfpmislata.examen2daw1eval.persistence.repository.mapper;

import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.ActorJpaEntity;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.DirectorJpaEntity;

public class CrewMapper {
    public Crew toDomain(ActorJpaEntity entity) {
        return new Crew(entity.getId(), entity.getName(), entity.getBirthYear(), entity.getDeathYear());
    }

    public Crew toDomain(DirectorJpaEntity entity) {
        return new Crew(entity.getId(), entity.getName(), entity.getBirthYear(), entity.getDeathYear());
    }
}
