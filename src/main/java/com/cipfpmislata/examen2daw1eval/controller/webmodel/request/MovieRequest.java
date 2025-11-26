package com.cipfpmislata.examen2daw1eval.controller.webmodel.request;

import java.util.List;

public record MovieRequest(
        String title,
        Integer year,
        Integer runtime,
        String description,
        Long directorId,
        List<Long> actorIds) {
}
