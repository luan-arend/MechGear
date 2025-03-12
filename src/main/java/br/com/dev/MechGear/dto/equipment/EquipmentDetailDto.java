package br.com.dev.MechGear.dto.equipment;

import br.com.dev.MechGear.domain.equipment.EquipmentImpl;
import br.com.dev.MechGear.domain.equipment.EquipmentType;

public record EquipmentDetailDto(
        Long id,
        EquipmentType type,
        String brand,
        String model,
        Short year,
        String notes
) {
    public EquipmentDetailDto(EquipmentImpl equipment) {
        this(equipment.getId(), equipment.getType(), equipment.getBrand(), equipment.getModel(), equipment.getYear(), equipment.getNotes());
    }
}
