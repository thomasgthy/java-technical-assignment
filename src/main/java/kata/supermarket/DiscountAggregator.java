package kata.supermarket;

import kata.supermarket.models.Item;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public class DiscountAggregator {

    private List<Discount> discounts;

    public DiscountAggregator(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public BigDecimal applyDiscounts(List<Item> items){
        return discounts
                .stream()
                .map(discount -> discount.applyDiscount(items))
                .reduce(BigDecimal::add)
                .orElse(BigDecimal.ZERO)
                .setScale(2, RoundingMode.HALF_UP);
    }

}
