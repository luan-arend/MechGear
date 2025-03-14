package br.com.dev.MechGear.domain.items;

import br.com.dev.MechGear.dto.items.ItemsDto;
import br.com.dev.MechGear.dto.items.ItemsUpdateDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "items")
@Entity(name = "Items")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class ItemsImpl implements Items {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
    private LocalDateTime created_at;
    private LocalDateTime updated_at;

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
        this.created_at = LocalDateTime.now();
        this.updated_at = LocalDateTime.now();
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
        this.updated_at = LocalDateTime.now();
    }
}