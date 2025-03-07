package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.domain.customer.*;
import br.com.dev.MechGear.dto.customers.CustomersDetailDto;
import br.com.dev.MechGear.dto.customers.CustomersDto;
import br.com.dev.MechGear.dto.customers.CustomersUpdateDto;
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
    private CustomersRepository repository;

    @GetMapping
    public ResponseEntity<Page<CustomersDetailDto>> getAll(@PageableDefault(size = 10, sort = {"name"}) Pageable paginacao) {
        var page = repository.findAll(paginacao).map(CustomersDetailDto::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var customer = repository.getReferenceById(id);
        return ResponseEntity.ok(new CustomersDetailDto(customer));
    }

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody CustomersDto dados, UriComponentsBuilder uriBuilder) {
        var customer = new CustomersImpl(dados);
        repository.save(customer);

        var uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomersDetailDto(customer));
    }

    @PutMapping()
    @Transactional
    public ResponseEntity update(@RequestBody CustomersUpdateDto dados) {
        var customer = repository.getReferenceById(dados.id());
        customer.update(dados);
        return ResponseEntity.ok(new CustomersDetailDto(customer));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
