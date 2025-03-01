package br.com.dev.MechGear.domain.customer;

import br.com.dev.MechGear.domain.address.Address;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "customers")
@Entity(name = "Customers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Customers {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cpf_cnpj;

    private String name;

    private String phone;

    private String email;

    private LocalDateTime created_at;

    private LocalDateTime updated_at;

    @Embedded
    private Address address;

    public Customers(CustomersDto customersDto){
        this.cpf_cnpj = customersDto.cpf_cnpj();
        this.name = customersDto.name();
        this.phone = customersDto.phone();
        this.email = customersDto.email();
        this.address = new Address(customersDto.address());
    }
}
