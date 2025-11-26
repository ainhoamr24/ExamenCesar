package com.cipfpmislata.examen2daw1eval.persistence.repository.impl;

import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;

import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.persistence.dao.ActorDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.DirectorDao;
import com.cipfpmislata.examen2daw1eval.persistence.repository.mapper.CrewMapper;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class CrewRepositoryImpl implements CrewRepository {

    private final ActorDao actorDao;
    private final DirectorDao directorDao;

    public CrewRepositoryImpl(ActorDao actorDao, DirectorDao directorDao) {
        this.actorDao = actorDao;
        this.directorDao = directorDao;
    }

    @Override
    public Optional<Crew> findActorById(Long id) {
        return actorDao.findById(id).map(CrewMapper::toDomain);
    }

    @Override
    public Optional<Crew> findDirectorById(Long id) {
        return directorDao.findById(id).map(CrewMapper::toDomain);
    }
}
