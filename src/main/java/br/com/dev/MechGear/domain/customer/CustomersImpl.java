package br.com.dev.MechGear.domain.customer;

import br.com.dev.MechGear.domain.AbstractBaseEntity;
import br.com.dev.MechGear.domain.address.Address;
import br.com.dev.MechGear.dto.customers.CustomersDto;
import br.com.dev.MechGear.dto.customers.CustomersUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "customers")
@Entity(name = "Customers")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CustomersImpl extends AbstractBaseEntity implements Customers {

    @Column(name = "cpfCnpj")
    private String cpfCnpj;
    private String name;
    private String phone;
    private String email;

    @Embedded
    private Address address;

    public CustomersImpl(CustomersDto customersDto){
        this.cpfCnpj = customersDto.cpfCnpj();
        this.name = customersDto.name();
        this.phone = customersDto.phone();
        this.email = customersDto.email();
        this.address = new Address(customersDto.address());
    }

    @Override
    public void update(CustomersUpdateDto dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.cpfCnpj() != null) {
            this.cpfCnpj = dados.cpfCnpj();
        }
        if (dados.phone() != null) {
            this.phone = dados.phone();
        }
        if (dados.email() != null) {
            this.email = dados.email();
        }
        if (dados.address() != null) {
            this.address.update(dados.address());
        }
    }
}
