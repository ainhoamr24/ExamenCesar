package com.cipfpmislata.examen2daw1eval.domain.dto;

import java.util.List;

public record MovieDto(
        Long id,
        String title,
        Integer year,
        Integer runtime,
        String description,
        CrewDto publisher,
        List<CrewDto> actors
) {
}
