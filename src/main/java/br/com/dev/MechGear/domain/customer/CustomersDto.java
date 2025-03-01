package br.com.dev.MechGear.domain.customer;

import br.com.dev.MechGear.domain.address.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomersDto(
        @NotBlank
        String name,
        @NotBlank
        String cpf_cnpj,
        @NotBlank
        String phone,
        @Email
        String email,
        @NotNull @Valid
        AddressDto address
) {
}
