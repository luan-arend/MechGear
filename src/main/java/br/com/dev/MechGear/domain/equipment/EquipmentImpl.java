package br.com.dev.MechGear.domain.equipment;

import br.com.dev.MechGear.domain.AbstractBaseEntity;
import br.com.dev.MechGear.dto.equipment.EquipmentDto;
import br.com.dev.MechGear.dto.equipment.EquipmentUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "equipment")
@Entity(name = "Equipment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class EquipmentImpl extends AbstractBaseEntity implements Equipment {

    @Enumerated(EnumType.STRING)
    private EquipmentType type;
    private String brand;
    private String model;
    private Short year;
    private String notes;

    public EquipmentImpl(EquipmentDto dados) {
        this.type = dados.type();
        this.brand = dados.brand();
        this.model = dados.model();
        this.year = dados.year();
        this.notes = dados.notes();
    }

    @Override
    public void update(EquipmentUpdateDto dados) {
        if (dados.type() != null) {
            this.type = dados.type();
        }
        if (dados.brand() != null) {
            this.brand = dados.brand();
        }
        if (dados.model() != null) {
            this.model = dados.model();
        }
        if (dados.year() != null) {
            this.year = dados.year();
        }
        if (dados.notes() != null) {
            this.notes = dados.notes();
        }
    }
}
