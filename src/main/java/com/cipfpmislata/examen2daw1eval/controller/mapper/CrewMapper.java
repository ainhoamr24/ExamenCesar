package com.cipfpmislata.examen2daw1eval.controller.mapper;

import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewDetailResponse;
import com.cipfpmislata.examen2daw1eval.controller.webmodel.response.CrewSummaryResponse;
import com.cipfpmislata.examen2daw1eval.domain.model.Crew;

public class CrewMapper {

    public static CrewSummaryResponse toSummaryResponse(Crew crew) {
        return new CrewSummaryResponse(
                crew.getId(),
                crew.getName()
        );
    }

    public static CrewDetailResponse toDetailResponse(Crew crew) {
        return new CrewDetailResponse(
                crew.getId(),
                crew.getName(),
                crew.getBirthYear(),
                crew.getDeathYear()
        );
    }
}
