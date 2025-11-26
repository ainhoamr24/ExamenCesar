package com.cipfpmislata.examen2daw1eval.domain.service.impl;

import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import com.cipfpmislata.examen2daw1eval.domain.mapper.CrewMapper;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.ActorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {

    private final CrewRepository crewRepository;
    private final CrewMapper crewMapper = new CrewMapper();

    public ActorServiceImpl(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public List<CrewDto> findAll() {
        return crewRepository.findAllActors().stream().map(crewMapper::toDto).toList();
    }
}
