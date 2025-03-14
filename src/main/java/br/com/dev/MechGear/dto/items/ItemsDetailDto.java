package br.com.dev.MechGear.dto.items;

import br.com.dev.MechGear.domain.items.ItemsImpl;

public record ItemsDetailDto(
        Long id,
        String name,
        String description,
        String code,
        String category,
        Integer quantity,
        Integer min_quantity,
        Double unit_price,
        Double cost_price,
        String supplier,
        String location
) {
    public ItemsDetailDto(ItemsImpl items) {
        this(items.getId(), items.getName(), items.getDescription(), items.getCode(), items.getCategory(), items.getQuantity(), items.getMin_quantity(), items.getUnit_price(), items.getCost_price(), items.getSupplier(), items.getLocation());
    }
}
