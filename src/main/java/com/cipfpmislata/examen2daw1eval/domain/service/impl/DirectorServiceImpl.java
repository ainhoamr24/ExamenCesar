package com.cipfpmislata.examen2daw1eval.domain.service.impl;

import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import com.cipfpmislata.examen2daw1eval.domain.mapper.CrewMapper;
import com.cipfpmislata.examen2daw1eval.domain.repository.CrewRepository;
import com.cipfpmislata.examen2daw1eval.domain.service.DirectorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {

    private final CrewRepository crewRepository;
    private final CrewMapper crewMapper = new CrewMapper();

    public DirectorServiceImpl(CrewRepository crewRepository) {
        this.crewRepository = crewRepository;
    }

    @Override
    public List<CrewDto> findAll() {
        return crewRepository.findAllDirectors().stream().map(crewMapper::toDto).toList();
    }
}
