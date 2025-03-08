package br.com.dev.MechGear.service;

import br.com.dev.MechGear.domain.customer.CustomersImpl;
import br.com.dev.MechGear.domain.customer.CustomersRepository;
import br.com.dev.MechGear.dto.customers.CustomersDetailDto;
import br.com.dev.MechGear.dto.customers.CustomersDto;
import br.com.dev.MechGear.dto.customers.CustomersUpdateDto;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService {

    @Autowired
    private CustomersRepository repository;

    public Page<CustomersDetailDto> getAllCustomers(Pageable paginacao) {
        return repository.findAll(paginacao).map(CustomersDetailDto::new);
    }

    public CustomersImpl getCustomerById(Long id) {
        return repository.getReferenceById(id);
    }

    public CustomersImpl createCustomer(CustomersDto dados) {
        var customer = new CustomersImpl(dados);
        repository.save(customer);
        return customer;
    }

    public CustomersImpl updateCustomer(CustomersUpdateDto dados) {
        var customer = getCustomerById(dados.id());
        customer.update(dados);
        return customer;
    }

    public void deleteCustomer(Long id) {
        repository.deleteById(id);
    }
}
