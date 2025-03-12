package br.com.dev.MechGear.domain.address;

import br.com.dev.MechGear.dto.address.AddressDto;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String street;
    private String number;
    private String complement;
    private String neighborhood;
    private String city;
    private String state;
    @Column(name = "zipCode")
    private String zipCode;

    public Address(AddressDto addressDto){
        this.street = addressDto.street();
        this.number = addressDto.number();
        this.complement = addressDto.complement();
        this.neighborhood = addressDto.neighborhood();
        this.city = addressDto.city();
        this.state = addressDto.state();
        this.zipCode = addressDto.zipCode();
    }

    public void update(AddressDto dados) {
        if (dados.street() != null) {
            this.street = dados.street();
        }
        if (dados.number() != null) {
            this.number = dados.number();
        }
        if (dados.complement() != null) {
            this.complement = dados.complement();
        }
        if (dados.neighborhood() != null) {
            this.neighborhood = dados.neighborhood();
        }
        if (dados.city() != null) {
            this.city = dados.city();
        }
        if (dados.state() != null) {
            this.state = dados.state();
        }
        if (dados.zipCode() != null) {
            this.zipCode = dados.zipCode();
        }
    }
}
