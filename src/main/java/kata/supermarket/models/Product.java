package kata.supermarket.models;

import java.math.BigDecimal;

public class Product {
    private final BigDecimal pricePerUnit;

    public Product(final BigDecimal pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    BigDecimal pricePerUnit() {
        return pricePerUnit;
    }

    public Item oneOf(Long id) {
        return new ItemByUnit(id, this);
    }
}
