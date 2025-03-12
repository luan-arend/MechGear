package br.com.dev.MechGear.service;

import br.com.dev.MechGear.domain.equipment.EquipmentImpl;
import br.com.dev.MechGear.domain.equipment.EquipmentRepository;
import br.com.dev.MechGear.dto.equipment.EquipmentDto;
import br.com.dev.MechGear.dto.equipment.EquipmentDetailDto;
import br.com.dev.MechGear.dto.equipment.EquipmentUpdateDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class EquipmentService {

    @Autowired
    private EquipmentRepository repository;

    public Page<EquipmentDetailDto> getAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(EquipmentDetailDto::new);
    }

    public EquipmentImpl getById(Long id) {
        return repository.getReferenceById(id);
    }

    public EquipmentImpl create(EquipmentDto dados) {
        var equipment = new EquipmentImpl(dados);
        repository.save(equipment);
        return equipment;
    }

    public EquipmentImpl update(EquipmentUpdateDto dados) {
        var equipment = getById(dados.id());
        equipment.update(dados);
        return equipment;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
