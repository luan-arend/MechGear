package br.com.dev.MechGear.domain.customer;

import br.com.dev.MechGear.dto.customers.CustomersUpdateDto;

public interface Customers {
    void update(CustomersUpdateDto dados);
}
