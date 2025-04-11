package br.com.dev.MechGear.domain.items;

import br.com.dev.MechGear.domain.AbstractBaseEntity;
import br.com.dev.MechGear.dto.items.ItemsDto;
import br.com.dev.MechGear.dto.items.ItemsUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "items")
@Entity(name = "Items")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ItemsImpl extends AbstractBaseEntity implements Items {

    private String name;
    private String description;
    private String code;
    private String category;
    private Integer quantity;
    private Integer min_quantity;
    private Double unit_price;
    private Double cost_price;
    private String supplier;
    private String location;

    public ItemsImpl(ItemsDto dados) {
        this.name = dados.name();
        this.description = dados.description();
        this.code = dados.code();
        this.category = dados.category();
        this.quantity = dados.quantity();
        this.min_quantity = dados.min_quantity();
        this.unit_price = dados.unit_price();
        this.cost_price = dados.cost_price();
        this.supplier = dados.supplier();
        this.location = dados.location();
    }

    @Override
    public void update(ItemsUpdateDto dados) {
        if (dados.name() != null) {
            this.name = dados.name();
        }
        if (dados.description() != null) {
            this.description = dados.description();
        }
        if (dados.code() != null) {
            this.code = dados.code();
        }
        if (dados.category() != null) {
            this.category = dados.category();
        }
        if (dados.quantity() != null) {
            this.quantity = dados.quantity();
        }
        if (dados.min_quantity() != null) {
            this.min_quantity = dados.min_quantity();
        }
        if (dados.unit_price() != null) {
            this.unit_price = dados.unit_price();
        }
        if (dados.cost_price() != null) {
            this.cost_price = dados.cost_price();
        }
        if (dados.supplier() != null) {
            this.supplier = dados.supplier();
        }
        if (dados.location() != null) {
            this.location = dados.location();
        }
    }
}