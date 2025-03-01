package br.com.dev.MechGear.domain.address;

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
    private String zip_code;

    public Address(AddressDto addressDto){
        this.street = addressDto.street();
        this.number = addressDto.number();
        this.complement = addressDto.complement();
        this.neighborhood = addressDto.neighborhood();
        this.city = addressDto.city();
        this.state = addressDto.state();
        this.zip_code = addressDto.zip_code();
    }
}
