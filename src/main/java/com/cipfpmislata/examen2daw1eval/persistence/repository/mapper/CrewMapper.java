package com.cipfpmislata.examen2daw1eval.persistence.repository.mapper;

import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.ActorJpaEntity;
import com.cipfpmislata.examen2daw1eval.persistence.dao.impl.entity.DirectorJpaEntity;

public class CrewMapper {

    public static Crew toDomain(ActorJpaEntity entity) {
        if (entity == null)
            return null;
        return new Crew(entity.getId(), entity.getName(), entity.getBirthYear(), entity.getDeathYear());
    }

    public static Crew toDomain(DirectorJpaEntity entity) {
        if (entity == null)
            return null;
        return new Crew(entity.getId(), entity.getName(), entity.getBirthYear(), entity.getDeathYear());
    }

    public static ActorJpaEntity toActorEntity(Crew crew) {
        if (crew == null)
            return null;
        ActorJpaEntity entity = new ActorJpaEntity();
        entity.setId(crew.getId());
        entity.setName(crew.getName());
        entity.setBirthYear(crew.getBirthYear());
        entity.setDeathYear(crew.getDeathYear());
        return entity;
    }

    public static DirectorJpaEntity toDirectorEntity(Crew crew) {
        if (crew == null)
            return null;
        DirectorJpaEntity entity = new DirectorJpaEntity();
        entity.setId(crew.getId());
        entity.setName(crew.getName());
        entity.setBirthYear(crew.getBirthYear());
        entity.setDeathYear(crew.getDeathYear());
        return entity;
    }
}
