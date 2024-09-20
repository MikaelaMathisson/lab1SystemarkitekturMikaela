package discounts;

import entities.Product;

public class MilkDiscount extends BaseDiscount {
    public MilkDiscount(Discount nextDiscount) {
        super(nextDiscount);
    }

    @Override
    protected boolean isApplicableInternal(Product product) {
        return product.name().equals("Milk");
    }

    @Override
    protected double calculateDiscount(Product product) {
        return product.price() * 0.05;
    }

    @Override
    protected String getDescriptionText() {
        return "5% discount on Milk";
    }
}