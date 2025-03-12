package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.dto.customers.CustomersDetailDto;
import br.com.dev.MechGear.dto.customers.CustomersDto;
import br.com.dev.MechGear.dto.customers.CustomersUpdateDto;
import br.com.dev.MechGear.service.CustomerService;
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
@RequestMapping("customers")
public class CustomersController {

    @Autowired
    private CustomerService customerService;

    @GetMapping
    public ResponseEntity<Page<CustomersDetailDto>> getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = customerService.getAll(paginacao);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomersDetailDto> getById(@PathVariable Long id) {
        var customer = customerService.getById(id);
        return ResponseEntity.ok(new CustomersDetailDto(customer));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@Valid @RequestBody CustomersDto dados, UriComponentsBuilder uriBuilder) {
        var customer = customerService.create(dados);
        var uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomersDetailDto(customer));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity<CustomersDetailDto> update(@RequestBody CustomersUpdateDto dados) {
        var customer = customerService.update(dados);
        return ResponseEntity.ok(new CustomersDetailDto(customer));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        customerService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
