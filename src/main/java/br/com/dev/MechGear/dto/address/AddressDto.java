package br.com.dev.MechGear.dto.address;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record AddressDto(
        @NotBlank
        String street,
        String number,
        String complement,
        @NotBlank
        String neighborhood,
        @NotBlank
        String city,
        @NotBlank
        String state,
        @NotBlank @Pattern(regexp = "\\d{8}", message = "CEP inválido.")
        String zipCode
) {
}