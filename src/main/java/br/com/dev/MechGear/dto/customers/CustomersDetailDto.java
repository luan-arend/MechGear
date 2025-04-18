package br.com.dev.MechGear.dto.customers;

import br.com.dev.MechGear.domain.address.Address;
import br.com.dev.MechGear.domain.customer.CustomersImpl;

public record CustomersDetailDto(
        Long id,
        String name,
        String cpfCnpj,
        String phone,
        String email,
        Address address
) {
    public CustomersDetailDto(CustomersImpl customers) {
        this(customers.getId(), customers.getName(), customers.getCpfCnpj(), customers.getPhone(), customers.getEmail(), customers.getAddress());
    }
}
