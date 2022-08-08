package kata.supermarket.models;

import java.math.BigDecimal;

public class ItemByUnit implements Item {

    private final Long id;
    private final Product product;

    ItemByUnit(Long id, final Product product) {
        this.id = id;
        this.product = product;
    }

    public BigDecimal price() {
        return product.pricePerUnit();
    }

    public Long getId() {
        return id;
    }
}
