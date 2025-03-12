package br.com.dev.MechGear.dto.equipment;

import br.com.dev.MechGear.domain.equipment.EquipmentType;
import jakarta.validation.constraints.NotBlank;

public record EquipmentDto(
        EquipmentType type,
        @NotBlank(message = "Marca é obrigatória.")
        String brand,
        @NotBlank(message = "Modelo é obrigatório.")
        String model,
        Short year,
        String notes
) {
}
