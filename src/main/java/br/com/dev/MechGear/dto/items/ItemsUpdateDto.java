package br.com.dev.MechGear.dto.items;

import jakarta.validation.constraints.NotNull;

public record ItemsUpdateDto(
        @NotNull
        Long id,
        String name,
        String description,
        String code,
        String category,
        Integer quantity,
        Integer min_quantity,
        Double unit_price,
        Double cost_price,
        String supplier,
        String location
) {
}