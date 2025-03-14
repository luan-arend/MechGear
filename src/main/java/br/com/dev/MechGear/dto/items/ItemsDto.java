package br.com.dev.MechGear.dto.items;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ItemsDto(
        @NotBlank(message = "Nome do item é obrigatório.")
        String name,
        String description,
        @NotBlank
        String code,
        String category,
        @NotNull(message = "Quantidade do item é obrigatória.")
        Integer quantity,
        Integer min_quantity,
        @NotNull(message = "Preço unitário do item é obrigatório.")
        Double unit_price,
        Double cost_price,
        String supplier,
        String location
) {}