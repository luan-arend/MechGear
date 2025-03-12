package br.com.dev.MechGear.domain.equipment;

import br.com.dev.MechGear.dto.equipment.EquipmentDto;
import br.com.dev.MechGear.dto.equipment.EquipmentUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "equipment")
@Entity(name = "Equipment")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class EquipmentImpl implements Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private EquipmentType type;

    private String brand;
    private String model;
    private Short year;
    private String notes;
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

    public EquipmentImpl(EquipmentDto dados) {
        this.type = dados.type();
        this.brand = dados.brand();
        this.model = dados.model();
        this.year = dados.year();
        this.notes = dados.notes();
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
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
        this.updated_at = LocalDateTime.now();
    }
}
