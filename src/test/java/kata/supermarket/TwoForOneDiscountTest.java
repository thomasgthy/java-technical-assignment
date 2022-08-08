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
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
                customItemsPricedPerUnit(1, "0.49"),
                customItemsPricedPerUnit(2, "0.49"),
                customItemsPricedPerUnit(3, "0.98"),
                customItemsPricedPerUnit(10, "2.45")
        );
    }

    private static Arguments customItemsPricedPerUnit(int size, String expectedTotal) {
        return Arguments.of(
                size + "item(s) priced per unit",
                expectedTotal,
                IntStream.range(0, size).mapToObj(x -> aPintOfMilk()).collect(Collectors.toList()));
    }

    private static Item aPintOfMilk() {
        return new Product(new BigDecimal("0.49")).oneOf(1L);
    }
}
