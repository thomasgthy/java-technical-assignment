package kata.supermarket;

import java.math.BigDecimal;
import java.util.List;

public class DiscountAggregator {

    private List<Discount> discounts;

    public DiscountAggregator(List<Discount> discounts) {
        this.discounts = discounts;
    }

    public BigDecimal applyDiscounts(List<Item> items){
        return BigDecimal.ZERO;
    }

}
