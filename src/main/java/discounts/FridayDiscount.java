package discounts;

import entities.Product;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class FridayDiscount extends BaseDiscount {
    private LocalDate currentDate;

    public FridayDiscount(Discount nextDiscount) {
        super(nextDiscount);
        this.currentDate = LocalDate.now(); // Standard till nuvarande datum
    }

    // Konstruktor för testning
    public FridayDiscount(Discount nextDiscount, LocalDate currentDate) {
        super(nextDiscount);
        this.currentDate = currentDate;
    }

    @Override
    protected boolean isApplicableInternal(Product product) {
        return currentDate.getDayOfWeek() == DayOfWeek.FRIDAY;
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.10; // 10% rabatt
    }

    @Override
    protected String getDescriptionText() {
        return "10% Friday discount";
    }
}