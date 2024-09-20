import entities.Product;
import discounts.Discount;
import discounts.FridayDiscount;
import discounts.MilkDiscount;
import discounts.QuantityDiscount;
import discounts.GenericDiscount;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // Skapa produkter
        Product milk = new Product("1", "Milk", 20.0, 10, LocalDate.now(), LocalDate.now());
        Product bread = new Product("2", "Bread", 30.0, 4, LocalDate.now(), LocalDate.now());
        Product benAndJerrys = new Product("1", "Ben & Jerry's", 59.90, 1, LocalDate.now(), LocalDate.now());

        // Skapa rabatter
        Discount fridayDiscount = new FridayDiscount(null);
        Discount milkDiscount = new MilkDiscount(fridayDiscount);
        Discount quantityDiscount = new QuantityDiscount(null);

// Skapa rabatten med GenericDiscount för 35% rabatt
        GenericDiscount benAndJerrysDiscount = new GenericDiscount(
                (product, discount) -> product.name().equalsIgnoreCase("Ben & Jerry's") ? product.price() * 0.25 : 0,
                (product, discount) -> "25% discount on Ben & Jerry's"
        );

        double discountAmount = benAndJerrysDiscount.apply(benAndJerrys);
        String description = benAndJerrysDiscount.getDescription(benAndJerrys);

        // Tillämpa rabatter
        System.out.println("Original price of Milk: " + milk.price());
        System.out.println("Discounted price of Milk: " + milkDiscount.apply(milk));
        System.out.println("Description of Milk Discount: " + milkDiscount.getDescription(milk));
        System.out.println("------------------------------------------------------------------");
        System.out.println("Original price of Bread: " + bread.price());
        System.out.println("Discounted price of Bread: " + quantityDiscount.apply(bread));
        System.out.println("Description of Quantity Discount: " + quantityDiscount.getDescription(bread));
        System.out.println("------------------------------------------------------------------");
        // Kontrollera om rabatter gäller
        System.out.println("Is Friday discount applicable to Milk? " + fridayDiscount.isApplicable(milk));
        System.out.println("Is Milk discount applicable to Bread? " + milkDiscount.isApplicable(bread));
        System.out.println("------------------------------------------------------------------");

    //Kontrollera Ben%Jerry rabatt
        System.out.println("Generic Discount for Ben & Jerry's");
        System.out.println("Original price of Ben & Jerry's: " + benAndJerrys.price());
        System.out.println("Discounted amount: " + discountAmount);
        System.out.println("Description: " + description);
    }
}
