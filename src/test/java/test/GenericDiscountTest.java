package test;

import discounts.GenericDiscount;
import entities.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GenericDiscountTest {
    private Product benAndJerrys;
    private Product milk;
    private GenericDiscount benAndJerrysDiscount;

    @BeforeEach
    public void setUp() {
        benAndJerrys = new Product("1", "Ben & Jerry's", 59.90, 1, LocalDate.now(), LocalDate.now());
        milk = new Product("2", "Milk", 20.0, 10, LocalDate.now(), LocalDate.now());

        benAndJerrysDiscount = new GenericDiscount(
                (product, discount) -> product.name().equalsIgnoreCase("Ben & Jerry's") ? product.price() * 0.25 : 0,
                (product, discount) -> "25% discount on Ben & Jerry's"
        );
    }

    @Test
    public void testBenAndJerrysDiscount() {
        assertEquals(14.975, benAndJerrysDiscount.apply(benAndJerrys), 0.01); // Adjust expected value
        assertEquals("25% discount on Ben & Jerry's", benAndJerrysDiscount.getDescription(benAndJerrys));
    }

    @Test
    public void testBenAndJerrysDiscountNotApplicable() {
        double discountAmount = benAndJerrysDiscount.apply(milk);
        assertEquals(0.0, discountAmount);
        assertEquals("", benAndJerrysDiscount.getDescription(milk));
    }
}