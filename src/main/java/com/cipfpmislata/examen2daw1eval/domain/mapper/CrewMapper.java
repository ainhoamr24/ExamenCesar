package com.cipfpmislata.examen2daw1eval.domain.mapper;

import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;

public class CrewMapper {

    public static Crew toDomain(CrewDto dto) {
        if (dto == null)
            return null;
        return new Crew(
                dto.id(),
                dto.name(),
                dto.birthYear(),
                dto.deathYear());
    }

    public static CrewDto toDto(Crew crew) {
        if (crew == null)
            return null;
        return new CrewDto(
                crew.getId(),
                crew.getName(),
                crew.getBirthYear(),
                crew.getDeathYear());
    }
}
