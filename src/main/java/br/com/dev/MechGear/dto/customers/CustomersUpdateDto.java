package br.com.dev.MechGear.dto.customers;

import br.com.dev.MechGear.dto.address.AddressDto;
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
