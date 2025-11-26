package com.cipfpmislata.examen2daw1eval.controller.mapper;

import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewDetailResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.dto.CrewDto;

public class CrewMapper {
    public CrewSummaryResponse toSummaryResponse(CrewDto crewDto) {
        return new CrewSummaryResponse(crewDto.id(), crewDto.name());
    }

    public CrewDetailResponse toDetailResponse(CrewDto crewDto) {
        return new CrewDetailResponse(crewDto.id(), crewDto.name(), crewDto.birthYear(), crewDto.deathYear());
    }
}
