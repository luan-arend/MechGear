package br.com.dev.MechGear.dto.customers;

import br.com.dev.MechGear.dto.address.AddressDto;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record CustomersDto(
        @NotBlank(message = "Nome é obrigatório.")
        String name,
        @NotBlank(message = "CPF/CNPJ é obrigatório.") @Pattern(regexp = "\\d{11}|\\d{14}", message = "CPF/CNPJ inválido.")
        String cpfCnpj,
        @NotBlank(message = "Telefone é obrigatório.")
        String phone,
        @Email @NotBlank(message = "Email é obrigatório.")
        String email,
        @NotNull @Valid
        AddressDto address
) {
}
