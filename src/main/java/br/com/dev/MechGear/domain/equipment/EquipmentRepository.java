package br.com.dev.MechGear.domain.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<EquipmentImpl, Long> {
}
