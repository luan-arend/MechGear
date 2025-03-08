package br.com.dev.MechGear.dto.customers;

import br.com.dev.MechGear.dto.address.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CustomersDto(
        @NotBlank(message = "Nome é obrigatório.")
        String name,
        @NotBlank(message = "CPF/CNPJ é obrigatório.")
        String cpf_cnpj,
        @NotBlank(message = "Telefone é obrigatório.")
        String phone,
        @Email
        String email,
        @NotNull @Valid
        AddressDto address
) {
}
