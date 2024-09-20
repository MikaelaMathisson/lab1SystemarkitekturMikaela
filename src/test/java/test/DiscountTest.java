package test;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import discounts.*;
import entities.Product;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

public class DiscountTest {
    private Product milk;
    private Product bread;
    private Discount fridayDiscount;
    private Discount milkDiscount;
    private Discount quantityDiscount;
    private Discount allDiscounts;

    @BeforeEach
    public void setUp() {
        milk = new Product("1", "Milk", 20.0, 10, LocalDate.now(), LocalDate.now());
        bread = new Product("2", "Bread", 30.0, 4, LocalDate.now(), LocalDate.now());

        fridayDiscount = new FridayDiscount(null);
        milkDiscount = new MilkDiscount(fridayDiscount);
        quantityDiscount = new QuantityDiscount(null);
        allDiscounts = new MilkDiscount(new QuantityDiscount(new FridayDiscount(null)));
    }

    @Test
    public void testMilkDiscount() {
        Product product = new Product("1", "Milk", 30.0, 3, LocalDate.now(), LocalDate.now());
        Discount discount = new MilkDiscount(null);

        assertTrue(discount.isApplicable(product));
        assertEquals(1.5, discount.apply(product), 0.01); // Adjust expected value
    }

    @Test
    public void testFridayDiscount() {
        Product product = new Product("2", "Bread", 30.0, 3, LocalDate.of(2024, 9, 19), LocalDate.now()); // Example on Thursday
        Discount discount = new FridayDiscount(null, LocalDate.of(2024, 9, 19)); // Set to Thursday

        assertFalse(discount.isApplicable(product)); // Expected to be false

        // Simulate Friday
        discount = new FridayDiscount(null, LocalDate.of(2024, 9, 20)); // Set to Friday
        assertTrue(discount.isApplicable(product)); // Expected to be true
    }

    @Test
    public void testQuantityDiscount() {
        assertEquals(100.0, quantityDiscount.apply(milk));
        assertEquals(0.0, quantityDiscount.apply(bread));
    }

    @Test
    public void testDescription() {
        Discount discount = new FridayDiscount(new MilkDiscount(new QuantityDiscount(null)));
        Product product = new Product("1", "Milk", 20.0, 6, LocalDate.now(), LocalDate.now()); // Adjust quantity to match discount

        assertEquals("10% Friday discount 5% discount on Milk 10 SEK per product if quantity is 5 or more", discount.getDescription(product));
    }
}