package kata.supermarket;

import kata.supermarket.discounts.TwoForOneDiscount;
import kata.supermarket.models.Item;
import kata.supermarket.models.Product;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwoForOneDiscountTest {
    @DisplayName("basket provides its total value when containing...")
    @MethodSource
    @ParameterizedTest(name = "{0}")
    void basketProvidesTotalValue(String description, String expectedTotal, Iterable<Item> items) {
        final Basket basket = new Basket(Arrays.asList(new TwoForOneDiscount(1L)));
        items.forEach(basket::add);
        assertEquals(new BigDecimal(expectedTotal), basket.total());
    }

    private static Stream<Arguments> basketProvidesTotalValue() {
        return Stream.of(
                aSingleItemPricedPerUnit(),
                twoForOneDiscountedItems()
        );
    }

    private static Arguments aSingleItemPricedPerUnit() {
        return Arguments.of("a single item priced per unit", "0.49", Collections.singleton(aPintOfMilk()));
    }

    private static Arguments twoForOneDiscountedItems() {
        return Arguments.of("2 items priced per unit with 2 for 1 discount", "0.49", Arrays.asList(aPintOfMilk(), aPintOfMilk()));
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).oneOf(1L);
    }
}
