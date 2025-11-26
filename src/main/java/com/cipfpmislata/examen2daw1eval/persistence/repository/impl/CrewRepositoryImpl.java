package com.cipfpmislata.examen2daw1eval.persistence.repository.impl;

import com.cipfpmislata.examen2daw1eval.domain.exception.ResourceNotFoundException;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.persistence.dao.ActorDao;
import com.cipfpmislata.examen2daw1eval.persistence.dao.DirectorDao;
import com.cipfpmislata.examen2daw1eval.persistence.repository.mapper.CrewMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CrewRepositoryImpl implements CrewRepository {

    private final ActorDao actorDao;
    private final DirectorDao directorDao;
    private final CrewMapper crewMapper;

    public CrewRepositoryImpl(ActorDao actorDao, DirectorDao directorDao, CrewMapper crewMapper) {
        this.actorDao = actorDao;
        this.directorDao = directorDao;
        this.crewMapper = crewMapper;
    }

    @Override
    public Crew findDirector(Long id) {
        return directorDao.findById(id)
                .map(crewMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("Director not found"));
    }

    @Override
    public Crew findActor(Long id) {
        return actorDao.findById(id)
                .map(crewMapper::toDomain)
                .orElseThrow(() -> new ResourceNotFoundException("Actor not found"));
    }

    @Override
    public List<Crew> findActors(List<Long> ids) {
        return actorDao.findAllById(ids).stream().map(crewMapper::toDomain).toList();
    }

    @Override
    public List<Crew> findAllActors() {
        return actorDao.findAll().stream().map(crewMapper::toDomain).toList();
    }

    @Override
    public List<Crew> findAllDirectors() {
        return directorDao.findAll().stream().map(crewMapper::toDomain).toList();
    }
}
