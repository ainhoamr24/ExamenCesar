package com.cipfpmislata.examen2daw1eval.controller.webmodel.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record MovieRequest(
        @NotBlank String title,
        @NotNull @Min(1888) Integer year,
        @NotNull @Min(1) Integer runtime,
        String description,
        @NotNull Long directorId,
        List<Long> actorIds
) {
}
