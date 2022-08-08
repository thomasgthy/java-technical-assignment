package kata.supermarket;

import kata.supermarket.models.Item;

import java.math.BigDecimal;
import java.util.List;

public interface Discount {
    BigDecimal applyDiscount(List<Item> items);
}
