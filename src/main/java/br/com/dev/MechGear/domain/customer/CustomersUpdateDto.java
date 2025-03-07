package br.com.dev.MechGear.domain.customer;

import br.com.dev.MechGear.domain.address.Address;
import br.com.dev.MechGear.domain.address.AddressDto;
import jakarta.validation.constraints.NotNull;

public record CustomersUpdateDto(
        @NotNull
        Long id,
        String name,
        String cpf_cnpj,
        String phone,
        String email,
        AddressDto address
) {
}
