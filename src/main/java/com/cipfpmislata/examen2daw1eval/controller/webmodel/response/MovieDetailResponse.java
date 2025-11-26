package com.cipfpmislata.examen2daw1eval.controller.webmodel.response;

import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MovieDetailResponse(
        Long id,
        String title,
        Integer year,
        Integer runtime,
        String description,
        CrewSummaryResponse director,
        List<CrewSummaryResponse> actors
) {
}
