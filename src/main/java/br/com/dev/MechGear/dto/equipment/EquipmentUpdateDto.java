package br.com.dev.MechGear.dto.equipment;

import br.com.dev.MechGear.domain.equipment.EquipmentType;
import jakarta.validation.constraints.NotNull;

public record EquipmentUpdateDto(
        @NotNull
        Long id,
        EquipmentType type,
        String brand,
        String model,
        Short year,
        String notes
) {

}
