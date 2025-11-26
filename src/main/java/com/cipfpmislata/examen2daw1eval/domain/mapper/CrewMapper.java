package com.cipfpmislata.examen2daw1eval.domain.mapper;

import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;

public class CrewMapper {
    public CrewDto toDto(Crew crew) {
        return new CrewDto(crew.getId(), crew.getName(), crew.getBirthYear(), crew.getDeathYear());
    }

    public Crew toModel(CrewDto dto) {
        return new Crew(dto.id(), dto.name(), dto.birthYear(), dto.deathYear());
    }
}
