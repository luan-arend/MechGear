package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.dto.equipment.EquipmentDetailDto;
import br.com.dev.MechGear.dto.equipment.EquipmentDto;
import br.com.dev.MechGear.dto.equipment.EquipmentUpdateDto;
import br.com.dev.MechGear.service.EquipmentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("equipment")
public class EquipmentController {

    @Autowired
    private EquipmentService equipmentService;

    @GetMapping
    public ResponseEntity<Page<EquipmentDetailDto>> getAll(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = equipmentService.getAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EquipmentDetailDto> getById(@PathVariable Long id) {
        var equipment = equipmentService.getById(id);
        return ResponseEntity.ok(new EquipmentDetailDto(equipment));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@Valid @RequestBody EquipmentDto dados, UriComponentsBuilder uriBuilder) {
        var equipment = equipmentService.create(dados);
        var uri = uriBuilder.path("/equipment/{id}").buildAndExpand(equipment.getId()).toUri();
        return ResponseEntity.created(uri).body(new EquipmentDetailDto(equipment));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<EquipmentDetailDto> update(@RequestBody EquipmentUpdateDto dados) {
        var customer = equipmentService.update(dados);
        return ResponseEntity.ok(new EquipmentDetailDto(customer));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        equipmentService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
