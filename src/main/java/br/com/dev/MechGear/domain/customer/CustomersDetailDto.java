package br.com.dev.MechGear.domain.customer;

import br.com.dev.MechGear.domain.address.Address;

public record CustomersDetailDto(
        Long id,
        String name,
        String cpf_cnpj,
        String phone,
        String email,
        Address address
) {
    public CustomersDetailDto(Customers customers) {
        this(customers.getId(), customers.getName(), customers.getCpf_cnpj(), customers.getPhone(), customers.getEmail(), customers.getAddress());
    }
}
