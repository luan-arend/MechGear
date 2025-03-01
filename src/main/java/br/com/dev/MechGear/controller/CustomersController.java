package br.com.dev.MechGear.controller;

import br.com.dev.MechGear.domain.customer.Customers;
import br.com.dev.MechGear.domain.customer.CustomersDetailDto;
import br.com.dev.MechGear.domain.customer.CustomersDto;
import br.com.dev.MechGear.domain.customer.CustomersRepository;
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

    @PostMapping
    @Transactional
    public ResponseEntity create(@RequestBody CustomersDto customersDto, UriComponentsBuilder uriBuilder) {
        var customer = new Customers(customersDto);
        repository.save(customer);

        var uri = uriBuilder.path("/customers/{id}").buildAndExpand(customer.getId()).toUri();
        return ResponseEntity.created(uri).body(new CustomersDetailDto(customer));
    }

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

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity deleteById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
