import entities.Product;
import discounts.Discount;
import discounts.FridayDiscount;
import discounts.MilkDiscount;
import discounts.QuantityDiscount;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Skapa produkter
        Product milk = new Product("1", "Milk", 20.0, 10, LocalDate.now(), LocalDate.now());
        Product bread = new Product("2", "Bread", 30.0, 4, LocalDate.now(), LocalDate.now());

        // Skapa rabatter
        Discount fridayDiscount = new FridayDiscount(null);
        Discount milkDiscount = new MilkDiscount(fridayDiscount);
        Discount quantityDiscount = new QuantityDiscount(null);

        // Tillämpa rabatter
        System.out.println("Original price of Milk: " + milk.price());
        System.out.println("Discounted price of Milk: " + milkDiscount.apply(milk));
        System.out.println("Description of Milk Discount: " + milkDiscount.getDescription(milk));

        System.out.println("Original price of Bread: " + bread.price());
        System.out.println("Discounted price of Bread: " + quantityDiscount.apply(bread));
        System.out.println("Description of Quantity Discount: " + quantityDiscount.getDescription(bread));

        // Kontrollera om rabatter gäller
        System.out.println("Is Friday discount applicable to Milk? " + fridayDiscount.isApplicable(milk));
        System.out.println("Is Milk discount applicable to Bread? " + milkDiscount.isApplicable(bread));
    }
}
