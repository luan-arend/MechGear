package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.dto.equipment.EquipmentDetailDto;
import br.com.dev.MechGear.dto.equipment.EquipmentDto;
import br.com.dev.MechGear.dto.equipment.EquipmentUpdateDto;
import br.com.dev.MechGear.dto.items.ItemsDetailDto;
import br.com.dev.MechGear.dto.items.ItemsDto;
import br.com.dev.MechGear.dto.items.ItemsUpdateDto;
import br.com.dev.MechGear.service.ItemsService;
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
@RequestMapping("/items")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;

    @GetMapping
    public ResponseEntity<Page<ItemsDetailDto>> getAll(@PageableDefault(size = 10, sort = {"id"}) Pageable paginacao) {
        var page = itemsService.getAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemsDetailDto> getById(@PathVariable Long id) {
        var equipment = itemsService.getById(id);
        return ResponseEntity.ok(new ItemsDetailDto(equipment));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@Valid @RequestBody ItemsDto dados, UriComponentsBuilder uriBuilder) {
        var item = itemsService.create(dados);
        var uri = uriBuilder.path("/items/{id}").buildAndExpand(item.getId()).toUri();
        return ResponseEntity.created(uri).body(new ItemsDetailDto(item));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<ItemsDetailDto> update(@RequestBody ItemsUpdateDto dados) {
        var item = itemsService.update(dados);
        return ResponseEntity.ok(new ItemsDetailDto(item));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        itemsService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
