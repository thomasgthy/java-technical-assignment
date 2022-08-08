package kata.supermarket.discounts;

import kata.supermarket.Discount;
import kata.supermarket.models.Item;
import kata.supermarket.models.ItemByUnit;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class TwoForOneDiscount implements Discount {

    private final Long id;

    public TwoForOneDiscount(Long id) {
        this.id = id;
    }
    @Override
    public BigDecimal applyDiscount(List<Item> items) {
        return items
                .stream()
                .filter(item -> item instanceof ItemByUnit)
                .filter(item -> ((ItemByUnit) item).getId().equals(this.id))
                .limit(items.size()/2)
                .map(item -> item.price())
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }
}
