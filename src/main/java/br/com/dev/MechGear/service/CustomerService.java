package br.com.dev.MechGear.service;

import br.com.dev.MechGear.domain.customer.CustomersImpl;
import br.com.dev.MechGear.domain.customer.CustomersRepository;
import br.com.dev.MechGear.dto.customers.CustomersDetailDto;
import br.com.dev.MechGear.dto.customers.CustomersDto;
import br.com.dev.MechGear.dto.customers.CustomersUpdateDto;
import br.com.dev.MechGear.infra.exception.ValidateException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class CustomerService {

    @Autowired
    private CustomersRepository repository;

    public Page<CustomersDetailDto> getAll(Pageable paginacao) {
        return repository.findAll(paginacao).map(CustomersDetailDto::new);
    }

    public CustomersImpl getById(Long id) {
        return repository.getReferenceById(id);
    }

    public CustomersImpl create(CustomersDto dados) {
        boolean exists = repository.existsByCpfCnpj(dados.cpfCnpj());

        if (exists) {
            throw new ValidateException("Cliente já cadastrado na base de dados.", HttpStatus.BAD_REQUEST);
        }

        var customer = new CustomersImpl(dados);
        repository.save(customer);
        return customer;
    }

    public CustomersImpl update(CustomersUpdateDto dados) {
        var customer = getById(dados.id());
        customer.update(dados);
        return customer;
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }
}
